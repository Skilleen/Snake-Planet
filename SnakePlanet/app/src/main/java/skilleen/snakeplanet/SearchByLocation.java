package skilleen.snakeplanet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

import skilleen.snakeplanet.Model.SnakeModel;
import skilleen.snakeplanet.Tables.DBAdapter;

/**
 * Created by Scilleen on 9/21/2015.
 */
public class SearchByLocation extends AppCompatActivity {

    public Context ctx;
    private DBAdapter dbHelper;
    private SimpleCursorAdapter dataAdapter;
    public static Cursor currentSnake;
    public String region;
    public ArrayList<SnakeModel> snakeListForCurrentRegion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_by_location);
        dbHelper = new DBAdapter(this);
        dbHelper.open();
        //Clean all data
        dbHelper.deleteAllSnakes();
        //Add some data
        dbHelper.insertSomeSnakes();

        //Generate ListView from SQLite Database
        displayListView();

    }

    private void displayListView() {

        Bundle b = getIntent().getExtras();
        String country = b.getString("country");
        Cursor cursor = dbHelper.fetchSnakesByLocation(country);

        // The desired columns to be bound
        String[] columns = new String[] {
                DBAdapter.SNAKE_PICTURE,
                DBAdapter.SNAKE_NAME,
        };

        // the XML defined views which the data will be bound to
        int[] to = new int[] {
                R.id.snakeListImage,
                R.id.label,
        };

        // create the adapter using the cursor pointing to the desired data
        //as well as the layout information
        dataAdapter = new SimpleCursorAdapter(
                this, R.layout.snake_listview,
                cursor,
                columns,
                to,
                0);

        ListView listView = (ListView) findViewById(R.id.locationList);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view,
                                    int position, long id) {
                // Get the cursor, positioned to the corresponding row in the result set
                currentSnake = (Cursor) listView.getItemAtPosition(position);
                Intent snakeLayout = new Intent(SearchByLocation.this, SnakeLayout.class);
                Bundle b = new Bundle();
                b.putInt("currentSnake", 1); //1 for location
                snakeLayout.putExtras(b);
                startActivity(snakeLayout);


            }
        });


    }
}
