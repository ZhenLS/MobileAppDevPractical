package com.example.practical_mobileappdevelopment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class SQLiteAdapter {
    public static final String MYDATABASE_NAME = "MY_DATABASE_2";
    public static final String MYDATABASE_TABLE = "MY_TABLE_FOOD";
    public static final int MYDATABASE_VERSION = 2;
    public static final String KEY_CONTENT = "Content";     // column
    public static final String KEY_CONTENT_2 = "Ingredient";
    public static final String VALUE = "Price";

    private static final String SCRIPT_CREATE_DATABASE =
            "create table " +
                    MYDATABASE_TABLE + " ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + KEY_CONTENT + " text not null, "
                    + KEY_CONTENT_2 + " text, "
                    + VALUE + " int);";

    private SQLiteHelper sqLiteHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Context context;

    public SQLiteAdapter(Context c) {
        context = c;
    }

    /**
     * Open Table to read data
     */
    public SQLiteAdapter openToRead() throws
            android.database.SQLException {
        sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null,
                MYDATABASE_VERSION);
        sqLiteDatabase = sqLiteHelper.getReadableDatabase();
        return this;
    }

    public SQLiteAdapter openToWrite() throws
            android.database.SQLException {
        sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null,
                MYDATABASE_VERSION);
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        sqLiteHelper.close();
    }

    public long insert(String content, String content_2, int content_3) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_CONTENT, content);
        contentValues.put(KEY_CONTENT_2, content_2);
        contentValues.put(VALUE, content_3);

        return sqLiteDatabase.insert(MYDATABASE_TABLE, null,
                contentValues);
    }

    public int deleteAll() {
        return sqLiteDatabase.delete(MYDATABASE_TABLE, null, null);
    }

    public String queueMultipleColumn() {
        String[] columns = new String[]{KEY_CONTENT, KEY_CONTENT_2, VALUE};
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns,
                null, null, null, null, null);
        String result = "";

        /** Get Column ID*/
        int index_CONTENT = cursor.getColumnIndex(KEY_CONTENT);
        int index_CONTENT_2 = cursor.getColumnIndex(KEY_CONTENT_2);
        int index_CONTENT_3 = cursor.getColumnIndex(VALUE);
        /** */
        for (cursor.moveToFirst(); !(cursor.isAfterLast());
             cursor.moveToNext()) {
            result = result + cursor.getString(index_CONTENT) + "; "
                    + cursor.getString(index_CONTENT_2) + "; "
                    + cursor.getString(index_CONTENT_3)
                    + "\n";
        }
        return result;
    }

    /**
     * Q3 Select
     * SELECT Content, Content_2, Value FROM MY_TABLE_Form
     * WHERE Content_2 == 'RICE' OR Content_2 == 'Flour'
     *
     * @return
     */
    public String queueMultipleColumnOnSelection() {
        String[] columns = new String[]{KEY_CONTENT, KEY_CONTENT_2, VALUE};
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns,
                KEY_CONTENT_2 + "=? OR " + KEY_CONTENT_2 + "=?",
                new String[]{"Rice", "Flour"}, null, null, null);
        String result = "";

        /** Get Column ID*/
        int index_CONTENT = cursor.getColumnIndex(KEY_CONTENT);
        int index_CONTENT_2 = cursor.getColumnIndex(KEY_CONTENT_2);
        int index_CONTENT_3 = cursor.getColumnIndex(VALUE);
        /** */
        for (cursor.moveToFirst(); !(cursor.isAfterLast());
             cursor.moveToNext()) {
            result = result + cursor.getString(index_CONTENT) + "; "
                    + cursor.getString(index_CONTENT_2) + "; "
                    + cursor.getString(index_CONTENT_3)
                    + "\n";
        }
        return result;
    }

    /**
     * Q4 Order BY
     * SELECT Content, Content_2, Value FROM MY_TABLE_Form
     * WHERE Content_2 == 'RICE' OR Content_2 == 'Flour'
     * ORDER BY Content ASC
     *
     * @return
     */
    public String queueWithOrder() {
        String[] columns = new String[]{KEY_CONTENT, KEY_CONTENT_2, VALUE};
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns,
                KEY_CONTENT_2 + "=? OR " + KEY_CONTENT_2 + "=?",
                new String[]{"Rice", "Flour"}, null, null, VALUE + " DESC");
        String result = "";

        /** Get Column ID*/
        int index_CONTENT = cursor.getColumnIndex(KEY_CONTENT);
        int index_CONTENT_2 = cursor.getColumnIndex(KEY_CONTENT_2);
        int index_CONTENT_3 = cursor.getColumnIndex(VALUE);
        /** Loop Through Data*/
        for (cursor.moveToFirst(); !(cursor.isAfterLast());
             cursor.moveToNext()) {
            result = result + cursor.getString(index_CONTENT) + "; "
                    + cursor.getString(index_CONTENT_2) + "; "
                    + cursor.getString(index_CONTENT_3)
                    + "\n";
        }
        return result;
    }

    /**
     * Q5
     * SELECT Content_2, sum(Value) FROM MY_TABLE_Form
     * GROUP BY Content_2 (Ingredient)
     * ORDER BY Content DESC
     *
     * @return
     */
    public String sumPriceByIngredient() {
        String[] columns = new String[]{KEY_CONTENT_2, "sum(" + VALUE + ")"};
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns,
                null,
                null, KEY_CONTENT_2, null, "sum(" + VALUE + ") "  + " DESC");
        String result = "";

        /** Get Column ID*/
        int index_CONTENT_2 = cursor.getColumnIndex(KEY_CONTENT_2);
        int index_CONTENT_3 = cursor.getColumnIndex("sum(" + VALUE + ")");
        /** Loop Through Data*/
        for (cursor.moveToFirst(); !(cursor.isAfterLast());
             cursor.moveToNext()) {
            result = result
                    + cursor.getString(index_CONTENT_2) + "; "
                    + cursor.getString(index_CONTENT_3)
                    + "\n";
        }
        return result;
    }

    public class SQLiteHelper extends SQLiteOpenHelper {
        public SQLiteHelper(Context context, String name,
                            CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SCRIPT_CREATE_DATABASE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int
                newVersion) {
            db.execSQL(SCRIPT_CREATE_DATABASE);
        }
    }
}
