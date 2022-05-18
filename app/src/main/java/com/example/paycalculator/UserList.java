package com.example.paycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class UserList extends AppCompatActivity
{
    ListView userlist;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        DbHandler handler = new DbHandler(this);
        SQLiteDatabase db = handler.getWritableDatabase();
        String query = "SELECT * FROM users";
        Cursor cursor = db.rawQuery( query, null);

        userlist = findViewById(R.id.lst_userlist);
        MyCursorAdaptor cursorAdaptor = new MyCursorAdaptor(this, cursor);
        userlist.setAdapter(cursorAdaptor);
    }
}