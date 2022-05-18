package com.example.paycalculator;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class MyCursorAdaptor extends CursorAdapter
{
    public MyCursorAdaptor(Context context, Cursor c)
    {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent)
    {
        return LayoutInflater.from(context).inflate(R.layout.listview_userlist, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor)
    {
        TextView lst_firstname = (TextView) view.findViewById(R.id.lst_firstname);
        TextView lst_lastname = (TextView) view.findViewById(R.id.lst_lastname);
        TextView lst_jobtitle = (TextView) view.findViewById(R.id.lst_jobtitle);
        TextView lst_username = (TextView) view.findViewById(R.id.lst_username);

        String firstName = cursor.getString(cursor.getColumnIndexOrThrow("firstname"));
        String lastName = cursor.getString(cursor.getColumnIndexOrThrow("lastname"));
        String jobTitle = cursor.getString(cursor.getColumnIndexOrThrow("jobtitle"));
        String username = cursor.getString(cursor.getColumnIndexOrThrow("username"));

        lst_firstname.setText(firstName);
        lst_lastname.setText(lastName);
        lst_jobtitle.setText(jobTitle);
        lst_username.setText(username);
    }
}
