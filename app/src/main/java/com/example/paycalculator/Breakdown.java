package com.example.paycalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Breakdown extends AppCompatActivity
{
// Declaring Variables
    List<String> arrayWeekdays = new ArrayList<>();
    List<String> arrayFridays = new ArrayList<>();
    List<String> arraySaturdays = new ArrayList<>();
    List<String> arraySundays = new ArrayList<>();
    double pay;
    int totalHours;
    float penalPoint25 = 0;
    int penalPoint5 = 0;
    double grossPay;
    double payeTax = 0;
    double loanThreshold = 818;
    double studentLoan;
    double unionFees;
    int parkingCard;
    double kiwisaver;
    double employeerKiwisaver;
    double netPay;
// Declaring Objects
    TextView txt_date;
    TextView txt_totalhoursvalue;
    TextView txt_ordinarytimevalue;
    TextView txt_penal25value;
    TextView txt_penal5value;
    TextView txt_paygrossvalue;
    TextView txt_payevalue;
    TextView txt_studentloanvalue;
    TextView txt_unionfeevalue;
    TextView txt_parkingfeevalue;
    TextView txt_employeekiwisavervalue;
    TextView txt_employeerkiwisavervalue;
    TextView txt_paynetvalue;
    Button btn_input;
    Button btn_information;
// Setting Up Values from Intents
    HashMap<String, String> tableDetails = null;
    HashMap<String, String> userDetails;
    int currentID;
    LocalDate currentCycle;
    DbHandler db = new DbHandler(Breakdown.this);
    DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yy");

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.topmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.mnu_logout:
                Intent toLoginScreen=new Intent(Breakdown.this, LogInScreen.class);
                toLoginScreen.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(toLoginScreen);
                finish();
                break;
            case R.id.mnu_userlist:
                Intent toUserList=new Intent(Breakdown.this, UserList.class);
                startActivity(toUserList);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakdown);
// SETTING OBJECTS
        txt_date = findViewById(R.id.txt_date);
        btn_input = findViewById(R.id.btn_input);
        btn_information = findViewById(R.id.btn_information);
        txt_totalhoursvalue = findViewById(R.id.txt_totalhoursvalue);
        txt_ordinarytimevalue = findViewById(R.id.txt_ordinarytimevalue);
        txt_penal25value = findViewById(R.id.txt_penal25value);
        txt_penal5value = findViewById(R.id.txt_penal5value);
        txt_paygrossvalue = findViewById(R.id.txt_paygrossvalue);
        txt_payevalue = findViewById(R.id.txt_payevalue);
        txt_studentloanvalue = findViewById(R.id.txt_studentloanvalue);
        txt_unionfeevalue = findViewById(R.id.txt_unionfeevalue);
        txt_parkingfeevalue = findViewById(R.id.txt_parkingfeevalue);
        txt_employeekiwisavervalue = findViewById(R.id.txt_employeekiwisavervalue);
        txt_employeerkiwisavervalue = findViewById(R.id.txt_employeerkiwisavervalue);
        txt_paynetvalue = findViewById(R.id.txt_paynetvalue);
// SETTING VARIABLES FROM OTHER ACTIVITIES
        currentID = getIntent().getIntExtra("CurrentID", 0);
        tableDetails = (HashMap<String, String>)getIntent().getSerializableExtra("tabledetails");
        userDetails = db.getUserDetails(currentID);
        currentCycle = LocalDate.parse(tableDetails.get("startdate"));

// SETTING SHIFT ARRAYS
        arrayWeekdays.add(tableDetails.get("W1_Monday"));
        arrayWeekdays.add(tableDetails.get("W1_Tuesday"));
        arrayWeekdays.add(tableDetails.get("W1_Wednesday"));
        arrayWeekdays.add(tableDetails.get("W1_Thursday"));
        arrayWeekdays.add(tableDetails.get("W2_Monday"));
        arrayWeekdays.add(tableDetails.get("W2_Tuesday"));
        arrayWeekdays.add(tableDetails.get("W2_Wednesday"));
        arrayWeekdays.add(tableDetails.get("W2_Thursday"));
        arrayFridays.add(tableDetails.get("W1_Friday"));
        arrayFridays.add(tableDetails.get("W2_Friday"));
        arraySaturdays.add(tableDetails.get("W1_Saturday"));
        arraySaturdays.add(tableDetails.get("W2_Saturday"));
        arraySundays.add(tableDetails.get("W1_Sunday"));
        arraySundays.add(tableDetails.get("W2_Sunday"));

