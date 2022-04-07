package com.example.paycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Information extends AppCompatActivity
{
    Button btn_topaysheets;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        btn_topaysheets = findViewById( R.id.btn_topaysheets);

        btn_topaysheets.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intentToPaySheets = new Intent( Information.this, PaySheets.class);
                startActivity( intentToPaySheets);
            }
        });
    }
}