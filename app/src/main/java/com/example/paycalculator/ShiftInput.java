package com.example.paycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShiftInput extends AppCompatActivity
{
    TextView txt_date;

    Button btn_clear;
    Button btn_breakdown;
    Button btn_information;
    Button btn_mondayone;
    Button btn_mondaytwo;
    Button btn_tuesdayone;
    Button btn_tuesdaytwo;
    Button btn_wednesdayone;
    Button btn_wednesdaytwo;
    Button btn_thursdayone;
    Button btn_thursdaytwo;
    Button btn_fridayone;
    Button btn_fridaytwo;
    Button btn_saturdayone;
    Button btn_saturdaytwo;
    Button btn_sundayone;
    Button btn_sundaytwo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shift_input);

        txt_date = findViewById(R.id.txt_date);
        btn_clear = findViewById(R.id.btn_clear);
        btn_breakdown = findViewById(R.id.btn_breakdown);
        btn_information = findViewById(R.id.btn_information);
        btn_mondayone = findViewById(R.id.btn_mondayone);
        btn_mondaytwo = findViewById(R.id.btn_mondaytwo);
        btn_tuesdayone = findViewById(R.id.btn_tuesdayone);
        btn_tuesdaytwo = findViewById(R.id.btn_tuesdaytwo);
        btn_wednesdayone = findViewById(R.id.btn_wednesdayone);
        btn_wednesdaytwo = findViewById(R.id.btn_wednesdaytwo);
        btn_thursdayone = findViewById(R.id.btn_thursdayone);
        btn_thursdaytwo = findViewById(R.id.btn_thursdaytwo);
        btn_fridayone = findViewById(R.id.btn_fridayone);
        btn_fridaytwo = findViewById(R.id.btn_fridaytwo);
        btn_saturdayone = findViewById(R.id.btn_saturdayone);
        btn_saturdaytwo = findViewById(R.id.btn_saturdaytwo);
        btn_sundayone = findViewById(R.id.btn_sundayone);
        btn_sundaytwo = findViewById(R.id.btn_sundaytwo);

        String username = getIntent().getStringExtra("Username");

        btn_information.setOnClickListener(new View.OnClickListener() //Sends user to Information activity
        {
            @Override
            public void onClick(View view)
            {
                Intent intentToInformation = new Intent(ShiftInput.this, Information.class);
                intentToInformation.putExtra("Username", username );
                startActivity( intentToInformation );
            }
        });

        btn_breakdown.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
               Intent intentToBreakdown = new Intent(ShiftInput.this, Breakdown.class);
               intentToBreakdown.putExtra("Username", username );
               startActivity(intentToBreakdown);
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondayone.setText("----");
                btn_mondaytwo.setText("----");
                btn_tuesdayone.setText("----");
                btn_tuesdaytwo.setText("----");
                btn_wednesdayone.setText("----");
                btn_wednesdaytwo.setText("----");
                btn_thursdayone.setText("----");
                btn_thursdaytwo.setText("----");
                btn_fridayone.setText("----");
                btn_fridaytwo.setText("----");
                btn_saturdayone.setText("----");
                btn_saturdaytwo.setText("----");
                btn_sundayone.setText("----");
                btn_sundaytwo .setText("----");
            }
        });
    }
}