package com.example.paycalculator;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class DbHandler extends SQLiteOpenHelper
{

    private static final String DB_NAME = "payCalcDb";
    private static final int DB_VERSION = 17;

    private static final String TABLE_NAME = "users";
    private static final String USER_PK = "userPK";
    private static final String USER_COL = "username";
    private static final String FIRSTNAME_COL = "firstname";
    private static final String LASTNAME_COL = "lastname";
    private static final String PASSWORD_COL = "password";
    private static final String JOBTITLE_COL = "jobtitle";
    private static final String PAYGRADE_COL = "paygrade";
    private static final String KIWISAVER_COL = "kiwisaver";
    private static final String UNION_COL = "unions";
    private static final String STUDENTLOAN_COL = "studentloan";
    private static final String PARKINGCARD_COL = "parkingcard";

    private static final String TABLE2_NAME = "paycycles";
    private static final String ID_PAYCYCLES = "id";
    private static final String ID_USERS = "userid";
    private static final String START_DATE = "startdate";
    private static final String WEEK1_MON = "WeekOne_Monday";
    private static final String WEEK1_TUES = "WeekOne_Tuesday";
    private static final String WEEK1_WED = "WeekOne_Wednesday";
    private static final String WEEK1_THURS = "WeekOne_Thursday";
    private static final String WEEK1_FRI = "WeekOne_Friday";
    private static final String WEEK1_SAT = "WeekOne_Saturday";
    private static final String WEEK1_SUN = "WeekOne_Sunday";
    private static final String WEEK2_MON = "WeekTwo_Monday";
    private static final String WEEK2_TUES = "WeekTwo_Tuesday";
    private static final String WEEK2_WED = "WeekTwo_Wednesday";
    private static final String WEEK2_THURS = "WeekTwo_Thursday";
    private static final String WEEK2_FRI = "WeekTwo_Friday";
    private static final String WEEK2_SAT = "WeekTwo_Saturday";
    private static final String WEEK2_SUN = "WeekTwo_Sunday";

    public DbHandler(Context context)
    {
        super( context, DB_NAME, null, DB_VERSION  );
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String tableOne = "CREATE TABLE " + TABLE_NAME +
                                        " (" +
                                        USER_PK + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        USER_COL + " TEXT," +
                                        FIRSTNAME_COL + " TEXT," +
                                        LASTNAME_COL +  " TEXT," +
                                        PASSWORD_COL + " TEXT," +
                                        JOBTITLE_COL + " INTEGER," +
                                        PAYGRADE_COL + " INTEGER," +
                                        KIWISAVER_COL + " INTEGER," +
                                        UNION_COL + " INTEGER," +
                                        STUDENTLOAN_COL + " INTEGER," +
                                        PARKINGCARD_COL + " INTEGER" +
                                        ")";
        db.execSQL( tableOne );

        String tableTwo = "CREATE TABLE " + TABLE2_NAME +
                                        " (" +
                                        ID_PAYCYCLES + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ID_USERS + " INTEGER," +
                                        START_DATE + " LOCALDATE," +
                                        WEEK1_MON + " TEXT," +
                                        WEEK1_TUES + " TEXT," +
                                        WEEK1_WED + " TEXT," +
                                        WEEK1_THURS + " TEXT," +
                                        WEEK1_FRI + " TEXT," +
                                        WEEK1_SAT + " TEXT," +
                                        WEEK1_SUN + " TEXT," +
                                        WEEK2_MON + " TEXT," +
                                        WEEK2_TUES + " TEXT," +
                                        WEEK2_WED + " TEXT," +
                                        WEEK2_THURS + " TEXT," +
                                        WEEK2_FRI + " TEXT," +
                                        WEEK2_SAT + " TEXT," +
                                        WEEK2_SUN + " TEXT" +
                                        ")";
        db.execSQL( tableTwo );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE2_NAME);
        onCreate(db);
    }

    public void insertUserDetails( UserModal userModal)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(USER_COL, userModal.getUsername());
        values.put(FIRSTNAME_COL, userModal.getFirstName());
        values.put(LASTNAME_COL, userModal.getlastName());
        values.put(PASSWORD_COL, userModal.getPassword());
        values.put(JOBTITLE_COL, userModal.getJobTitle());
        values.put(PAYGRADE_COL, userModal.getPaygrade());
        values.put(KIWISAVER_COL, userModal.getKiwisaver());
        values.put(UNION_COL, userModal.getUnion());
        values.put(STUDENTLOAN_COL, userModal.getStudentLoan());
        values.put(PARKINGCARD_COL, userModal.getParkingCard());

        long newRowID = db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void insertTableDetails( PayCycleModal payCycleModal )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ID_USERS, payCycleModal.getIdUser());
        values.put(START_DATE, payCycleModal.getStartDate().toString());
        values.put(WEEK1_MON, payCycleModal.getWeekOne_Monday());
        values.put(WEEK1_TUES, payCycleModal.getWeekOne_Tuesday());
        values.put(WEEK1_WED, payCycleModal.getWeekOne_Wednesday());
        values.put(WEEK1_THURS, payCycleModal.getWeekOne_Thursday());
        values.put(WEEK1_FRI, payCycleModal.getWeekOne_Friday());
        values.put(WEEK1_SAT, payCycleModal.getWeekOne_Saturday());
        values.put(WEEK1_SUN, payCycleModal.getWeekOne_Sunday());
        values.put(WEEK2_MON, payCycleModal.getWeekTwo_Monday());
        values.put(WEEK2_TUES, payCycleModal.getWeekTwo_Tuesday());
        values.put(WEEK2_WED, payCycleModal.getWeekTwo_Wednesday());
        values.put(WEEK2_THURS, payCycleModal.getWeekTwo_Thursday());
        values.put(WEEK2_FRI, payCycleModal.getWeekTwo_Friday());
        values.put(WEEK2_SAT, payCycleModal.getWeekTwo_Saturday());
        values.put(WEEK2_SUN, payCycleModal.getWeekTwo_Sunday());

        long newRowID = db.insert(TABLE2_NAME, null, values);

        db.close();
    }

    public Boolean loginCheck( String username, String password )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from users where username = ? and password = ?";
        Cursor cursor = db.rawQuery( query, new String[] {username, password});

        if(cursor.getCount() > 0 )
        {
            cursor.close();
            return true;
        }
        else
        {
            cursor.close();
            return false;
        }
    }

    public int getCurrentUserID( String username )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM users WHERE username = ?";
        Cursor c = db.rawQuery(query, new String[] {username});

        int currentID = 0;

        if(c != null && c.moveToFirst())
        {
            currentID = c.getInt(0);
        }
        c.close();

        return currentID;
    }

    @SuppressLint("Range")
    public HashMap<String, String> getUserDetails( int currentID )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        HashMap<String, String> userDetails = new HashMap<>();
        String query = "SELECT * FROM users WHERE userPK = " + currentID;
        Cursor c = db.rawQuery(query, null);

        if(c != null && c.moveToNext())
        {
            userDetails.put("firstname", c.getString(c.getColumnIndex(FIRSTNAME_COL)));
            userDetails.put("lastname", c.getString(c.getColumnIndex(LASTNAME_COL)));
            userDetails.put("jobtitle", String.valueOf(c.getInt(c.getColumnIndex(JOBTITLE_COL))));
            userDetails.put("paygrade", String.valueOf(c.getInt(c.getColumnIndex(PAYGRADE_COL))));
            userDetails.put("kiwisaver", String.valueOf(c.getInt(c.getColumnIndex(KIWISAVER_COL))));
            userDetails.put("union", String.valueOf(c.getInt(c.getColumnIndex(UNION_COL))));
            userDetails.put("studentloan", String.valueOf(c.getInt(c.getColumnIndex(STUDENTLOAN_COL))));
            userDetails.put("parkingcard", String.valueOf(c.getInt(c.getColumnIndex(PARKINGCARD_COL))));
            c.close();
        }

        return userDetails;
    }

    public void updateUserDetails( int currentID, int jobTitle, int payGrade, int kiwisaver,
                                   int union, int studentLoan, int parkingCard )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(JOBTITLE_COL, jobTitle);
        contentValues.put(PAYGRADE_COL, payGrade);
        contentValues.put(KIWISAVER_COL, kiwisaver);
        contentValues.put(UNION_COL, union);
        contentValues.put(STUDENTLOAN_COL, studentLoan);
        contentValues.put(PARKINGCARD_COL, parkingCard);

        db.update(TABLE_NAME, contentValues, USER_PK + " = ?", new String[] {String.valueOf(currentID)});
    }

    public void updatePayCycleDetails( int currentID, LocalDate currentCycle, String mondayone,
                                       String tuesdayone, String wednesdayone, String thursdayone,
                                       String fridayone, String saturdayone, String sundayone,
                                       String mondaytwo, String tuesdaytwo, String wednesdaytwo,
                                       String thursdaytwo, String fridaytwo, String saturdaytwo,
                                       String sundaytwo)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(WEEK1_MON, mondayone);
        contentValues.put(WEEK1_TUES, tuesdayone);
        contentValues.put(WEEK1_WED, wednesdayone);
        contentValues.put(WEEK1_THURS, thursdayone);
        contentValues.put(WEEK1_FRI, fridayone);
        contentValues.put(WEEK1_SAT, saturdayone);
        contentValues.put(WEEK1_SUN, sundayone);
        contentValues.put(WEEK2_MON, mondaytwo);
        contentValues.put(WEEK2_TUES, tuesdaytwo);
        contentValues.put(WEEK2_WED, wednesdaytwo);
        contentValues.put(WEEK2_THURS, thursdaytwo);
        contentValues.put(WEEK2_FRI, fridaytwo);
        contentValues.put(WEEK2_SAT, saturdaytwo);
        contentValues.put(WEEK2_SUN, sundaytwo);

        db.update(TABLE2_NAME, contentValues, "userid = " + currentID + " AND startdate = ?" ,
                  new String[] {currentCycle.toString()});
    }

    public Boolean checkPayCycleExists( int currentID, LocalDate cycleCheck )
    {
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT userid, startdate FROM paycycles WHERE userid = " + currentID + " AND startdate = ?";
        Cursor c = db.rawQuery(query, new String[]{ cycleCheck.toString()} );

        if(c.getCount() > 0 )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @SuppressLint("Range")
    public HashMap<String, String> getPayCycleTable( int currentID, LocalDate currentCycle )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        HashMap<String, String> tableDetails = new HashMap<>();
        String query = "SELECT * FROM paycycles WHERE userID = " + currentID + " AND startdate = ?";
        Cursor c = db.rawQuery(query, new String[]{ currentCycle.toString()});

        if(c != null && c.moveToNext())
        {
            tableDetails.put("startdate", String.valueOf(c.getString(c.getColumnIndex(START_DATE))));
            tableDetails.put("W1_Monday", c.getString(c.getColumnIndex(WEEK1_MON)));
            tableDetails.put("W1_Tuesday", c.getString(c.getColumnIndex(WEEK1_TUES)));
            tableDetails.put("W1_Wednesday", c.getString(c.getColumnIndex(WEEK1_WED)));
            tableDetails.put("W1_Thursday", c.getString(c.getColumnIndex(WEEK1_THURS)));
            tableDetails.put("W1_Friday", c.getString(c.getColumnIndex(WEEK1_FRI)));
            tableDetails.put("W1_Saturday", c.getString(c.getColumnIndex(WEEK1_SAT)));
            tableDetails.put("W1_Sunday", c.getString(c.getColumnIndex(WEEK1_SUN)));
            tableDetails.put("W2_Monday", c.getString(c.getColumnIndex(WEEK2_MON)));
            tableDetails.put("W2_Tuesday", c.getString(c.getColumnIndex(WEEK2_TUES)));
            tableDetails.put("W2_Wednesday", c.getString(c.getColumnIndex(WEEK2_WED)));
            tableDetails.put("W2_Thursday", c.getString(c.getColumnIndex(WEEK2_THURS)));
            tableDetails.put("W2_Friday", c.getString(c.getColumnIndex(WEEK2_FRI)));
            tableDetails.put("W2_Saturday", c.getString(c.getColumnIndex(WEEK2_SAT)));
            tableDetails.put("W2_Sunday", c.getString(c.getColumnIndex(WEEK2_SUN)));
            c.close();
        }
        return tableDetails;
    }
}
