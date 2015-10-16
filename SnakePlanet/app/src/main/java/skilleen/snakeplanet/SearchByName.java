package skilleen.snakeplanet;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.io.Console;
import java.util.ArrayList;

import skilleen.snakeplanet.Model.SnakeModel;
import skilleen.snakeplanet.Tables.DBAdapter;

/**
 * Created by Scilleen on 9/21/2015.
 */
public class SearchByName extends ActionBarActivity {

    public Context ctx;
    private DBAdapter dbHelper;
    private SimpleCursorAdapter dataAdapter;
    public static Cursor currentSnake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_by_name);
        dbHelper = new DBAdapter(this);
        dbHelper.open();
        //Clean all data
        dbHelper.deleteAllSnakes();
        //Add some data
        dbHelper.insertSomeSnakes();

        //Generate ListView from SQLite Database
        displayListView();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_screen, menu);
        return true;
    }


    private void displayListView() {


        Cursor cursor = dbHelper.getSnakes();

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

        ListView listView = (ListView) findViewById(R.id.nameList);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view,
                                    int position, long id) {
                // Get the cursor, positioned to the corresponding row in the result set
                currentSnake = (Cursor) listView.getItemAtPosition(position);
                Intent snakeLayout = new Intent(SearchByName.this, SnakeLayout.class);
                Bundle b = new Bundle();
                b.putInt("currentSnake", 0); //1 for location
                snakeLayout.putExtras(b);
                startActivity(snakeLayout);


            }
        });

        EditText myFilter = (EditText) findViewById(R.id.myFilter);
        myFilter.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                dataAdapter.getFilter().filter(s.toString());
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                dataAdapter.getFilter().filter(s.toString());
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                dataAdapter.getFilter().filter(s.toString());
            }
        });

        dataAdapter.setFilterQueryProvider(new FilterQueryProvider() {
            public Cursor runQuery(CharSequence constraint) {
                return dbHelper.fetchSnakesByName(constraint.toString());
            }
        });

    }
}
