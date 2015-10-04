package skilleen.snakeplanet;

import android.content.Context;

import skilleen.snakeplanet.Model.SnakeModel;
import skilleen.snakeplanet.Tables.DBAdapter;

/**
 * Created by Scilleen on 9/27/2015.
 */
public class PopulateDB {

    public void populate(Context context){
        DBAdapter dba=new DBAdapter(context);
        dba.open();
        DBAdapter.DBHelper helper = new DBAdapter.DBHelper(context);
        SnakeModel snakemodel = new SnakeModel(2, R.drawable.capecobra,"Cape Cobra", "Venomous","Zimbabwe", "Straight Outta Cape Town", "Pizza","Alex", "gg");
        long snakemodel_id = helper.createSnake(snakemodel);
        dba.close();
    }
}
