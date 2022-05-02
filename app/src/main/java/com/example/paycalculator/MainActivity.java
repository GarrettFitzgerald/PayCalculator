package com.example.paycalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        //Generating Mondays for app
        LocalDate startDate = LocalDate.of(2022, 1,3);
        LocalDate endDate = LocalDate.of(2022, 12,31);

        List<LocalDate> newCycle = new ArrayList<>();

        while (startDate.isBefore(endDate))
        {
            newCycle.add(startDate);
            startDate = startDate.plusDays(14);
        }

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