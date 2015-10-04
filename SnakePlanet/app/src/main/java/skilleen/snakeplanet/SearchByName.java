package skilleen.snakeplanet;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;

import skilleen.snakeplanet.Model.SnakeModel;
import skilleen.snakeplanet.Tables.DBAdapter;

/**
 * Created by Scilleen on 9/21/2015.
 */
public class SearchByName extends ListActivity {

    public Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_by_name);
        //DBAdapter.DBHelper db = new DBAdapter.DBHelper(ctx);
/*
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            ctx = this;

            Cursor c = db.getWordMatches(query, null);*/
            //SnakeModel snakemodel = new SnakeModel(2, R.drawable.capecobra,"Cape Cobra", "Venomous","Zimbabwe", "Straight Outta Cape Town", "Pizza","Alex", "gg");
          //  long snakemodel_id = db.createSnake(snakemodel);
           // ArrayList<SnakeModel> itemsArrayList = new ArrayList<>();
          //  itemsArrayList.add(0,snakemodel);            //
          //SnakeAdapter adapter = new SnakeAdaitemsArrayListter (this, c);

            //2. setListAdapte  //        //  setListAdapte);
      //  }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_screen, menu);
        return true;
    }
}
