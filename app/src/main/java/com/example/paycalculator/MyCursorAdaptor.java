package com.example.paycalculator;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
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
        ImageView lst_icon = (ImageView) view.findViewById(R.id.lst_icon);
        TextView lst_firstname = (TextView) view.findViewById(R.id.lst_name);
        TextView lst_jobtitle = (TextView) view.findViewById(R.id.lst_job);
        TextView lst_username = (TextView) view.findViewById(R.id.lst_username);

        String name = cursor.getString(cursor.getColumnIndexOrThrow("lastname")) + ", " +
                           cursor.getString(cursor.getColumnIndexOrThrow("firstname"));

        String jobTitle;
        if(cursor.getString(cursor.getColumnIndexOrThrow("jobtitle")).toString().equals("0"))
        {
            jobTitle = "Orderly";
        }
        else if(cursor.getString(cursor.getColumnIndexOrThrow("jobtitle")).toString().equals("1"))
        {
            jobTitle = "Security";
        }
        else
        {
            jobTitle = "Supervisor";
        }

        String username = cursor.getString(cursor.getColumnIndexOrThrow("username"));

        lst_icon.setBackgroundResource(R.drawable.noprofilepic);
        lst_firstname.setText(name);
        lst_jobtitle.setText(jobTitle);
        lst_username.setText(username);
    }
}
