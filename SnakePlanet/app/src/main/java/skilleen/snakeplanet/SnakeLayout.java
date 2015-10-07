package skilleen.snakeplanet;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import skilleen.snakeplanet.Model.SnakeModel;
import skilleen.snakeplanet.Tables.DBAdapter;

/**
 * Created by Scilleen on 10/4/2015.
 */
public class SnakeLayout extends Activity {
    private DBAdapter dbHelper;
    private SimpleCursorAdapter dataAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snake_layout);
        fillPage();


    }

  public void fillPage(){
      Cursor snake = SearchByName.currentSnake;
      // The desired columns to be bound
      /*
      String[] columns = new String[] {
              DBAdapter.SNAKE_PICTURE,
              DBAdapter.SNAKE_NAME,
      };

      // the XML defined views which the data will be bound to
      int[] to = new int[] {
              R.id.snakeListImage,
              R.id.label,
      };
      dataAdapter = new SimpleCursorAdapter(
              this, R.layout.snake_listview,
              snake,
              columns,
              to,
              0);*/
      ImageView picture = (ImageView) findViewById(R.id.picture);
      TextView name = (TextView) findViewById(R.id.name);
      TextView danger = (TextView) findViewById(R.id.danger);
      TextView location = (TextView) findViewById(R.id.location);
      TextView disc = (TextView) findViewById(R.id.disc);
      TextView food = (TextView) findViewById(R.id.food);
      TextView predators = (TextView) findViewById(R.id.predators);
      TextView firstAid = (TextView) findViewById(R.id.firstaid);

      picture.setImageResource(snake.getInt(1));
      name.setText(snake.getString(2));
      danger.setText(snake.getString(3));
      location.setText(snake.getString(4));
      disc.setText(snake.getString(5));
      food.setText(snake.getString(6));
      predators.setText(snake.getString(7));
      firstAid.setText(snake.getString(8));

  }



}
