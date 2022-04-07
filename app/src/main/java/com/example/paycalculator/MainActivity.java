package com.example.paycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intentToLoginScreen = new Intent(MainActivity.this, LogInScreen.class);
        Handler pauseFive = new Handler();

        pauseFive.postDelayed( new Runnable()
        {
            public void run()
            {
                startActivity( intentToLoginScreen );
            }
        }, 5000);
    }
}