// GENERATING VALUES FOR THE BREAKDOWN
// Orderlies Paygrade
        if( userDetails.get("jobtitle").equals("0"))
        {
            if (userDetails.get("paygrade").equals("0"))
            {
                pay = 20.90;
            } else if (userDetails.get("paygrade").equals("1"))
            {
                pay = 22.98;
            } else if (userDetails.get("paygrade").equals("2"))
            {
                pay = 24.34;
            } else
            {
                pay = 25.58;
            }
        }
// Security Paygrade
        else if( userDetails.get("jobtitle").equals("1"))
        {
            if (userDetails.get("paygrade").equals("0"))
            {
                pay = 21.40;
            }
            else if (userDetails.get("paygrade").equals("1"))
            {
                pay = 23.48;
            }
            else if (userDetails.get("paygrade").equals("2"))
            {
                pay = 24.84;
            } else
            {
                pay = 26.08;
            }
        }
//  Supervior Paygrade
        else
        {
            if (userDetails.get("paygrade").equals("0"))
            {
                pay = 25.40;
            }
            else if (userDetails.get("paygrade").equals("1"))
            {
                pay = 27.48;
            }
            else if (userDetails.get("paygrade").equals("2"))
            {
                pay = 28.84;
            }
            else
            {
                pay = 30.08;
            }
        }
// Weekday Calculations
        for(int i = 0; i < 8; i++)
        {
            if( arrayWeekdays.get(i).equals("----") )
            {

            }
            else if( arrayWeekdays.get(i).equals("0000"))
            {
                totalHours += 8;
                penalPoint25 += 6;
            }
            else if(arrayWeekdays.get(i).equals( "1530"))
            {
                totalHours += 8;
                penalPoint25 += 3.5;
            }
            else if(arrayWeekdays.get(i).equals("1600"))
            {
                totalHours += 8;
                penalPoint25 += 4;
            }
            else if(arrayWeekdays.get(i).equals("1700"))
            {
                totalHours += 8;
                penalPoint25 += 5;
            }
            else if(arrayWeekdays.get(i).equals("1800"))
            {
                totalHours += 8;
                penalPoint25 += 6;
            }
            else if(arrayWeekdays.get(i).equals("2000"))
            {
                totalHours += 8;
                penalPoint25 += 8;
            }
            else
            {
                totalHours += 8;
            }
        }
// Friday Calculations
        for(int i = 0; i < 2; i++)
        {
            if(arrayFridays.get(i).equals("----"))
            {

            }
            else if(arrayFridays.get(i).equals("0000"))
            {
                totalHours += 8;
                penalPoint25 += 6;
            }
            else if(arrayFridays.get(i).equals("1530"))
            {
                totalHours += 8;
                penalPoint25 += 3.5;
            }
            else if(arrayFridays.get(i).equals("1600"))
            {
                totalHours += 8;
                penalPoint25 += 4;
            }
            else if(arrayFridays.get(i).equals("1700"))
            {
                totalHours += 8;
                penalPoint25 += 4;
                penalPoint5 += 1;
            }
            else if(arrayFridays.get(i).equals("1800"))
            {
                totalHours +=8;
                penalPoint25 += 4;
                penalPoint5 += 2;
            }
            else if(arrayFridays.get(i).equals("2000"))
            {
                totalHours += 8;
                penalPoint25 += 4;
                penalPoint5 += 4;
            }
            else
            {
                totalHours += 8;
            }
        }
// Saturday Calculations
        for(int i = 0; i < 2; i++)
        {
            if(arraySaturdays.get(i).equals("----"))
            {

            }
            else
            {
                totalHours += 8;
                penalPoint5 += 8;
            }
        }
// Sunday Calculations
        for(int i = 0; i < 2; i++)
        {
          if( arraySundays.get(i).equals("----"))
          {

          }
          else if( arraySundays.get(i).equals("1700"))
          {
              totalHours += 8;
              penalPoint25 += 1;
              penalPoint5 += 7;
          }
          else if( arraySundays.get(i).equals("1800"))
          {
              totalHours += 8;
              penalPoint25 += 2;
              penalPoint5 += 6;
          }
          else if(  arraySundays.get(i).equals("2000"))
          {
              totalHours += 8;
              penalPoint25 += 4;
              penalPoint5 += 4;
          }
          else
          {
              totalHours += 8;
              penalPoint5 += 8;
          }
        }
