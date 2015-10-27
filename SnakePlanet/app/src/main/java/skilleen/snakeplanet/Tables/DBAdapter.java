package skilleen.snakeplanet.Tables;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import java.sql.SQLException;
import java.util.ArrayList;

import skilleen.snakeplanet.Model.SnakeModel;
import skilleen.snakeplanet.R;

/**
 * Created by Scilleen on 9/24/2015.
 */
public class DBAdapter {

    public static final String SNAKE_ID = "_id";
    public static final String SNAKE_PICTURE = "picture";
    public static final String SNAKE_NAME = "name";
    public static final String SNAKE_DANGER = "danger";
    public static final String SNAKE_LOCATION = "location";
    public static final String SNAKE_DISC = "disc";
    public static final String SNAKE_FOOD = "food";
    public static final String SNAKE_PREDATORS = "predators";
    public static final String SNAKE_FIRSTAID = "firstAid";
    private static final String DATABASE_NAME = "thesnakedata.db";
    private static final String DATABASE_TABLE = "SnakeDetails";
    public static Context context;
    private static final String TAG = "SnakesDbAdapter";
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;


    private static final int DATABASE_VERSION = 1;

    private final Context mCtx;

    private static final String DATABASE_CREATE =
            "CREATE TABLE if not exists " + DATABASE_TABLE + " (" +
                    SNAKE_ID + " integer PRIMARY KEY autoincrement," +
                    SNAKE_PICTURE + "," +
                    SNAKE_NAME + "," +
                    SNAKE_DANGER + "," +
                    SNAKE_LOCATION + "," +
                    SNAKE_DISC + "," +
                    SNAKE_FOOD + "," +
                    SNAKE_PREDATORS + "," +
                    SNAKE_FIRSTAID + " );";

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.w(TAG, DATABASE_CREATE);
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }

    public DBAdapter(Context ctx) {
        this.mCtx = ctx;
    }

    public DBAdapter open() {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        if (mDbHelper != null) {
            mDbHelper.close();
        }
    }

    /*
* Creating a SnakeModel
*/
    public long createSnake(SnakeModel snakemodel) {

        ContentValues values = new ContentValues();
        values.put(SNAKE_ID, snakemodel.getId());
        values.put(SNAKE_PICTURE, snakemodel.getPicture());
        values.put(SNAKE_NAME, snakemodel.getName());
        values.put(SNAKE_DANGER, snakemodel.getDanger());
        values.put(SNAKE_LOCATION, snakemodel.getLocation());
        values.put(SNAKE_DISC, snakemodel.getDisc());
        values.put(SNAKE_FOOD, snakemodel.getFood());
        values.put(SNAKE_PREDATORS, snakemodel.getPredators());
        values.put(SNAKE_FIRSTAID, snakemodel.getFirstAid());
        // insert row
        long snake_id = mDb.insert(DATABASE_TABLE, null, values);

        return snake_id;
    }


    public boolean deleteAllSnakes() {

        int doneDelete = 0;
        doneDelete = mDb.delete(DATABASE_TABLE, null, null);
        Log.w(TAG, Integer.toString(doneDelete));
        return doneDelete > 0;

    }

    public Cursor fetchSnakesByName(String inputText) {
        Log.w(TAG, inputText);
        Cursor mCursor = null;
        if (inputText == null || inputText.length() == 0) {
            mCursor = mDb.query(DATABASE_TABLE, new String[]{SNAKE_ID,
                            SNAKE_PICTURE, SNAKE_NAME, SNAKE_DANGER, SNAKE_LOCATION, SNAKE_DISC, SNAKE_FOOD, SNAKE_PREDATORS, SNAKE_FIRSTAID},
                    null, null, null, null, null);

        } else {
            mCursor = mDb.query(true, DATABASE_TABLE, new String[]{SNAKE_ID,
                            SNAKE_PICTURE, SNAKE_NAME, SNAKE_DANGER, SNAKE_LOCATION, SNAKE_DISC, SNAKE_FOOD, SNAKE_PREDATORS, SNAKE_FIRSTAID},
                    SNAKE_NAME + " like '%" + inputText + "%'", null,
                    null, null, null, null);
        }
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

    public Cursor fetchSnakesByLocation(String locationText) {
        Log.w(TAG, locationText);
        Cursor mCursor = null;
        mCursor = mDb.query(true, DATABASE_TABLE, new String[]{SNAKE_ID,
                        SNAKE_PICTURE, SNAKE_NAME, SNAKE_DANGER, SNAKE_LOCATION, SNAKE_DISC, SNAKE_FOOD, SNAKE_PREDATORS, SNAKE_FIRSTAID},
                SNAKE_LOCATION + " like '%" + locationText + "%'", null,
                null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public Cursor getSnakes() {

        Cursor mCursor;
        mCursor = mDb.query(true, DATABASE_TABLE, new String[]{SNAKE_ID,
                        SNAKE_PICTURE, SNAKE_NAME, SNAKE_DANGER, SNAKE_LOCATION, SNAKE_DISC, SNAKE_FOOD, SNAKE_PREDATORS, SNAKE_FIRSTAID},
                SNAKE_NAME + " like '%" + "swag" + "%'", null,
                null, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

}



