package com.example.paycalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DbHandler extends SQLiteOpenHelper
{

    private static final String DB_NAME = "payCalcDb";
    private static final int DB_VERSION = 3;

    private static final String TABLE_NAME = "users";
    private static final String ID_COL = "id";
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
    private static final String WEEK1_MON = "w1mon";
    private static final String WEEK1_TUES = "w1tues";
    private static final String WEEK1_WED = "w1wed";
    private static final String WEEK1_THURS = "w1thurs";
    private static final String WEEK1_FRI = "w1fri";
    private static final String WEEK1_SAT = "w1sat";
    private static final String WEEK1_SUN = "w1sun";
    private static final String WEEK2_MON = "w2mon";
    private static final String WEEK2_TUES = "w2tues";
    private static final String WEEK2_WED = "w2wed";
    private static final String WEEK2_THURS = "w2thurs";
    private static final String WEEK2_FRI = "w2fri";
    private static final String WEEK2_SAT = "w2sat";
    private static final String WEEK2_SUN = "w2sun";

    public DbHandler(Context context)
    {
        super( context, DB_NAME, null, DB_VERSION  );
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String tableOne = "CREATE TABLE " + TABLE_NAME +
                                         " (" +
                                         ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
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
                                        ID_USERS + " INTEGER references " +
                                        TABLE_NAME + "( " + USER_COL + " )," +
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

    public Boolean loginCheck( String username, String password )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where username = ? and password = ?", new String[] {username, password});

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

    public ArrayList<UserModal> getUserDetails(String username )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM users WHERE username = ?";
        Cursor c = db.rawQuery("Select * from users where username = ?", new String[] {username});

        ArrayList<UserModal> userDetails = new ArrayList<>();

        c.moveToFirst();

        while(c.moveToNext())
        {
            userDetails.add(new UserModal(c.getString(2),
                    c.getString(3),
                    c.getInt(5),
                    c.getInt(6),
                    c.getInt(7),
                    c.getInt(8),
                    c.getInt(9),
                    c.getInt(10)));
        }
        c.close();
        return userDetails;
    }

    public void updateUserDetails( String username, int jobTitle, int payGrade, int kiwisaver,
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

        db.update(TABLE_NAME, contentValues, USER_COL + " = ?", new String[] {username});

    }
}
