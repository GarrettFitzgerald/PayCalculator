package com.example.paycalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

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

    TextView txt_generatedname;
    EditText edt_firstname;
    EditText edt_lastname;
    EditText edt_passwordenter;
    EditText edt_passwordconfirm;

    DbHandler db = new DbHandler(LogInScreen.this);

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
                String username = edt_username.getText().toString();
                String password = edt_password.getText().toString();

                if( username.equals(""))
                {
                    Toast.makeText( LogInScreen.this, "Please enter a Username", Toast.LENGTH_SHORT).show();
                }
                else if(db.checkUserExists( username ) == false)
                {
                    Toast.makeText( LogInScreen.this, "Username does not exist", Toast.LENGTH_SHORT).show();
                }
                else if( password.equals(""))
                {
                    Toast.makeText( LogInScreen.this, "Please enter a Password", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean loginCheck = db.loginCheck( username, password);
                    if( loginCheck == true )
                    {
                        int currentID = db.getCurrentUserID( username );

                        Toast.makeText(LogInScreen.this, username, Toast.LENGTH_SHORT).show();
                        Toast.makeText(LogInScreen.this, password, Toast.LENGTH_SHORT).show();

                        Toast.makeText( LogInScreen.this, "CurrentID = " + currentID, Toast.LENGTH_SHORT).show();
                        Toast.makeText( LogInScreen.this, "Login Succesful", Toast.LENGTH_SHORT).show();
                        Intent intentToInformation = new Intent( LogInScreen.this, Information.class);
                        intentToInformation.putExtra("CurrentID", currentID );
                        startActivity(intentToInformation);
                    }
                    else
                    {
                        Toast.makeText( LogInScreen.this, "Login Unsuccesful", Toast.LENGTH_SHORT).show();
                    }
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
        txt_generatedname = inputSignUpPopUpView.findViewById( R.id.txt_generatedname);
        edt_firstname = inputSignUpPopUpView.findViewById(R.id.edt_firstname);
        edt_lastname = inputSignUpPopUpView.findViewById(R.id.edt_lastname);
        edt_passwordenter = inputSignUpPopUpView.findViewById(R.id.edt_passwordenter);
        edt_passwordconfirm = inputSignUpPopUpView.findViewById(R.id.edt_passwordconfirm);

        dialogBuilder.setView( inputSignUpPopUpView );
        dialog = dialogBuilder.create();
        dialog.show();

        edt_firstname.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                char[] placeholder = (txt_generatedname.getText().toString()).toCharArray();

                for( int i = 0; i < 3; i++ )
                {
                    if( ( edt_firstname.length() < ( i + 1 ) ))
                    {
                        placeholder[i + 3] = 'x';
                    }
                    else
                    {
                        placeholder[( i + 3 )] = (edt_firstname.getText().toString().toLowerCase()).charAt(i);
                    }
                }
                txt_generatedname.setText(String.valueOf(placeholder));
            }
        });

        edt_lastname.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                {
                    char[] placeholder = (txt_generatedname.getText().toString()).toCharArray();

                    for( int i = 0; i < 3; i++ )
                    {
                        if( ( edt_lastname.length() < ( i + 1 ) ))
                        {
                            placeholder[ i ] = 'x';
                        }
                        else
                        {
                            placeholder[ i ] = (edt_lastname.getText().toString().toLowerCase()).charAt(i);
                        }
                    }
                    txt_generatedname.setText(String.valueOf(placeholder));
                }
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

        btn_confirm.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String generatedName = txt_generatedname.getText().toString();
                if( db.checkUserExists( generatedName ) == true  )
                {
                    Toast.makeText(LogInScreen.this, "Username already exists", Toast.LENGTH_SHORT).show();
                }
                else if ( edt_firstname.getText().toString().length() > 0 &&
                    edt_lastname.getText().toString().length() > 0 &&
                    !txt_generatedname.getText().toString().equals( "xxxxxx" ) &&
                    edt_passwordenter.getText().toString().length() >= 6 &&
                    edt_passwordenter.getText().toString().equals( edt_passwordconfirm.getText().toString()
                    ) )
                {
                    UserModal user = null;
                    try
                    {
                        user = new UserModal( -1, txt_generatedname.getText().toString(),
                                                  edt_firstname.getText().toString(),
                                                  edt_lastname.getText().toString(),
                                                  edt_passwordenter.getText().toString());
                        Toast.makeText(LogInScreen.this, "Account will be made", Toast.LENGTH_SHORT).show();

                    }
                    catch (Exception e)
                    {
                        Toast.makeText(LogInScreen.this, "Error creating Account", Toast.LENGTH_SHORT).show();
                    }

                    DbHandler dbHandler = new DbHandler(LogInScreen.this);
                    dbHandler.insertUserDetails(user);
                    dialog.dismiss();
                }
                else
                {
                    Toast.makeText(LogInScreen.this, "Account will not be made", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}