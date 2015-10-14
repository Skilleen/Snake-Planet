package skilleen.snakeplanet;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        setContentView(R.layout.search_by_name);
        String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("STRING_I_NEED");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("STRING_I_NEED");
        }
        dbHelper = new DBAdapter(this);
        dbHelper.open();
        //Clean all data
      //  if(newString.equals("STRING_I_NEED")) {
            ArrayList<SnakeModel> easternCanadaSnakes = new ArrayList();
            snakeListForCurrentRegion = dbHelper.getEasternCanadaSnakeList();
            SnakeAdapter adapter = new SnakeAdapter(this, snakeListForCurrentRegion);
            ListView listView = (ListView) findViewById(R.id.listView1);
            listView.setAdapter(adapter);
        //}
        //Generate ListView from SQLite Database
       // displayListView();


    }
}