// Gross Pay Calculation
        grossPay = ( totalHours * pay ) + ( ( penalPoint5 * pay) / 2 ) + ( ( penalPoint25 * pay ) / 4 );

// Calculating Tax
        if (grossPay > 2693 )
        {
            payeTax = 0;
        }
        else if ( grossPay > 1847 )
        {
            payeTax = ( ( grossPay - 1847) * .3 ) + 229 + 57;
        }
        else if ( grossPay > 539 )
        {
            payeTax = ( ( grossPay  - 539 ) * .175 ) + 57;
        }
        else
        {
            payeTax = ( grossPay * .105 );
        }
// Student Loan Check and Calculation
        if( userDetails.get("studentloan").equals("1") ) {
            if ((grossPay - loanThreshold) > 0)
            {
                studentLoan = (grossPay - loanThreshold) * 0.12;
            } else
            {
                studentLoan = 0;
            }
        }
        else
        {
            {
                studentLoan = 0;
            }
        }
// Union Dues Check and Calculation
        if ( userDetails.get("union").equals( "1" ) )
        {
            if(totalHours < 20)
            {
                unionFees = 8.12;
            }
            else if (totalHours < 35)
            {
                unionFees = 12.94;
            }
            else
            {
                unionFees = 16.18;
            }
        }
        else
        {
            unionFees = 0;
        }
// Parking Fee check and Calculation
        if( userDetails.get("parkingcard").equals("1") )
        {
            if( ( totalHours / 8 ) > 4 )
            {
                parkingCard = 20;
            }
            else
            {
                parkingCard = ( ( totalHours / 8 ) * 4 );
            }
        }
        else
        {
            parkingCard = 0;
        }
// Employee Kiwisaver Check and Calculation
        if ( userDetails.get("kiwisaver").equals("0") )
        {
            kiwisaver = 0;
            employeerKiwisaver = 0;
        }
        else if ( userDetails.get("kiwisaver").equals("1") )
        {
            kiwisaver = grossPay * .03;
            employeerKiwisaver = grossPay * .03;
        }
        else if ( userDetails.get("kiwisaver").equals("2") )
        {
            kiwisaver = grossPay * .04;
            employeerKiwisaver = grossPay * .03;
        }
        else if ( userDetails.get("kiwisaver").equals("3") )
        {
            kiwisaver = grossPay * .06;
            employeerKiwisaver = grossPay * .03;
        }
        else
        {
            kiwisaver = grossPay * .08;
            employeerKiwisaver = grossPay * .03;
        }
// Calculating Net Pay
        netPay = grossPay - payeTax - studentLoan - unionFees - parkingCard - kiwisaver;
// PLACING VALUES FOR THE BREAKDOWN
        txt_date.setText(sdf.format(currentCycle) + " - " + sdf.format(currentCycle.plusDays(13)));
        txt_totalhoursvalue.setText( totalHours + ".00");
        txt_ordinarytimevalue.setText( "$" + String.format("%.2f",(totalHours * pay ) ) );
        txt_penal25value.setText( "$" + String.format("%.2f", ( penalPoint25 * pay ) / 4) );
        txt_penal5value.setText( "$" + String.format("%.2f", ( penalPoint5 * pay ) / 2 ) );
        txt_paygrossvalue.setText( "$" + String.format("%.2f", grossPay) );
        txt_payevalue.setText( "$" + String.format("%.2f", payeTax ) );
        txt_studentloanvalue.setText( "$" + String.format("%.2f", studentLoan ) );
        txt_unionfeevalue.setText( "$" + String.format("%.2f", unionFees ) );
        txt_parkingfeevalue.setText( "$" + parkingCard + ".00" );
        txt_employeekiwisavervalue.setText( "$" + String.format( "%.2f", kiwisaver ) );
        txt_employeerkiwisavervalue.setText( "$" + String.format( "%.2f", employeerKiwisaver ) );
        txt_paynetvalue.setText( "$" + String.format( "%.2f", netPay ) );
// ADDING FUNCTIONS TO BUTTONS
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