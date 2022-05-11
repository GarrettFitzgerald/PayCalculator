package com.example.paycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Breakdown extends AppCompatActivity
{
    Button btn_input;
    Button btn_information;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakdown);

        btn_input = findViewById(R.id.btn_input);
        btn_information = findViewById(R.id.btn_information);

        int currentID = getIntent().getIntExtra("CurrentID", 0);


        btn_input.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intentToInput = new Intent(Breakdown.this, ShiftInput.class);
                intentToInput.putExtra("CurrentID", currentID );
                startActivity(intentToInput);
            }
        });

        btn_information.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intentToInformation = new Intent(Breakdown.this, Information.class);
                intentToInformation.putExtra("CurrentID", currentID);
                startActivity(intentToInformation);
            }
        });
    }
}