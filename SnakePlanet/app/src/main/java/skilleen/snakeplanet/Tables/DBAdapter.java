package skilleen.snakeplanet.Tables;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import java.sql.SQLException;

import skilleen.snakeplanet.Model.SnakeModel;
import skilleen.snakeplanet.R;

/**
 * Created by Scilleen on 9/24/2015.
 */
public class DBAdapter  {

    public static final String SNAKE_ID ="_id";
    public static final String SNAKE_PICTURE ="picture";
    public static final String SNAKE_NAME ="name";
    public static final String SNAKE_DANGER ="danger";
    public static final String SNAKE_LOCATION ="location";
    public static final String SNAKE_DISC ="disc";
    public static final String SNAKE_FOOD ="food";
    public static final String SNAKE_PREDATORS ="predators";
    public static final String SNAKE_FIRSTAID ="firstAid";
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
                    SNAKE_FIRSTAID  +" );";

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
        doneDelete = mDb.delete(DATABASE_TABLE, null , null);
        Log.w(TAG, Integer.toString(doneDelete));
        return doneDelete > 0;

    }

    public Cursor fetchSnakesByName(String inputText) {
        Log.w(TAG, inputText);
        Cursor mCursor = null;
        if (inputText == null  ||  inputText.length () == 0)  {
            mCursor = mDb.query(DATABASE_TABLE, new String[] {SNAKE_ID,
                            SNAKE_PICTURE, SNAKE_NAME, SNAKE_DANGER, SNAKE_LOCATION, SNAKE_DISC, SNAKE_FOOD, SNAKE_PREDATORS, SNAKE_FIRSTAID},
                    null, null, null, null, null);

        }
        else {
            mCursor = mDb.query(true, DATABASE_TABLE, new String[] {SNAKE_ID,
                            SNAKE_PICTURE, SNAKE_NAME, SNAKE_DANGER, SNAKE_LOCATION, SNAKE_DISC, SNAKE_FOOD, SNAKE_PREDATORS, SNAKE_FIRSTAID},
                    SNAKE_NAME + " like '%" + inputText + "%'", null,
                    null, null, null, null);
        }
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

    public Cursor getSnakes() {

        Cursor mCursor;
        mCursor = mDb.query(true, DATABASE_TABLE, new String[] {SNAKE_ID,
                        SNAKE_PICTURE, SNAKE_NAME, SNAKE_DANGER, SNAKE_LOCATION, SNAKE_DISC, SNAKE_FOOD, SNAKE_PREDATORS, SNAKE_FIRSTAID},
                SNAKE_NAME + " like '%" + "swag" + "%'", null,
                null, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public void insertSomeSnakes() {

        SnakeModel snakemodel = new SnakeModel(2, R.drawable.capecobra,"Cape Cobra", "Highly Venomous","South Africa, Namibia, Botswana, Lesotho ",
                "The Cape cobra is a medium sized species of cobra. Mature specimens typically are about 1.2 to 1.4 metres long. Cape cobras varies widely in coloration;" +
                        " it ranges from yellow through golden brown to dark brown and even black. In addition, individuals show a varying degree of black or pale stippling and blotches," +
                        " and although it has been stated that colour and marking are geographically related, it is also possible to observe virtually all colour varieties at one location",
                "This species of cobra is a feeding generalist.[6] It feeds on a wide spectrum of prey, including other snakes, rodents, lizards, birds, and carrion.",
                "Predators of Cape cobras include the honey badger (Ratel).[9] Other carnivorous mammals such as Meerkats and a few species of mongoose often prey on the Cape cobra and are its main predators;",
                "Immediately call for transportation to nearest emergency centre. Keep the victim calm and reassured. Allow him or her to lie flat and avoid as much movement as possible." +
                        " If possible, allow the bitten limb to rest at a level lower than the victim's heart.\n"+ "DO NOT cut or incise the bite site\n" +
                        "DO NOT apply ice to the bite site");
        SnakeModel snakemodel1 = new SnakeModel(3, R.drawable.blackmamba,"Black Mamba", "Venomous","Zimbabwe", "Straight Outta Cape Town", "Pizza","Alex", "gg");
        SnakeModel snakemodel2 = new SnakeModel(4, R.drawable.blueracer,"Blue Racer", "Venomous","Zimbabwe", "Straight Outta Cape Town", "Pizza","Alex", "gg");
        SnakeModel snakemodel3 = new SnakeModel(5, R.drawable.gaboonviper,"Gaboon Viper", "Venomous","Zimbabwe", "Straight Outta Cape Town", "Pizza","Alex", "gg");
        SnakeModel snakemodel4 = new SnakeModel(6, R.drawable.kingcobra,"King Cobra", "Venomous","Zimbabwe", "Straight Outta Cape Town", "Pizza","Alex", "gg");
        SnakeModel snakemodel5 = new SnakeModel(7, R.drawable.pitviper,"Pit Viper", "Venomous","Zimbabwe", "Straight Outta Cape Town", "Pizza","Alex", "gg");
        createSnake(snakemodel);
        createSnake(snakemodel2);
        createSnake(snakemodel3);
        createSnake(snakemodel4);
        createSnake(snakemodel1);
        createSnake(snakemodel5);

    }

}
/*
    public DBAdapter(Context ctx) {
        this.context = ctx;
        dbHelper = new DBHelper(context);
        Log.d("DBAdapter: ", "DBAdapter Creating ..");
    }

    private SQLiteDatabase db;

    public DBAdapter open(){
        db=dbHelper.getWritableDatabase();
        return this; }

    // close the database
    public void close(){
        dbHelper.close();
    }

    private static String DATABASE_CREATE;
    private static final int DATABASE_VERSION = 1;

    public static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            Log.d("DBHelper :","DBHelper Creating .."); }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d("DB: ", "DB Creating ..");
           // db.delete(DATABASE_TABLE, null,null);
            DATABASE_CREATE= "create table "+DATABASE_TABLE+"("+SNAKE_ID+" INTEGER PRIMARY KEY," + SNAKE_PICTURE+" text not null" + SNAKE_NAME+" text not null" + SNAKE_DANGER+" text not null"
                    + SNAKE_LOCATION+" text not null" + SNAKE_DISC+" text not null" + SNAKE_FOOD+" text not null" + SNAKE_PREDATORS+" text not null" + SNAKE_FIRSTAID+" text not null" + " )";
            db.execSQL(DATABASE_CREATE); }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);

        }



        public Cursor getWordMatches(String query, String[] columns) {
            String selection = DATABASE_TABLE + " MATCH ?";
            String[] selectionArgs = new String[] {query+"*"};

            return query(selection, selectionArgs, columns);
        }

        private Cursor query(String selection, String[] selectionArgs, String[] columns) {
            SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
            builder.setTables(DATABASE_TABLE);
            final DBHelper mDatabaseOpenHelper = this;
            Cursor cursor = builder.query(mDatabaseOpenHelper.getReadableDatabase(),
                    columns, selection, selectionArgs, null, null, null);

            if (cursor == null) {
                return null;
            } else if (!cursor.moveToFirst()) {
                cursor.close();
                return null;
            }
            return cursor;
        }
    }*/

