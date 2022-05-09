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

import java.util.ArrayList;

public class Information extends AppCompatActivity
{

    String username;
    ArrayList<UserModal> userDetails;

    TextView txt_name_read;
    RadioGroup rad_jobTitle;
    RadioGroup rad_paygrade;
    RadioGroup rad_kiwisaver;
    RadioGroup rad_union;
    RadioGroup rad_studentLoan;
    RadioGroup rad_parking;
    RadioButton rad_orderly;
    RadioButton rad_security;
    RadioButton rad_supervisor;
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

    DbHandler db = new DbHandler(Information.this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        userDetails = db.getUserDetails( username );

        txt_name_read = findViewById( R.id.txt_name_read);
        rad_jobTitle = findViewById( R.id.rad_jobTitle);
        rad_paygrade = findViewById( R.id.rad_paygrade);
        rad_kiwisaver = findViewById( R.id.rad_kiwisaver);
        rad_union = findViewById( R.id.rad_union);
        rad_studentLoan = findViewById( R.id.rad_studentLoan);
        rad_parking = findViewById( R.id.rad_parking);
        rad_orderly = findViewById( R.id.rad_orderly);
        rad_security = findViewById( R.id.rad_security);
        rad_supervisor = findViewById( R.id.rad_supervisor);
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

        username = getIntent().getStringExtra("Username");
        userDetails = db.getUserDetails( username );

        txt_name_read.setText(userDetails.get(0).getFirstName() + " " + userDetails.get(0).getlastName()); //Get info from Database

        if(userDetails.get(0).getJobTitle() == 0)
        {
            rad_jobTitle.check(R.id.rad_orderly);
        }
        else if (userDetails.get(0).getPaygrade() == 1)
        {
            rad_jobTitle.check(R.id.rad_security);
        }
        else
        {
            rad_jobTitle.check(R.id.rad_supervisor);
        }

        if(userDetails.get(0).getPaygrade() == 0)
        {
            rad_paygrade.check(R.id.rad_gradeZero);
        }
        else if (userDetails.get(0).getPaygrade() == 1)
        {
            rad_paygrade.check(R.id.rad_gradeOne);
        }
        else if (userDetails.get(0).getPaygrade() == 2)
        {
            rad_paygrade.check(R.id.rad_gradeTwo);
        }
        else
        {
            rad_paygrade.check(R.id.rad_gradeThree);
        }

        if( userDetails.get(0).getKiwisaver() == 0)
        {
            rad_kiwisaver.check(R.id.rad_kiwiZero);
        }
        else if( userDetails.get(0).getKiwisaver() == 1)
        {
            rad_kiwisaver.check(R.id.rad_kiwiThree);
        }
        else if( userDetails.get(0).getKiwisaver() == 2)
        {
            rad_kiwisaver.check(R.id.rad_kiwiFour);
        }
        else if( userDetails.get(0).getKiwisaver() == 3)
        {
            rad_kiwisaver.check(R.id.rad_kiwiSix);
        }
        else
        {
            rad_kiwisaver.check(R.id.rad_kiwiEight);
        }
        //TODO Why arent these Radial Appearing on Load?
        if( userDetails.get(0).getUnion() == 0)
        {
            rad_union.check(R.id.rad_unionNo);
        }
        else
        {
            rad_union.check(R.id.rad_unionYes);
        }

        if( userDetails.get(0).getStudentLoan() == 0)
        {
            rad_union.check(R.id.rad_loanNo);
        }
        else
        {
            rad_union.check(R.id.rad_loanYes);
        }

        if( userDetails.get(0).getParkingCard() == 0)
        {
            rad_union.check(R.id.rad_parkingNo);
        }
        else
        {
            rad_union.check(R.id.rad_parkingYes);
        }

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

    public void onJobTitleClicked(View view)
    {
        //Add cases for when JobTitle Radials are clicked
        boolean selected = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rad_orderly:
                if (selected)
                    Toast.makeText(this, "You are an Orderly", Toast.LENGTH_SHORT).show();
                // Update Database code here
                break;
            case R.id.rad_security:
                if (selected)
                    Toast.makeText(this, "You are a Security Guard", Toast.LENGTH_SHORT).show();
                // Update Database code here
                break;
            case R.id.rad_supervisor:
                if (selected)
                    Toast.makeText(this, "You are a Supervisor", Toast.LENGTH_SHORT).show();
                // Update Database code here
                break;
        }
    }

