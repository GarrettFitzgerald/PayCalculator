package com.example.paycalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UserList extends AppCompatActivity
{
    int currentID;

    ListView userlist;
    Button btn_toInformation;
    Button btn_back;
    TextView txt_userdelete;
    TextView btn_deleteuser;
    List<String> usernameArray = new ArrayList<>();

    DbHandler db = new DbHandler(UserList.this);
    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        currentID = getIntent().getIntExtra("CurrentID", 0);

        btn_toInformation = findViewById(R.id.btn_toInformation);

        DbHandler handler = new DbHandler(this);
        SQLiteDatabase db = handler.getWritableDatabase();
        String query = "SELECT * FROM users ORDER BY username";
        Cursor cursor = db.rawQuery( query, null);

        for( cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext())
        {
            usernameArray.add(cursor.getString(cursor.getColumnIndex("username")));
        }

        userlist = findViewById(R.id.lst_userlist);
        MyCursorAdaptor cursorAdaptor = new MyCursorAdaptor(this, cursor);
        userlist.setAdapter(cursorAdaptor);

        userlist.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                String username = usernameArray.get(position);
                createUserDeleteDialog( username );
            }
        });

        btn_toInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent toLoginScreen=new Intent(UserList.this, LogInScreen.class);
                startActivity(toLoginScreen);
                finish();
            }
        });
    }

    // Creating Delete Dialog
    public void createUserDeleteDialog( String username)
    {
// Setting Up
        dialogBuilder = new AlertDialog.Builder( UserList.this );
        View inputDeleteUserPopupView = getLayoutInflater().inflate( R.layout.popup_deleteuser, null );
// Setting Objects
        txt_userdelete = inputDeleteUserPopupView.findViewById(R.id.txt_userdelete);
        btn_deleteuser = inputDeleteUserPopupView.findViewById(R.id.btn_deleteuser);
        btn_back = inputDeleteUserPopupView.findViewById(R.id.btn_back);
// Loading Dialog
        dialogBuilder.setView( inputDeleteUserPopupView );
        dialog = dialogBuilder.create();
        dialog.show();
// Setting the user
        txt_userdelete.setText(username.toUpperCase());
// Adding functions to buttons
        btn_deleteuser.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                db.deleteUser( username );
                Toast.makeText( UserList.this, txt_userdelete.getText().toString().toUpperCase() + " has been removed",
                        Toast.LENGTH_SHORT).show();
                Intent toUserList=new Intent(UserList.this, UserList.class);
                startActivity(toUserList);
                finish();
                dialog.dismiss();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dialog.dismiss();
            }
        });
    }
}