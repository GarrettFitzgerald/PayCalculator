package com.example.paycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Information extends AppCompatActivity
{

    TextView txt_name_read;
    TextView txt_job_read;
    RadioGroup rad_paygrade;
    RadioGroup rad_kiwisaver;
    RadioGroup rad_union;
    RadioGroup rad_studentLoan;
    RadioGroup rad_parking;
    RadioButton rad_gradeZero;
    RadioButton rad_gradeOne;
    RadioButton rad_gradeTwo;
    RadioButton rad_gradeThree;
    RadioButton rad_kiwiZero;
    RadioButton rad_kiwiThree;
    RadioButton rad_kiwiFour;
    RadioButton rad_kiwiSix;
    RadioButton rad_kiwiEight;
    RadioButton rad_unionYes;
    RadioButton rad_unionNo;
    RadioButton rad_loanYes;
    RadioButton rad_loanNo;
    RadioButton rad_parkingYes;
    RadioButton rad_parkingNo;
    Button btn_topaysheets;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        txt_name_read = findViewById( R.id.txt_name_read);
        txt_job_read = findViewById( R.id.txt_job_read);
        rad_paygrade = findViewById( R.id.rad_paygrade);
        rad_kiwisaver = findViewById( R.id.rad_kiwisaver);
        rad_union = findViewById( R.id.rad_union);
        rad_studentLoan = findViewById( R.id.rad_studentLoan);
        rad_parking = findViewById( R.id.rad_parking);
        rad_gradeZero = findViewById( R.id.rad_gradeZero);
        rad_gradeOne = findViewById( R.id.rad_gradeOne);
        rad_gradeTwo = findViewById( R.id.rad_gradeTwo);
        rad_gradeThree = findViewById( R.id.rad_gradeThree);
        rad_kiwiZero = findViewById( R.id.rad_kiwiZero);
        rad_kiwiThree = findViewById( R.id.rad_kiwiThree);
        rad_kiwiFour = findViewById( R.id.rad_kiwiFour);
        rad_kiwiSix = findViewById( R.id.rad_kiwiSix);
        rad_kiwiEight = findViewById( R.id.rad_kiwiEight);
        rad_unionYes = findViewById( R.id.rad_unionYes);
        rad_unionNo = findViewById( R.id.rad_unionNo);
        rad_loanYes = findViewById( R.id.rad_loanYes);
        rad_loanNo = findViewById( R.id.rad_loanNo);
        rad_parkingYes = findViewById( R.id.rad_parkingYes);
        rad_parkingNo = findViewById( R.id.rad_parkingNo);
                btn_topaysheets = findViewById( R.id.btn_topaysheets);

        txt_name_read.setText("Garrett Fitzgerald"); //Get info from Database
        txt_job_read.setText("Orderly"); // Get info from Database
        rad_paygrade.check(R.id.rad_gradeThree); // Get info from Database
        rad_kiwisaver.check(R.id.rad_kiwiEight); //Get info from Database
        rad_union.check(R.id.rad_unionNo); //Get info from Database
        rad_studentLoan.check(R.id.rad_loanYes); //Get info from Database
        rad_parking.check(R.id.rad_parkingNo); //Get info from Database

        btn_topaysheets.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Before loading the intent, send data from options to the database

                Intent intentToPaySheets = new Intent( Information.this, PaySheets.class);
                startActivity( intentToPaySheets);
            }
        });
    }
}