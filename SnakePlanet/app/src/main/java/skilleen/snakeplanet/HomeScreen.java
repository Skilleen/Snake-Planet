package skilleen.snakeplanet;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import skilleen.snakeplanet.Model.SnakeModel;
import skilleen.snakeplanet.Tables.DBAdapter;


public class HomeScreen extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Button nameButton = (Button) findViewById(R.id.nameButton);
        Button locationbutton = (Button) findViewById(R.id.locationButton);
        nameButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent nameActivity = new Intent(HomeScreen.this, SearchByName.class);
                startActivity(nameActivity);
            }
        });
        locationbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent locationActivity = new Intent(HomeScreen.this, MapsActivity.class);
                startActivity(locationActivity);
            }
        });
        ImageView logo = (ImageView) findViewById(R.id.logo);
        logo.setScaleType(ImageView.ScaleType.FIT_XY);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_screen, menu);
        return true;
    }



}
