package skilleen.snakeplanet;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
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
      ImageView picture = (ImageView) findViewById(R.id.picture);
      TextView name = (TextView) findViewById(R.id.name);
      TextView danger = (TextView) findViewById(R.id.danger);
      TextView location = (TextView) findViewById(R.id.location);
      TextView disc = (TextView) findViewById(R.id.disc);
      TextView food = (TextView) findViewById(R.id.food);
      TextView predators = (TextView) findViewById(R.id.predators);
      TextView firstAid = (TextView) findViewById(R.id.firstaid);

      picture.setImageResource(snake.getInt(1));
      picture.setScaleType(ImageView.ScaleType.FIT_XY);
      name.setText(snake.getString(2));
      danger.setText(snake.getString(3));
      if(snake.getString(3).equals("Venomous") || snake.getString(3).equals("Highly Venomous")){
          danger.setTextColor(Color.parseColor("#FFFF0E1A"));
      }
      location.setText(snake.getString(4));
      disc.setText(snake.getString(5));
      food.setText(snake.getString(6));
      predators.setText(snake.getString(7));
      firstAid.setText(snake.getString(8));

  }



}
