package com.chris.app.saveme.adapters;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.chris.app.saveme.models.DealModel;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DealAdapter {

    private static final String KEY_ID = " _id";
    private static final String KEY_SAVE_TYPE = "saveType";
    private static final String KEY_TITLE = "title";
    private static final String KEY_LINK = "link";
    private static final String KEY_RETAILER = "retailer";
    private static final String KEY_URL_IMAGE = "urlImage";
    private static final String KEY_TAGS = "tags";
    private static final String KEY_USER = "user";
    private static final String KEY_VOTES = "votes";
    private static final String KEY_PRICE = "price";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_START_DATE = "image";
    private static final String KEY_END_DATE = "image";
    private static final String KEY_CREATED = "image";

    private static final String TAG = "DealsDbAdapter";
    private static final String DATABASE_NAME = "saveme_1";
    private static final String SQLITE_TABLE = "Deals";
    private static final int DATABASE_VERSION = 3;

    private static final String CREATE_DEALS_TABLE =
            "CREATE TABLE "
                    + SQLITE_TABLE + "(" +
                    " _id INTEGER PRIMARY KEY,  "
                    + KEY_SAVE_TYPE + " TEXT,"
                    + KEY_TITLE + " TEXT,"
                    + KEY_LINK + " URL,"
                    + KEY_RETAILER + " TEXT,"
                    + KEY_URL_IMAGE + " URL,"
                    + KEY_TAGS + " URL,"
                    + KEY_VOTES + " INT,"
                    + KEY_PRICE + " LONG,"
                    + KEY_IMAGE + " URL,"
                    + KEY_START_DATE + " TEXT,"
                    + KEY_END_DATE + " URL,"
                    + KEY_CREATED + " URL,"
                    + KEY_USER + " TEXT "
                    + ")";

    private final Context mCtx;
    // Login Table Columns names
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    public DealAdapter(Context ctx) {
        this.mCtx = ctx;
    }

    public DealAdapter open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        if (mDbHelper != null) {
            mDbHelper.close();
        }
    }

    public void createDeal(DealModel deal) {


        ContentValues values = new ContentValues();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String created = sdf.format(deal.getCreated());
        String startdate = sdf.format(deal.getStartdate());
        String enddate = sdf.format(deal.getEnddate());

        values.put(KEY_SAVE_TYPE, deal.getSaveType()); // Email
        values.put(KEY_TITLE, deal.getTitle()); // Email
        values.put(KEY_LINK, deal.getLink()); // Email
        values.put(KEY_RETAILER, deal.getRetailer()); // Email

        values.put(KEY_URL_IMAGE, deal.getUrlImage()); // Email
        values.put(KEY_TAGS, deal.getTags()); // Email
        values.put(KEY_VOTES, deal.getVotes()); // Email
        values.put(KEY_PRICE, deal.getPrice()); // Email

        values.put(KEY_IMAGE, String.valueOf(deal.getImage())); // Email
        values.put(KEY_START_DATE, startdate); // Email
        values.put(KEY_END_DATE, enddate); // Email
        values.put(KEY_CREATED, created); // Email

        values.put(KEY_USER, deal.getUser()); // Email

        // Inserting Row
        mDb.insert(SQLITE_TABLE, null, values);
        mDb.close(); // Closing database connection


    }

    public int updateUser(DealModel deal) {

        ContentValues values = new ContentValues();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String created = sdf.format(deal.getCreated());
        String startdate = sdf.format(deal.getStartdate());
        String enddate = sdf.format(deal.getEnddate());

        values.put(KEY_SAVE_TYPE, deal.getSaveType()); // Email
        values.put(KEY_TITLE, deal.getTitle()); // Email
        values.put(KEY_LINK, deal.getLink()); // Email
        values.put(KEY_RETAILER, deal.getRetailer()); // Email

        values.put(KEY_URL_IMAGE, deal.getUrlImage()); // Email
        values.put(KEY_TAGS, deal.getTags()); // Email
        values.put(KEY_VOTES, deal.getVotes()); // Email
        values.put(KEY_PRICE, deal.getPrice()); // Email

        values.put(KEY_IMAGE, String.valueOf(deal.getImage())); // Email
        values.put(KEY_START_DATE, startdate); // Email
        values.put(KEY_END_DATE, enddate); // Email
        values.put(KEY_CREATED, created); // Email

        values.put(KEY_USER, deal.getUser()); // Email

        // updating row
        return mDb.update(SQLITE_TABLE, values, KEY_ID + " = ?",
                new String[]{String.valueOf(deal.get_id())});

    }

    public void deleteAllUsers() {

//        int doneDelete = 0;
//        doneDelete = mDb.delete(SQLITE_TABLE, null, null);
//        Log.w(TAG, Integer.toString(doneDelete));
//        return doneDelete > 0;

    }

    public Cursor fetchAllDeals() {

        Cursor mCursor = mDb.query(SQLITE_TABLE, new String[]{
                        KEY_ID,
                        KEY_SAVE_TYPE,
                        KEY_TITLE,
                        KEY_LINK,
                        KEY_RETAILER,
                        KEY_URL_IMAGE,
                        KEY_TAGS,
                        KEY_VOTES,
                        KEY_PRICE,
                        KEY_IMAGE,
                        KEY_START_DATE,
                        KEY_END_DATE,
                        KEY_CREATED,
                        KEY_USER },
                null, null, null, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;


    }

    public Cursor fetchDealByID(String inputText) throws SQLException {
        Log.w(TAG, inputText);
        Cursor mCursor = null;
        if (inputText == null || inputText.length() == 0) {
            mCursor = mDb.query(SQLITE_TABLE, new String[]{
                            KEY_ID,
                            KEY_SAVE_TYPE,
                            KEY_TITLE,
                            KEY_LINK,
                            KEY_RETAILER,
                            KEY_URL_IMAGE,
                            KEY_TAGS,
                            KEY_VOTES,
                            KEY_PRICE,
                            KEY_IMAGE,
                            KEY_START_DATE,
                            KEY_END_DATE,
                            KEY_CREATED,
                            KEY_USER },
                    null, null, null, null, null, null);

        } else {
            mCursor = mDb.query(true, SQLITE_TABLE, new String[]{
                            KEY_ID,
                            KEY_SAVE_TYPE,
                            KEY_TITLE,
                            KEY_LINK,
                            KEY_RETAILER,
                            KEY_URL_IMAGE,
                            KEY_TAGS,
                            KEY_VOTES,
                            KEY_PRICE,
                            KEY_IMAGE,
                            KEY_START_DATE,
                            KEY_END_DATE,
                            KEY_CREATED,
                            KEY_USER },
                    KEY_ID + " = " + inputText + " ", null, null, null, null, null, null);
        }
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

    public void insertSomeProjects() {

        DealModel deal = new DealModel();

        deal.set_id(0);
        deal.setSaveType("Deal");
        deal.setTitle("Name");
        deal.setLink("http://www.saveme.ie");
        deal.setRetailer("Littlewoods");
        deal.setUrlImage("http://www.saveme.ie/image");
        deal.setTags("Tags");
        deal.setVotes(12);
        deal.setPrice(29.99);
        // deal.setImage();
        deal.setStartdate(new Date());
        deal.setEnddate(new Date());
        deal.setCreated(new Date());
        deal.setUser("Chris Maher");

        createDeal(deal);

    }

    //---deletes a particular deal---
    public boolean deleteDeal(String id) {

        return mDb.delete(SQLITE_TABLE, KEY_ID + "=" + id, null) > 0;

    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.w(TAG, CREATE_DEALS_TABLE);
            db.execSQL(CREATE_DEALS_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + SQLITE_TABLE);
            onCreate(db);
        }
    }

}