    public void onPayGradeClicked(View view)
    {
        //Add cases for when PayGrade Radials are clicked
        boolean selected = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rad_gradeZero:
                if(selected)
                Toast.makeText(this, "Pay Grade Zero selected", Toast.LENGTH_SHORT ).show();
                // Update Database code here
                break;
            case R.id.rad_gradeOne:
                if(selected)
                    Toast.makeText(this, "Pay Grade One selected", Toast.LENGTH_SHORT ).show();
                // Update Database code here
                break;
            case R.id.rad_gradeTwo:
                if(selected)
                    Toast.makeText(this, "Pay Grade Two selected", Toast.LENGTH_SHORT ).show();
                // Update Database code here
                break;
            case R.id.rad_gradeThree:
                if(selected)
                    Toast.makeText(this, "Pay Grade Three selected", Toast.LENGTH_SHORT ).show();
                // Update Database code here
                break;
        }
    }

    public void onKiwiSaverClicked(View view)
    {
        //Add cases for when KiwiSaver Radials are clicked
        boolean selected = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rad_kiwiZero:
                if(selected)
                    Toast.makeText(this, "0% KiwiSaver selected", Toast.LENGTH_SHORT ).show();
                // Update Database code here
                break;
            case R.id.rad_kiwiThree:
                if(selected)
                    Toast.makeText(this, "3% KiwiSaver selected", Toast.LENGTH_SHORT ).show();
                // Update Database code here
                break;
            case R.id.rad_kiwiFour:
                if(selected)
                    Toast.makeText(this, "4% KiwiSaver selected", Toast.LENGTH_SHORT ).show();
                // Update Database code here
                break;
            case R.id.rad_kiwiSix:
                if(selected)
                    Toast.makeText(this, "6% KiwiSaver selected", Toast.LENGTH_SHORT ).show();
                // Update Database code here
                break;
            case R.id.rad_kiwiEight:
                if(selected)
                    Toast.makeText(this, "8% KiwiSaver selected", Toast.LENGTH_SHORT ).show();
                // Update Database code here
                break;
        }
    }

    public void onUnionClicked(View view)
    {
        //Add cases for when Union Radials are clicked
        boolean selected = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rad_unionYes:
                if (selected)
                    Toast.makeText(this, "You are a Union member", Toast.LENGTH_SHORT).show();
                // Update Database code here
                break;
            case R.id.rad_unionNo:
                if (selected)
                    Toast.makeText(this, "You are not a Union member", Toast.LENGTH_SHORT).show();
                // Update Database code here
                break;
        }
    }

    public void onStudentLoanClicked(View view)
    {
        //Add cases for when StudentLoan Radials are clicked
        boolean selected = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rad_loanYes:
                if (selected)
                    Toast.makeText(this, "You have a Student Loan", Toast.LENGTH_SHORT).show();
                // Update Database code here
                break;
            case R.id.rad_loanNo:
                if (selected)
                    Toast.makeText(this, "You do not have a Student Loan", Toast.LENGTH_SHORT).show();
                // Update Database code here
                break;
        }
    }

    public void onParkingClicked(View view)
    {
        //Add cases for when StudentLoan Radials are clicked
        boolean selected = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rad_parkingYes:
                if (selected)
                    Toast.makeText(this, "You have a Parking Card", Toast.LENGTH_SHORT).show();
                // Update Database code here
                break;
            case R.id.rad_parkingNo:
                if (selected)
                    Toast.makeText(this, "You do not have a Parking Card", Toast.LENGTH_SHORT).show();
                // Update Database code here
                break;
        }
    }
}