package com.example.paycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;

public class Breakdown extends AppCompatActivity
{
    Button btn_input;
    Button btn_information;

    HashMap<String, String> tableDetails;
    HashMap<String, String> userDetails;
    int currentID;
    LocalDate currentCycle;
    DbHandler db = new DbHandler(Breakdown.this);



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakdown);

        btn_input = findViewById(R.id.btn_input);
        btn_information = findViewById(R.id.btn_information);

        currentID = getIntent().getIntExtra("CurrentID", 0);
        tableDetails = (HashMap<String, String>)getIntent().getSerializableExtra("tabledetails");
        currentCycle = LocalDate.parse(tableDetails.get("startdate"));
        userDetails = db.getUserDetails(currentID);


        btn_input.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intentToShiftInput = new Intent(Breakdown.this, ShiftInput.class);
                intentToShiftInput.putExtra("CurrentID", currentID );
                intentToShiftInput.putExtra("tabledetails", (Serializable) tableDetails);
                startActivity(intentToShiftInput);
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