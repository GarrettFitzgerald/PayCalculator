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
    private static final int DB_VERSION = 2;
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

    public DbHandler(Context context)
    {
        super( context, DB_NAME, null, DB_VERSION  );
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String query = "CREATE TABLE " + TABLE_NAME +
                                         " (" +
                                         ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                         USER_COL + " TEXT," +
                                         FIRSTNAME_COL + " TEXT," +
                                         LASTNAME_COL +  " TEXT," +
                                         PASSWORD_COL + " TEXT," +
                                         JOBTITLE_COL + " INTEGER," +
                                         PAYGRADE_COL + " INTEGER," +
                                         KIWISAVER_COL + " INTEGER," +
                                         UNION_COL + " BOOLEAN," +
                                         STUDENTLOAN_COL + " BOOLEAN," +
                                         PARKINGCARD_COL + " BOOLEAN" +
                                         ")";
        db.execSQL( query );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
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

    public ArrayList<UserModal> getUserDetails(String usernameEntered )
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM users";
        Cursor c = db.rawQuery(query, null);

        ArrayList<UserModal> userDetails = new ArrayList<>();

        c.moveToFirst();

        while(userDetails.size() < 1 )
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
}
