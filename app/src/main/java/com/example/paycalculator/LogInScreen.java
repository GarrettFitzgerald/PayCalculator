package com.example.paycalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInScreen extends AppCompatActivity
{
    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;

    Button btn_clear;
    Button btn_login;
    Button btn_signup;
    EditText edt_username;
    EditText edt_password;

    Button btn_confirm;
    Button btn_back;

    EditText edt_firstname;
    EditText edt_lastname;
    EditText edt_passwordenter;
    EditText edt_passwordconfirm;
    EditText edt_email;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_screen);

        btn_clear = findViewById( R.id.btn_clear);
        btn_login = findViewById( R.id.btn_login);
        btn_signup = findViewById( R.id.btn_signup);
        edt_username = findViewById( R.id.edt_username);
        edt_password = findViewById( R.id.edt_password);

        btn_clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                edt_username.setText("");
                edt_password.setText("");
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (edt_username.getText().toString().equals("admin") &&
                    edt_password.getText().toString().equals("admin"))
                {
                    Intent intentGoToInformation = new Intent(LogInScreen.this, Information.class);
                    startActivity(intentGoToInformation);
                }
                else
                {
                    Toast.makeText(LogInScreen.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                createNewSignUpDialog();
            }
        });
    }

    public void createNewSignUpDialog()
    {
        dialogBuilder = new AlertDialog.Builder( LogInScreen.this );
        View inputSignUpPopUpView = getLayoutInflater().inflate( R.layout.popup_signup, null );

        btn_back = inputSignUpPopUpView.findViewById( R.id.btn_back );
        btn_confirm = inputSignUpPopUpView.findViewById( R.id.btn_confirm );

        dialogBuilder.setView( inputSignUpPopUpView );
        dialog = dialogBuilder.create();
        dialog.show();

        btn_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dialog.dismiss();
            }
        });

        btn_confirm.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dialog.dismiss(); //Will be replaced with Account Creation with Database
            }
        });
    }

}