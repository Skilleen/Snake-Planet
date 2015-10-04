package skilleen.snakeplanet.Tables;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import skilleen.snakeplanet.Model.SnakeModel;

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
    private static final String DATABASE_NAME = "snakedataa.db";
    private static final String DATABASE_TABLE = "SnakeDetails";
    public static Context context;
    public static DBHelper dbHelper;

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

        /*
     * Creating a SnakeModel
     */
        public long createSnake(SnakeModel snakemodel) {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(SNAKE_ID, snakemodel.getId());
            values.put(SNAKE_NAME, snakemodel.getName());

            // insert row
            long snake_id = db.insertWithOnConflict(DATABASE_TABLE, null, values,SQLiteDatabase.CONFLICT_REPLACE);



            return snake_id;
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
    }
}
