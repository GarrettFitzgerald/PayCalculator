package com.example.paycalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class ShiftInput extends AppCompatActivity
{
    TextView txt_date;
    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;
    DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yy");
    DbHandler db = new DbHandler(ShiftInput.this);
    HashMap<String, String> tableDetails;
    int currentID;

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

    String mondayone;
    String mondaytwo;
    String tuesdayone;
    String tuesdaytwo;
    String wednesdayone;
    String wednesdaytwo;
    String thursdayone;
    String thursdaytwo;
    String fridayone;
    String fridaytwo;
    String saturdayone;
    String saturdaytwo;
    String sundayone;
    String sundaytwo;

    Button btn_0000;
    Button btn_0630;
    Button btn_0700;
    Button btn_0730;
    Button btn_0800;
    Button btn_0830;
    Button btn_0900;
    Button btn_1000;
    Button btn_1100;
    Button btn_1200;
    Button btn_1530;
    Button btn_1600;
    Button btn_1700;
    Button btn_1800;
    Button btn_2000;
    Button btn_close;

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
                Intent toLoginScreen=new Intent(ShiftInput.this, LogInScreen.class);
                toLoginScreen.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(toLoginScreen);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

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

        currentID = getIntent().getIntExtra("CurrentID", 0);
        tableDetails = (HashMap<String, String>)getIntent().getSerializableExtra("tabledetails");
        LocalDate currentCycle = LocalDate.parse(tableDetails.get("startdate"));

        txt_date.setText( sdf.format(currentCycle) + " - " + sdf.format(currentCycle.plusDays(13)));
        btn_mondayone.setText(tableDetails.get("W1_Monday"));
        btn_tuesdayone.setText(tableDetails.get("W1_Tuesday"));
        btn_wednesdayone.setText(tableDetails.get("W1_Wednesday"));
        btn_thursdayone.setText(tableDetails.get("W1_Thursday"));
        btn_fridayone.setText(tableDetails.get("W1_Friday"));
        btn_saturdayone.setText(tableDetails.get("W1_Saturday"));
        btn_sundayone.setText(tableDetails.get("W1_Sunday"));
        btn_mondaytwo.setText(tableDetails.get("W2_Monday"));
        btn_tuesdaytwo.setText(tableDetails.get("W2_Tuesday"));
        btn_wednesdaytwo.setText(tableDetails.get("W2_Wednesday"));
        btn_thursdaytwo.setText(tableDetails.get("W2_Thursday"));
        btn_fridaytwo.setText(tableDetails.get("W2_Friday"));
        btn_saturdaytwo.setText(tableDetails.get("W2_Saturday"));
        btn_sundaytwo.setText(tableDetails.get("W2_Sunday"));

        btn_mondayone.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setWeekOneMonday();
            }
        });

        btn_tuesdayone.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setWeekOneTuesday();
            }
        });

        btn_wednesdayone.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setWeekOneWednesday();
            }
        });

        btn_thursdayone.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setWeekOneThursday();
            }
        });

        btn_fridayone.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setWeekOneFriday();
            }
        });

        btn_saturdayone.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setWeekOneSaturday();
            }
        });

        btn_sundayone.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setWeekOneSunday();
            }
        });


        btn_mondaytwo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setWeekTwoMonday();
            }
        });

        btn_tuesdaytwo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setWeekTwoTuesday();
            }
        });

        btn_wednesdaytwo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setWeekTwoWednesday();
            }
        });

        btn_thursdaytwo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setWeekTwoThursday();
            }
        });

        btn_fridaytwo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setWeekTwoFriday();
            }
        });

        btn_saturdaytwo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setWeekTwoSaturday();
            }
        });

        btn_sundaytwo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setWeekTwoSunday();
            }
        });
        
        btn_information.setOnClickListener(new View.OnClickListener() //Sends user to Information activity
        {
            @Override
            public void onClick(View view)
            {
                // Add update table method
                mondayone = btn_mondayone.getText().toString();
                tuesdayone = btn_tuesdayone.getText().toString();
                wednesdayone = btn_wednesdayone.getText().toString();
                thursdayone = btn_thursdayone.getText().toString();
                fridayone = btn_fridayone.getText().toString();
                saturdayone = btn_saturdayone.getText().toString();
                sundayone = btn_sundayone.getText().toString();
                
                mondaytwo = btn_mondaytwo.getText().toString();
                tuesdaytwo = btn_tuesdaytwo.getText().toString();
                wednesdaytwo = btn_wednesdaytwo.getText().toString();
                thursdaytwo = btn_thursdaytwo.getText().toString();
                fridaytwo = btn_fridaytwo.getText().toString();
                saturdaytwo = btn_saturdaytwo.getText().toString();
                sundaytwo = btn_sundaytwo.getText().toString();


                db.updatePayCycleDetails( currentID, currentCycle, mondayone, tuesdayone, wednesdayone,
                                          thursdayone, fridayone, saturdayone, sundayone, mondaytwo,
                                          tuesdaytwo, wednesdaytwo, thursdaytwo, fridaytwo, saturdaytwo,
                                          sundaytwo);
                // Send back to information
                Intent intentToInformation = new Intent(ShiftInput.this, Information.class);
                intentToInformation.putExtra("CurrentID", currentID );
                startActivity( intentToInformation );
            }
        });

        btn_breakdown.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // Add update table method
                mondayone = btn_mondayone.getText().toString();
                tuesdayone = btn_tuesdayone.getText().toString();
                wednesdayone = btn_wednesdayone.getText().toString();
                thursdayone = btn_thursdayone.getText().toString();
                fridayone = btn_fridayone.getText().toString();
                saturdayone = btn_saturdayone.getText().toString();
                sundayone = btn_sundayone.getText().toString();

                mondaytwo = btn_mondaytwo.getText().toString();
                tuesdaytwo = btn_tuesdaytwo.getText().toString();
                wednesdaytwo = btn_wednesdaytwo.getText().toString();
                thursdaytwo = btn_thursdaytwo.getText().toString();
                fridaytwo = btn_fridaytwo.getText().toString();
                saturdaytwo = btn_saturdaytwo.getText().toString();
                sundaytwo = btn_sundaytwo.getText().toString();


                db.updatePayCycleDetails( currentID, currentCycle, mondayone, tuesdayone, wednesdayone,
                        thursdayone, fridayone, saturdayone, sundayone, mondaytwo,
                        tuesdaytwo, wednesdaytwo, thursdaytwo, fridaytwo, saturdaytwo,
                        sundaytwo);
                tableDetails = db.getPayCycleTable( currentID, currentCycle);

                Intent intentToBreakdown = new Intent(ShiftInput.this, Breakdown.class);
                intentToBreakdown.putExtra("CurrentID", currentID );
                intentToBreakdown.putExtra("tabledetails", (Serializable) tableDetails);
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

    public void setWeekOneMonday() //Shift Selecter Popup
    {
        dialogBuilder = new AlertDialog.Builder(ShiftInput.this);
        View inputWeekDayShiftInput = getLayoutInflater().inflate(R.layout.pop_weekdayshiftinput, null);

        btn_0000 = inputWeekDayShiftInput.findViewById(R.id.btn_0000);
        btn_0630 = inputWeekDayShiftInput.findViewById(R.id.btn_0630);
        btn_0700 = inputWeekDayShiftInput.findViewById(R.id.btn_0700);
        btn_0730 = inputWeekDayShiftInput.findViewById(R.id.btn_0730);
        btn_0800 = inputWeekDayShiftInput.findViewById(R.id.btn_0800);
        btn_0830 = inputWeekDayShiftInput.findViewById(R.id.btn_0830);
        btn_0900 = inputWeekDayShiftInput.findViewById(R.id.btn_0900);
        btn_1000 = inputWeekDayShiftInput.findViewById(R.id.btn_1000);
        btn_1100 = inputWeekDayShiftInput.findViewById(R.id.btn_1100);
        btn_1200 = inputWeekDayShiftInput.findViewById(R.id.btn_1200);
        btn_1530 = inputWeekDayShiftInput.findViewById(R.id.btn_1530);
        btn_1600 = inputWeekDayShiftInput.findViewById(R.id.btn_1600);
        btn_1700 = inputWeekDayShiftInput.findViewById(R.id.btn_1700);
        btn_1800 = inputWeekDayShiftInput.findViewById(R.id.btn_1800);
        btn_2000 = inputWeekDayShiftInput.findViewById(R.id.btn_2000);
        btn_close = inputWeekDayShiftInput.findViewById(R.id.btn_close);

        dialogBuilder.setView(inputWeekDayShiftInput);
        dialog = dialogBuilder.create();
        dialog.show();

        btn_0000.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_mondayone.setText("0000");
                dialog.dismiss();
            }
        });

        btn_0630.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_mondayone.setText("0630");
                dialog.dismiss();
            }
        });

        btn_0700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondayone.setText("0700");
                dialog.dismiss();
            }
        });

        btn_0730.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondayone.setText("0730");
                dialog.dismiss();
            }
        });

        btn_0800.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondayone.setText("0800");
                dialog.dismiss();
            }
        });

        btn_0830.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondayone.setText("0830");
                dialog.dismiss();
            }
        });

        btn_0900.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_mondayone.setText("0900");
                dialog.dismiss();
            }
        });

        btn_1000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondayone.setText("1000");
                dialog.dismiss();
            }
        });

        btn_1100.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondayone.setText("1100");
                dialog.dismiss();
            }
        });

        btn_1200.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondayone.setText("1200");
                dialog.dismiss();
            }
        });

        btn_1530.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondayone.setText("1530");
                dialog.dismiss();
            }
        });

        btn_1600.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondayone.setText("1600");
                dialog.dismiss();
            }
        });

        btn_1700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondayone.setText("1700");
                dialog.dismiss();
            }
        });

        btn_1800.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_mondayone.setText("1800");
                dialog.dismiss();
            }
        });

        btn_2000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondayone.setText("2000");
                dialog.dismiss();
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondayone.setText("----");
                dialog.dismiss();
            }
        });
    };

    public void setWeekOneTuesday() //Shift Selecter Popup
    {
        dialogBuilder = new AlertDialog.Builder(ShiftInput.this);
        View inputWeekDayShiftInput = getLayoutInflater().inflate(R.layout.pop_weekdayshiftinput, null);

        btn_0000 = inputWeekDayShiftInput.findViewById(R.id.btn_0000);
        btn_0630 = inputWeekDayShiftInput.findViewById(R.id.btn_0630);
        btn_0700 = inputWeekDayShiftInput.findViewById(R.id.btn_0700);
        btn_0730 = inputWeekDayShiftInput.findViewById(R.id.btn_0730);
        btn_0800 = inputWeekDayShiftInput.findViewById(R.id.btn_0800);
        btn_0830 = inputWeekDayShiftInput.findViewById(R.id.btn_0830);
        btn_0900 = inputWeekDayShiftInput.findViewById(R.id.btn_0900);
        btn_1000 = inputWeekDayShiftInput.findViewById(R.id.btn_1000);
        btn_1100 = inputWeekDayShiftInput.findViewById(R.id.btn_1100);
        btn_1200 = inputWeekDayShiftInput.findViewById(R.id.btn_1200);
        btn_1530 = inputWeekDayShiftInput.findViewById(R.id.btn_1530);
        btn_1600 = inputWeekDayShiftInput.findViewById(R.id.btn_1600);
        btn_1700 = inputWeekDayShiftInput.findViewById(R.id.btn_1700);
        btn_1800 = inputWeekDayShiftInput.findViewById(R.id.btn_1800);
        btn_2000 = inputWeekDayShiftInput.findViewById(R.id.btn_2000);
        btn_close = inputWeekDayShiftInput.findViewById(R.id.btn_close);

        dialogBuilder.setView(inputWeekDayShiftInput);
        dialog = dialogBuilder.create();
        dialog.show();

        btn_0000.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_tuesdayone.setText("0000");
                dialog.dismiss();
            }
        });

        btn_0630.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_tuesdayone.setText("0630");
                dialog.dismiss();
            }
        });

        btn_0700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdayone.setText("0700");
                dialog.dismiss();
            }
        });

        btn_0730.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdayone.setText("0730");
                dialog.dismiss();
            }
        });

        btn_0800.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdayone.setText("0800");
                dialog.dismiss();
            }
        });

        btn_0830.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdayone.setText("0830");
                dialog.dismiss();
            }
        });

        btn_0900.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_tuesdayone.setText("0900");
                dialog.dismiss();
            }
        });

        btn_1000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdayone.setText("1000");
                dialog.dismiss();
            }
        });

        btn_1100.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdayone.setText("1100");
                dialog.dismiss();
            }
        });

        btn_1200.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdayone.setText("1200");
                dialog.dismiss();
            }
        });

        btn_1530.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdayone.setText("1530");
                dialog.dismiss();
            }
        });

        btn_1600.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdayone.setText("1600");
                dialog.dismiss();
            }
        });

        btn_1700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdayone.setText("1700");
                dialog.dismiss();
            }
        });

        btn_1800.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_tuesdayone.setText("1800");
                dialog.dismiss();
            }
        });

        btn_2000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdayone.setText("2000");
                dialog.dismiss();
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdayone.setText("----");
                dialog.dismiss();
            }
        });
    };

    public void setWeekOneWednesday() //Shift Selecter Popup
    {
        dialogBuilder = new AlertDialog.Builder(ShiftInput.this);
        View inputWeekDayShiftInput = getLayoutInflater().inflate(R.layout.pop_weekdayshiftinput, null);

        btn_0000 = inputWeekDayShiftInput.findViewById(R.id.btn_0000);
        btn_0630 = inputWeekDayShiftInput.findViewById(R.id.btn_0630);
        btn_0700 = inputWeekDayShiftInput.findViewById(R.id.btn_0700);
        btn_0730 = inputWeekDayShiftInput.findViewById(R.id.btn_0730);
        btn_0800 = inputWeekDayShiftInput.findViewById(R.id.btn_0800);
        btn_0830 = inputWeekDayShiftInput.findViewById(R.id.btn_0830);
        btn_0900 = inputWeekDayShiftInput.findViewById(R.id.btn_0900);
        btn_1000 = inputWeekDayShiftInput.findViewById(R.id.btn_1000);
        btn_1100 = inputWeekDayShiftInput.findViewById(R.id.btn_1100);
        btn_1200 = inputWeekDayShiftInput.findViewById(R.id.btn_1200);
        btn_1530 = inputWeekDayShiftInput.findViewById(R.id.btn_1530);
        btn_1600 = inputWeekDayShiftInput.findViewById(R.id.btn_1600);
        btn_1700 = inputWeekDayShiftInput.findViewById(R.id.btn_1700);
        btn_1800 = inputWeekDayShiftInput.findViewById(R.id.btn_1800);
        btn_2000 = inputWeekDayShiftInput.findViewById(R.id.btn_2000);
        btn_close = inputWeekDayShiftInput.findViewById(R.id.btn_close);

        dialogBuilder.setView(inputWeekDayShiftInput);
        dialog = dialogBuilder.create();
        dialog.show();

        btn_0000.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_wednesdayone.setText("0000");
                dialog.dismiss();
            }
        });

        btn_0630.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_wednesdayone.setText("0630");
                dialog.dismiss();
            }
        });

        btn_0700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdayone.setText("0700");
                dialog.dismiss();
            }
        });

        btn_0730.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdayone.setText("0730");
                dialog.dismiss();
            }
        });

        btn_0800.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdayone.setText("0800");
                dialog.dismiss();
            }
        });

        btn_0830.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdayone.setText("0830");
                dialog.dismiss();
            }
        });

        btn_0900.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_wednesdayone.setText("0900");
                dialog.dismiss();
            }
        });

        btn_1000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdayone.setText("1000");
                dialog.dismiss();
            }
        });

        btn_1100.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdayone.setText("1100");
                dialog.dismiss();
            }
        });

        btn_1200.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdayone.setText("1200");
                dialog.dismiss();
            }
        });

        btn_1530.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdayone.setText("1530");
                dialog.dismiss();
            }
        });

        btn_1600.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdayone.setText("1600");
                dialog.dismiss();
            }
        });

        btn_1700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdayone.setText("1700");
                dialog.dismiss();
            }
        });

        btn_1800.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_wednesdayone.setText("1800");
                dialog.dismiss();
            }
        });

        btn_2000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdayone.setText("2000");
                dialog.dismiss();
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdayone.setText("----");
                dialog.dismiss();
            }
        });
    };

    public void setWeekOneThursday() //Shift Selecter Popup
    {
        dialogBuilder = new AlertDialog.Builder(ShiftInput.this);
        View inputWeekDayShiftInput = getLayoutInflater().inflate(R.layout.pop_weekdayshiftinput, null);

        btn_0000 = inputWeekDayShiftInput.findViewById(R.id.btn_0000);
        btn_0630 = inputWeekDayShiftInput.findViewById(R.id.btn_0630);
        btn_0700 = inputWeekDayShiftInput.findViewById(R.id.btn_0700);
        btn_0730 = inputWeekDayShiftInput.findViewById(R.id.btn_0730);
        btn_0800 = inputWeekDayShiftInput.findViewById(R.id.btn_0800);
        btn_0830 = inputWeekDayShiftInput.findViewById(R.id.btn_0830);
        btn_0900 = inputWeekDayShiftInput.findViewById(R.id.btn_0900);
        btn_1000 = inputWeekDayShiftInput.findViewById(R.id.btn_1000);
        btn_1100 = inputWeekDayShiftInput.findViewById(R.id.btn_1100);
        btn_1200 = inputWeekDayShiftInput.findViewById(R.id.btn_1200);
        btn_1530 = inputWeekDayShiftInput.findViewById(R.id.btn_1530);
        btn_1600 = inputWeekDayShiftInput.findViewById(R.id.btn_1600);
        btn_1700 = inputWeekDayShiftInput.findViewById(R.id.btn_1700);
        btn_1800 = inputWeekDayShiftInput.findViewById(R.id.btn_1800);
        btn_2000 = inputWeekDayShiftInput.findViewById(R.id.btn_2000);
        btn_close = inputWeekDayShiftInput.findViewById(R.id.btn_close);

        dialogBuilder.setView(inputWeekDayShiftInput);
        dialog = dialogBuilder.create();
        dialog.show();

        btn_0000.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_thursdayone.setText("0000");
                dialog.dismiss();
            }
        });

        btn_0630.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_thursdayone.setText("0630");
                dialog.dismiss();
            }
        });

        btn_0700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdayone.setText("0700");
                dialog.dismiss();
            }
        });

        btn_0730.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdayone.setText("0730");
                dialog.dismiss();
            }
        });

        btn_0800.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdayone.setText("0800");
                dialog.dismiss();
            }
        });

        btn_0830.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdayone.setText("0830");
                dialog.dismiss();
            }
        });

        btn_0900.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_thursdayone.setText("0900");
                dialog.dismiss();
            }
        });

        btn_1000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdayone.setText("1000");
                dialog.dismiss();
            }
        });

        btn_1100.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdayone.setText("1100");
                dialog.dismiss();
            }
        });

        btn_1200.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdayone.setText("1200");
                dialog.dismiss();
            }
        });

        btn_1530.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdayone.setText("1530");
                dialog.dismiss();
            }
        });

        btn_1600.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdayone.setText("1600");
                dialog.dismiss();
            }
        });

        btn_1700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdayone.setText("1700");
                dialog.dismiss();
            }
        });

        btn_1800.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_thursdayone.setText("1800");
                dialog.dismiss();
            }
        });

        btn_2000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdayone.setText("2000");
                dialog.dismiss();
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdayone.setText("----");
                dialog.dismiss();
            }
        });
    };

    public void setWeekOneFriday() //Shift Selecter Popup
    {
        dialogBuilder = new AlertDialog.Builder(ShiftInput.this);
        View inputWeekDayShiftInput = getLayoutInflater().inflate(R.layout.pop_weekdayshiftinput, null);

        btn_0000 = inputWeekDayShiftInput.findViewById(R.id.btn_0000);
        btn_0630 = inputWeekDayShiftInput.findViewById(R.id.btn_0630);
        btn_0700 = inputWeekDayShiftInput.findViewById(R.id.btn_0700);
        btn_0730 = inputWeekDayShiftInput.findViewById(R.id.btn_0730);
        btn_0800 = inputWeekDayShiftInput.findViewById(R.id.btn_0800);
        btn_0830 = inputWeekDayShiftInput.findViewById(R.id.btn_0830);
        btn_0900 = inputWeekDayShiftInput.findViewById(R.id.btn_0900);
        btn_1000 = inputWeekDayShiftInput.findViewById(R.id.btn_1000);
        btn_1100 = inputWeekDayShiftInput.findViewById(R.id.btn_1100);
        btn_1200 = inputWeekDayShiftInput.findViewById(R.id.btn_1200);
        btn_1530 = inputWeekDayShiftInput.findViewById(R.id.btn_1530);
        btn_1600 = inputWeekDayShiftInput.findViewById(R.id.btn_1600);
        btn_1700 = inputWeekDayShiftInput.findViewById(R.id.btn_1700);
        btn_1800 = inputWeekDayShiftInput.findViewById(R.id.btn_1800);
        btn_2000 = inputWeekDayShiftInput.findViewById(R.id.btn_2000);
        btn_close = inputWeekDayShiftInput.findViewById(R.id.btn_close);

        dialogBuilder.setView(inputWeekDayShiftInput);
        dialog = dialogBuilder.create();
        dialog.show();

        btn_0000.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_fridayone.setText("0000");
                dialog.dismiss();
            }
        });

        btn_0630.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_fridayone.setText("0630");
                dialog.dismiss();
            }
        });

        btn_0700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridayone.setText("0700");
                dialog.dismiss();
            }
        });

        btn_0730.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridayone.setText("0730");
                dialog.dismiss();
            }
        });

        btn_0800.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridayone.setText("0800");
                dialog.dismiss();
            }
        });

        btn_0830.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridayone.setText("0830");
                dialog.dismiss();
            }
        });

        btn_0900.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_fridayone.setText("0900");
                dialog.dismiss();
            }
        });

        btn_1000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridayone.setText("1000");
                dialog.dismiss();
            }
        });

        btn_1100.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridayone.setText("1100");
                dialog.dismiss();
            }
        });

        btn_1200.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridayone.setText("1200");
                dialog.dismiss();
            }
        });

        btn_1530.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridayone.setText("1530");
                dialog.dismiss();
            }
        });

        btn_1600.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridayone.setText("1600");
                dialog.dismiss();
            }
        });

        btn_1700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridayone.setText("1700");
                dialog.dismiss();
            }
        });

        btn_1800.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_fridayone.setText("1800");
                dialog.dismiss();
            }
        });

        btn_2000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridayone.setText("2000");
                dialog.dismiss();
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridayone.setText("----");
                dialog.dismiss();
            }
        });
    };

    public void setWeekOneSaturday() //Shift Selecter Popup
    {
        dialogBuilder = new AlertDialog.Builder(ShiftInput.this);
        View inputWeekDayShiftInput = getLayoutInflater().inflate(R.layout.pop_weekdayshiftinput, null);

        btn_0000 = inputWeekDayShiftInput.findViewById(R.id.btn_0000);
        btn_0630 = inputWeekDayShiftInput.findViewById(R.id.btn_0630);
        btn_0700 = inputWeekDayShiftInput.findViewById(R.id.btn_0700);
        btn_0730 = inputWeekDayShiftInput.findViewById(R.id.btn_0730);
        btn_0800 = inputWeekDayShiftInput.findViewById(R.id.btn_0800);
        btn_0830 = inputWeekDayShiftInput.findViewById(R.id.btn_0830);
        btn_0900 = inputWeekDayShiftInput.findViewById(R.id.btn_0900);
        btn_1000 = inputWeekDayShiftInput.findViewById(R.id.btn_1000);
        btn_1100 = inputWeekDayShiftInput.findViewById(R.id.btn_1100);
        btn_1200 = inputWeekDayShiftInput.findViewById(R.id.btn_1200);
        btn_1530 = inputWeekDayShiftInput.findViewById(R.id.btn_1530);
        btn_1600 = inputWeekDayShiftInput.findViewById(R.id.btn_1600);
        btn_1700 = inputWeekDayShiftInput.findViewById(R.id.btn_1700);
        btn_1800 = inputWeekDayShiftInput.findViewById(R.id.btn_1800);
        btn_2000 = inputWeekDayShiftInput.findViewById(R.id.btn_2000);
        btn_close = inputWeekDayShiftInput.findViewById(R.id.btn_close);

        dialogBuilder.setView(inputWeekDayShiftInput);
        dialog = dialogBuilder.create();
        dialog.show();

        btn_0000.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_saturdayone.setText("0000");
                dialog.dismiss();
            }
        });

        btn_0630.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_saturdayone.setText("0630");
                dialog.dismiss();
            }
        });

        btn_0700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdayone.setText("0700");
                dialog.dismiss();
            }
        });

        btn_0730.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdayone.setText("0730");
                dialog.dismiss();
            }
        });

        btn_0800.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdayone.setText("0800");
                dialog.dismiss();
            }
        });

        btn_0830.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdayone.setText("0830");
                dialog.dismiss();
            }
        });

        btn_0900.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_saturdayone.setText("0900");
                dialog.dismiss();
            }
        });

        btn_1000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdayone.setText("1000");
                dialog.dismiss();
            }
        });

        btn_1100.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdayone.setText("1100");
                dialog.dismiss();
            }
        });

        btn_1200.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdayone.setText("1200");
                dialog.dismiss();
            }
        });

        btn_1530.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdayone.setText("1530");
                dialog.dismiss();
            }
        });

        btn_1600.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdayone.setText("1600");
                dialog.dismiss();
            }
        });

        btn_1700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdayone.setText("1700");
                dialog.dismiss();
            }
        });

        btn_1800.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_saturdayone.setText("1800");
                dialog.dismiss();
            }
        });

        btn_2000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdayone.setText("2000");
                dialog.dismiss();
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdayone.setText("----");
                dialog.dismiss();
            }
        });
    };
    
    public void setWeekOneSunday() //Shift Selecter Popup
    {
        dialogBuilder = new AlertDialog.Builder(ShiftInput.this);
        View inputWeekDayShiftInput = getLayoutInflater().inflate(R.layout.pop_weekdayshiftinput, null);

        btn_0000 = inputWeekDayShiftInput.findViewById(R.id.btn_0000);
        btn_0630 = inputWeekDayShiftInput.findViewById(R.id.btn_0630);
        btn_0700 = inputWeekDayShiftInput.findViewById(R.id.btn_0700);
        btn_0730 = inputWeekDayShiftInput.findViewById(R.id.btn_0730);
        btn_0800 = inputWeekDayShiftInput.findViewById(R.id.btn_0800);
        btn_0830 = inputWeekDayShiftInput.findViewById(R.id.btn_0830);
        btn_0900 = inputWeekDayShiftInput.findViewById(R.id.btn_0900);
        btn_1000 = inputWeekDayShiftInput.findViewById(R.id.btn_1000);
        btn_1100 = inputWeekDayShiftInput.findViewById(R.id.btn_1100);
        btn_1200 = inputWeekDayShiftInput.findViewById(R.id.btn_1200);
        btn_1530 = inputWeekDayShiftInput.findViewById(R.id.btn_1530);
        btn_1600 = inputWeekDayShiftInput.findViewById(R.id.btn_1600);
        btn_1700 = inputWeekDayShiftInput.findViewById(R.id.btn_1700);
        btn_1800 = inputWeekDayShiftInput.findViewById(R.id.btn_1800);
        btn_2000 = inputWeekDayShiftInput.findViewById(R.id.btn_2000);
        btn_close = inputWeekDayShiftInput.findViewById(R.id.btn_close);

        dialogBuilder.setView(inputWeekDayShiftInput);
        dialog = dialogBuilder.create();
        dialog.show();

        btn_0000.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_sundayone.setText("0000");
                dialog.dismiss();
            }
        });

        btn_0630.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_sundayone.setText("0630");
                dialog.dismiss();
            }
        });

        btn_0700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundayone.setText("0700");
                dialog.dismiss();
            }
        });

        btn_0730.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundayone.setText("0730");
                dialog.dismiss();
            }
        });

        btn_0800.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundayone.setText("0800");
                dialog.dismiss();
            }
        });

        btn_0830.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundayone.setText("0830");
                dialog.dismiss();
            }
        });

        btn_0900.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_sundayone.setText("0900");
                dialog.dismiss();
            }
        });

        btn_1000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundayone.setText("1000");
                dialog.dismiss();
            }
        });

        btn_1100.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundayone.setText("1100");
                dialog.dismiss();
            }
        });

        btn_1200.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundayone.setText("1200");
                dialog.dismiss();
            }
        });

        btn_1530.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundayone.setText("1530");
                dialog.dismiss();
            }
        });

        btn_1600.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundayone.setText("1600");
                dialog.dismiss();
            }
        });

        btn_1700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundayone.setText("1700");
                dialog.dismiss();
            }
        });

        btn_1800.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_sundayone.setText("1800");
                dialog.dismiss();
            }
        });

        btn_2000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundayone.setText("2000");
                dialog.dismiss();
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundayone.setText("----");
                dialog.dismiss();
            }
        });
    };


    public void setWeekTwoMonday() //Shift Selecter Popup
    {
        dialogBuilder = new AlertDialog.Builder(ShiftInput.this);
        View inputWeekDayShiftInput = getLayoutInflater().inflate(R.layout.pop_weekdayshiftinput, null);

        btn_0000 = inputWeekDayShiftInput.findViewById(R.id.btn_0000);
        btn_0630 = inputWeekDayShiftInput.findViewById(R.id.btn_0630);
        btn_0700 = inputWeekDayShiftInput.findViewById(R.id.btn_0700);
        btn_0730 = inputWeekDayShiftInput.findViewById(R.id.btn_0730);
        btn_0800 = inputWeekDayShiftInput.findViewById(R.id.btn_0800);
        btn_0830 = inputWeekDayShiftInput.findViewById(R.id.btn_0830);
        btn_0900 = inputWeekDayShiftInput.findViewById(R.id.btn_0900);
        btn_1000 = inputWeekDayShiftInput.findViewById(R.id.btn_1000);
        btn_1100 = inputWeekDayShiftInput.findViewById(R.id.btn_1100);
        btn_1200 = inputWeekDayShiftInput.findViewById(R.id.btn_1200);
        btn_1530 = inputWeekDayShiftInput.findViewById(R.id.btn_1530);
        btn_1600 = inputWeekDayShiftInput.findViewById(R.id.btn_1600);
        btn_1700 = inputWeekDayShiftInput.findViewById(R.id.btn_1700);
        btn_1800 = inputWeekDayShiftInput.findViewById(R.id.btn_1800);
        btn_2000 = inputWeekDayShiftInput.findViewById(R.id.btn_2000);
        btn_close = inputWeekDayShiftInput.findViewById(R.id.btn_close);

        dialogBuilder.setView(inputWeekDayShiftInput);
        dialog = dialogBuilder.create();
        dialog.show();

        btn_0000.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_mondaytwo.setText("0000");
                dialog.dismiss();
            }
        });

        btn_0630.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_mondaytwo.setText("0630");
                dialog.dismiss();
            }
        });

        btn_0700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondaytwo.setText("0700");
                dialog.dismiss();
            }
        });

        btn_0730.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondaytwo.setText("0730");
                dialog.dismiss();
            }
        });

        btn_0800.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondaytwo.setText("0800");
                dialog.dismiss();
            }
        });

        btn_0830.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondaytwo.setText("0830");
                dialog.dismiss();
            }
        });

        btn_0900.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_mondaytwo.setText("0900");
                dialog.dismiss();
            }
        });

        btn_1000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondaytwo.setText("1000");
                dialog.dismiss();
            }
        });

        btn_1100.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondaytwo.setText("1100");
                dialog.dismiss();
            }
        });

        btn_1200.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondaytwo.setText("1200");
                dialog.dismiss();
            }
        });

        btn_1530.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondaytwo.setText("1530");
                dialog.dismiss();
            }
        });

        btn_1600.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondaytwo.setText("1600");
                dialog.dismiss();
            }
        });

        btn_1700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondaytwo.setText("1700");
                dialog.dismiss();
            }
        });

        btn_1800.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_mondaytwo.setText("1800");
                dialog.dismiss();
            }
        });

        btn_2000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondaytwo.setText("2000");
                dialog.dismiss();
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_mondaytwo.setText("----");
                dialog.dismiss();
            }
        });
    };

    public void setWeekTwoTuesday() //Shift Selecter Popup
    {
        dialogBuilder = new AlertDialog.Builder(ShiftInput.this);
        View inputWeekDayShiftInput = getLayoutInflater().inflate(R.layout.pop_weekdayshiftinput, null);

        btn_0000 = inputWeekDayShiftInput.findViewById(R.id.btn_0000);
        btn_0630 = inputWeekDayShiftInput.findViewById(R.id.btn_0630);
        btn_0700 = inputWeekDayShiftInput.findViewById(R.id.btn_0700);
        btn_0730 = inputWeekDayShiftInput.findViewById(R.id.btn_0730);
        btn_0800 = inputWeekDayShiftInput.findViewById(R.id.btn_0800);
        btn_0830 = inputWeekDayShiftInput.findViewById(R.id.btn_0830);
        btn_0900 = inputWeekDayShiftInput.findViewById(R.id.btn_0900);
        btn_1000 = inputWeekDayShiftInput.findViewById(R.id.btn_1000);
        btn_1100 = inputWeekDayShiftInput.findViewById(R.id.btn_1100);
        btn_1200 = inputWeekDayShiftInput.findViewById(R.id.btn_1200);
        btn_1530 = inputWeekDayShiftInput.findViewById(R.id.btn_1530);
        btn_1600 = inputWeekDayShiftInput.findViewById(R.id.btn_1600);
        btn_1700 = inputWeekDayShiftInput.findViewById(R.id.btn_1700);
        btn_1800 = inputWeekDayShiftInput.findViewById(R.id.btn_1800);
        btn_2000 = inputWeekDayShiftInput.findViewById(R.id.btn_2000);
        btn_close = inputWeekDayShiftInput.findViewById(R.id.btn_close);

        dialogBuilder.setView(inputWeekDayShiftInput);
        dialog = dialogBuilder.create();
        dialog.show();

        btn_0000.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_tuesdaytwo.setText("0000");
                dialog.dismiss();
            }
        });

        btn_0630.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_tuesdaytwo.setText("0630");
                dialog.dismiss();
            }
        });

        btn_0700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdaytwo.setText("0700");
                dialog.dismiss();
            }
        });

        btn_0730.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdaytwo.setText("0730");
                dialog.dismiss();
            }
        });

        btn_0800.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdaytwo.setText("0800");
                dialog.dismiss();
            }
        });

        btn_0830.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdaytwo.setText("0830");
                dialog.dismiss();
            }
        });

        btn_0900.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_tuesdaytwo.setText("0900");
                dialog.dismiss();
            }
        });

        btn_1000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdaytwo.setText("1000");
                dialog.dismiss();
            }
        });

        btn_1100.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdaytwo.setText("1100");
                dialog.dismiss();
            }
        });

        btn_1200.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdaytwo.setText("1200");
                dialog.dismiss();
            }
        });

        btn_1530.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdaytwo.setText("1530");
                dialog.dismiss();
            }
        });

        btn_1600.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdaytwo.setText("1600");
                dialog.dismiss();
            }
        });

        btn_1700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdaytwo.setText("1700");
                dialog.dismiss();
            }
        });

        btn_1800.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_tuesdaytwo.setText("1800");
                dialog.dismiss();
            }
        });

        btn_2000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdaytwo.setText("2000");
                dialog.dismiss();
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_tuesdaytwo.setText("----");
                dialog.dismiss();
            }
        });
    };

    public void setWeekTwoWednesday() //Shift Selecter Popup
    {
        dialogBuilder = new AlertDialog.Builder(ShiftInput.this);
        View inputWeekDayShiftInput = getLayoutInflater().inflate(R.layout.pop_weekdayshiftinput, null);

        btn_0000 = inputWeekDayShiftInput.findViewById(R.id.btn_0000);
        btn_0630 = inputWeekDayShiftInput.findViewById(R.id.btn_0630);
        btn_0700 = inputWeekDayShiftInput.findViewById(R.id.btn_0700);
        btn_0730 = inputWeekDayShiftInput.findViewById(R.id.btn_0730);
        btn_0800 = inputWeekDayShiftInput.findViewById(R.id.btn_0800);
        btn_0830 = inputWeekDayShiftInput.findViewById(R.id.btn_0830);
        btn_0900 = inputWeekDayShiftInput.findViewById(R.id.btn_0900);
        btn_1000 = inputWeekDayShiftInput.findViewById(R.id.btn_1000);
        btn_1100 = inputWeekDayShiftInput.findViewById(R.id.btn_1100);
        btn_1200 = inputWeekDayShiftInput.findViewById(R.id.btn_1200);
        btn_1530 = inputWeekDayShiftInput.findViewById(R.id.btn_1530);
        btn_1600 = inputWeekDayShiftInput.findViewById(R.id.btn_1600);
        btn_1700 = inputWeekDayShiftInput.findViewById(R.id.btn_1700);
        btn_1800 = inputWeekDayShiftInput.findViewById(R.id.btn_1800);
        btn_2000 = inputWeekDayShiftInput.findViewById(R.id.btn_2000);
        btn_close = inputWeekDayShiftInput.findViewById(R.id.btn_close);

        dialogBuilder.setView(inputWeekDayShiftInput);
        dialog = dialogBuilder.create();
        dialog.show();

        btn_0000.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_wednesdaytwo.setText("0000");
                dialog.dismiss();
            }
        });

        btn_0630.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_wednesdaytwo.setText("0630");
                dialog.dismiss();
            }
        });

        btn_0700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdaytwo.setText("0700");
                dialog.dismiss();
            }
        });

        btn_0730.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdaytwo.setText("0730");
                dialog.dismiss();
            }
        });

        btn_0800.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdaytwo.setText("0800");
                dialog.dismiss();
            }
        });

        btn_0830.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdaytwo.setText("0830");
                dialog.dismiss();
            }
        });

        btn_0900.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_wednesdaytwo.setText("0900");
                dialog.dismiss();
            }
        });

        btn_1000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdaytwo.setText("1000");
                dialog.dismiss();
            }
        });

        btn_1100.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdaytwo.setText("1100");
                dialog.dismiss();
            }
        });

        btn_1200.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdaytwo.setText("1200");
                dialog.dismiss();
            }
        });

        btn_1530.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdaytwo.setText("1530");
                dialog.dismiss();
            }
        });

        btn_1600.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdaytwo.setText("1600");
                dialog.dismiss();
            }
        });

        btn_1700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdaytwo.setText("1700");
                dialog.dismiss();
            }
        });

        btn_1800.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_wednesdaytwo.setText("1800");
                dialog.dismiss();
            }
        });

        btn_2000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdaytwo.setText("2000");
                dialog.dismiss();
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_wednesdaytwo.setText("----");
                dialog.dismiss();
            }
        });
    };

    public void setWeekTwoThursday() //Shift Selecter Popup
    {
        dialogBuilder = new AlertDialog.Builder(ShiftInput.this);
        View inputWeekDayShiftInput = getLayoutInflater().inflate(R.layout.pop_weekdayshiftinput, null);

        btn_0000 = inputWeekDayShiftInput.findViewById(R.id.btn_0000);
        btn_0630 = inputWeekDayShiftInput.findViewById(R.id.btn_0630);
        btn_0700 = inputWeekDayShiftInput.findViewById(R.id.btn_0700);
        btn_0730 = inputWeekDayShiftInput.findViewById(R.id.btn_0730);
        btn_0800 = inputWeekDayShiftInput.findViewById(R.id.btn_0800);
        btn_0830 = inputWeekDayShiftInput.findViewById(R.id.btn_0830);
        btn_0900 = inputWeekDayShiftInput.findViewById(R.id.btn_0900);
        btn_1000 = inputWeekDayShiftInput.findViewById(R.id.btn_1000);
        btn_1100 = inputWeekDayShiftInput.findViewById(R.id.btn_1100);
        btn_1200 = inputWeekDayShiftInput.findViewById(R.id.btn_1200);
        btn_1530 = inputWeekDayShiftInput.findViewById(R.id.btn_1530);
        btn_1600 = inputWeekDayShiftInput.findViewById(R.id.btn_1600);
        btn_1700 = inputWeekDayShiftInput.findViewById(R.id.btn_1700);
        btn_1800 = inputWeekDayShiftInput.findViewById(R.id.btn_1800);
        btn_2000 = inputWeekDayShiftInput.findViewById(R.id.btn_2000);
        btn_close = inputWeekDayShiftInput.findViewById(R.id.btn_close);

        dialogBuilder.setView(inputWeekDayShiftInput);
        dialog = dialogBuilder.create();
        dialog.show();

        btn_0000.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_thursdaytwo.setText("0000");
                dialog.dismiss();
            }
        });

        btn_0630.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_thursdaytwo.setText("0630");
                dialog.dismiss();
            }
        });

        btn_0700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdaytwo.setText("0700");
                dialog.dismiss();
            }
        });

        btn_0730.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdaytwo.setText("0730");
                dialog.dismiss();
            }
        });

        btn_0800.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdaytwo.setText("0800");
                dialog.dismiss();
            }
        });

        btn_0830.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdaytwo.setText("0830");
                dialog.dismiss();
            }
        });

        btn_0900.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_thursdaytwo.setText("0900");
                dialog.dismiss();
            }
        });

        btn_1000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdaytwo.setText("1000");
                dialog.dismiss();
            }
        });

        btn_1100.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdaytwo.setText("1100");
                dialog.dismiss();
            }
        });

        btn_1200.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdaytwo.setText("1200");
                dialog.dismiss();
            }
        });

        btn_1530.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdaytwo.setText("1530");
                dialog.dismiss();
            }
        });

        btn_1600.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdaytwo.setText("1600");
                dialog.dismiss();
            }
        });

        btn_1700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdaytwo.setText("1700");
                dialog.dismiss();
            }
        });

        btn_1800.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_thursdaytwo.setText("1800");
                dialog.dismiss();
            }
        });

        btn_2000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdaytwo.setText("2000");
                dialog.dismiss();
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_thursdaytwo.setText("----");
                dialog.dismiss();
            }
        });
    };

    public void setWeekTwoFriday() //Shift Selecter Popup
    {
        dialogBuilder = new AlertDialog.Builder(ShiftInput.this);
        View inputWeekDayShiftInput = getLayoutInflater().inflate(R.layout.pop_weekdayshiftinput, null);

        btn_0000 = inputWeekDayShiftInput.findViewById(R.id.btn_0000);
        btn_0630 = inputWeekDayShiftInput.findViewById(R.id.btn_0630);
        btn_0700 = inputWeekDayShiftInput.findViewById(R.id.btn_0700);
        btn_0730 = inputWeekDayShiftInput.findViewById(R.id.btn_0730);
        btn_0800 = inputWeekDayShiftInput.findViewById(R.id.btn_0800);
        btn_0830 = inputWeekDayShiftInput.findViewById(R.id.btn_0830);
        btn_0900 = inputWeekDayShiftInput.findViewById(R.id.btn_0900);
        btn_1000 = inputWeekDayShiftInput.findViewById(R.id.btn_1000);
        btn_1100 = inputWeekDayShiftInput.findViewById(R.id.btn_1100);
        btn_1200 = inputWeekDayShiftInput.findViewById(R.id.btn_1200);
        btn_1530 = inputWeekDayShiftInput.findViewById(R.id.btn_1530);
        btn_1600 = inputWeekDayShiftInput.findViewById(R.id.btn_1600);
        btn_1700 = inputWeekDayShiftInput.findViewById(R.id.btn_1700);
        btn_1800 = inputWeekDayShiftInput.findViewById(R.id.btn_1800);
        btn_2000 = inputWeekDayShiftInput.findViewById(R.id.btn_2000);
        btn_close = inputWeekDayShiftInput.findViewById(R.id.btn_close);

        dialogBuilder.setView(inputWeekDayShiftInput);
        dialog = dialogBuilder.create();
        dialog.show();

        btn_0000.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_fridaytwo.setText("0000");
                dialog.dismiss();
            }
        });

        btn_0630.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_fridaytwo.setText("0630");
                dialog.dismiss();
            }
        });

        btn_0700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridaytwo.setText("0700");
                dialog.dismiss();
            }
        });

        btn_0730.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridaytwo.setText("0730");
                dialog.dismiss();
            }
        });

        btn_0800.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridaytwo.setText("0800");
                dialog.dismiss();
            }
        });

        btn_0830.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridaytwo.setText("0830");
                dialog.dismiss();
            }
        });

        btn_0900.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_fridaytwo.setText("0900");
                dialog.dismiss();
            }
        });

        btn_1000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridaytwo.setText("1000");
                dialog.dismiss();
            }
        });

        btn_1100.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridaytwo.setText("1100");
                dialog.dismiss();
            }
        });

        btn_1200.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridaytwo.setText("1200");
                dialog.dismiss();
            }
        });

        btn_1530.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridaytwo.setText("1530");
                dialog.dismiss();
            }
        });

        btn_1600.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridaytwo.setText("1600");
                dialog.dismiss();
            }
        });

        btn_1700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridaytwo.setText("1700");
                dialog.dismiss();
            }
        });

        btn_1800.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_fridaytwo.setText("1800");
                dialog.dismiss();
            }
        });

        btn_2000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridaytwo.setText("2000");
                dialog.dismiss();
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_fridaytwo.setText("----");
                dialog.dismiss();
            }
        });
    };

    public void setWeekTwoSaturday() //Shift Selecter Popup
    {
        dialogBuilder = new AlertDialog.Builder(ShiftInput.this);
        View inputWeekDayShiftInput = getLayoutInflater().inflate(R.layout.pop_weekdayshiftinput, null);

        btn_0000 = inputWeekDayShiftInput.findViewById(R.id.btn_0000);
        btn_0630 = inputWeekDayShiftInput.findViewById(R.id.btn_0630);
        btn_0700 = inputWeekDayShiftInput.findViewById(R.id.btn_0700);
        btn_0730 = inputWeekDayShiftInput.findViewById(R.id.btn_0730);
        btn_0800 = inputWeekDayShiftInput.findViewById(R.id.btn_0800);
        btn_0830 = inputWeekDayShiftInput.findViewById(R.id.btn_0830);
        btn_0900 = inputWeekDayShiftInput.findViewById(R.id.btn_0900);
        btn_1000 = inputWeekDayShiftInput.findViewById(R.id.btn_1000);
        btn_1100 = inputWeekDayShiftInput.findViewById(R.id.btn_1100);
        btn_1200 = inputWeekDayShiftInput.findViewById(R.id.btn_1200);
        btn_1530 = inputWeekDayShiftInput.findViewById(R.id.btn_1530);
        btn_1600 = inputWeekDayShiftInput.findViewById(R.id.btn_1600);
        btn_1700 = inputWeekDayShiftInput.findViewById(R.id.btn_1700);
        btn_1800 = inputWeekDayShiftInput.findViewById(R.id.btn_1800);
        btn_2000 = inputWeekDayShiftInput.findViewById(R.id.btn_2000);
        btn_close = inputWeekDayShiftInput.findViewById(R.id.btn_close);

        dialogBuilder.setView(inputWeekDayShiftInput);
        dialog = dialogBuilder.create();
        dialog.show();

        btn_0000.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_saturdaytwo.setText("0000");
                dialog.dismiss();
            }
        });

        btn_0630.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_saturdaytwo.setText("0630");
                dialog.dismiss();
            }
        });

        btn_0700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdaytwo.setText("0700");
                dialog.dismiss();
            }
        });

        btn_0730.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdaytwo.setText("0730");
                dialog.dismiss();
            }
        });

        btn_0800.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdaytwo.setText("0800");
                dialog.dismiss();
            }
        });

        btn_0830.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdaytwo.setText("0830");
                dialog.dismiss();
            }
        });

        btn_0900.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_saturdaytwo.setText("0900");
                dialog.dismiss();
            }
        });

        btn_1000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdaytwo.setText("1000");
                dialog.dismiss();
            }
        });

        btn_1100.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdaytwo.setText("1100");
                dialog.dismiss();
            }
        });

        btn_1200.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdaytwo.setText("1200");
                dialog.dismiss();
            }
        });

        btn_1530.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdaytwo.setText("1530");
                dialog.dismiss();
            }
        });

        btn_1600.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdaytwo.setText("1600");
                dialog.dismiss();
            }
        });

        btn_1700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdaytwo.setText("1700");
                dialog.dismiss();
            }
        });

        btn_1800.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_saturdaytwo.setText("1800");
                dialog.dismiss();
            }
        });

        btn_2000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdaytwo.setText("2000");
                dialog.dismiss();
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_saturdaytwo.setText("----");
                dialog.dismiss();
            }
        });
    };

    public void setWeekTwoSunday() //Shift Selecter Popup
    {
        dialogBuilder = new AlertDialog.Builder(ShiftInput.this);
        View inputWeekDayShiftInput = getLayoutInflater().inflate(R.layout.pop_weekdayshiftinput, null);

        btn_0000 = inputWeekDayShiftInput.findViewById(R.id.btn_0000);
        btn_0630 = inputWeekDayShiftInput.findViewById(R.id.btn_0630);
        btn_0700 = inputWeekDayShiftInput.findViewById(R.id.btn_0700);
        btn_0730 = inputWeekDayShiftInput.findViewById(R.id.btn_0730);
        btn_0800 = inputWeekDayShiftInput.findViewById(R.id.btn_0800);
        btn_0830 = inputWeekDayShiftInput.findViewById(R.id.btn_0830);
        btn_0900 = inputWeekDayShiftInput.findViewById(R.id.btn_0900);
        btn_1000 = inputWeekDayShiftInput.findViewById(R.id.btn_1000);
        btn_1100 = inputWeekDayShiftInput.findViewById(R.id.btn_1100);
        btn_1200 = inputWeekDayShiftInput.findViewById(R.id.btn_1200);
        btn_1530 = inputWeekDayShiftInput.findViewById(R.id.btn_1530);
        btn_1600 = inputWeekDayShiftInput.findViewById(R.id.btn_1600);
        btn_1700 = inputWeekDayShiftInput.findViewById(R.id.btn_1700);
        btn_1800 = inputWeekDayShiftInput.findViewById(R.id.btn_1800);
        btn_2000 = inputWeekDayShiftInput.findViewById(R.id.btn_2000);
        btn_close = inputWeekDayShiftInput.findViewById(R.id.btn_close);

        dialogBuilder.setView(inputWeekDayShiftInput);
        dialog = dialogBuilder.create();
        dialog.show();

        btn_0000.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_sundaytwo.setText("0000");
                dialog.dismiss();
            }
        });

        btn_0630.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_sundaytwo.setText("0630");
                dialog.dismiss();
            }
        });

        btn_0700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundaytwo.setText("0700");
                dialog.dismiss();
            }
        });

        btn_0730.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundaytwo.setText("0730");
                dialog.dismiss();
            }
        });

        btn_0800.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundaytwo.setText("0800");
                dialog.dismiss();
            }
        });

        btn_0830.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundaytwo.setText("0830");
                dialog.dismiss();
            }
        });

        btn_0900.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_sundaytwo.setText("0900");
                dialog.dismiss();
            }
        });

        btn_1000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundaytwo.setText("1000");
                dialog.dismiss();
            }
        });

        btn_1100.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundaytwo.setText("1100");
                dialog.dismiss();
            }
        });

        btn_1200.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundaytwo.setText("1200");
                dialog.dismiss();
            }
        });

        btn_1530.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundaytwo.setText("1530");
                dialog.dismiss();
            }
        });

        btn_1600.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundaytwo.setText("1600");
                dialog.dismiss();
            }
        });

        btn_1700.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundaytwo.setText("1700");
                dialog.dismiss();
            }
        });

        btn_1800.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                btn_sundaytwo.setText("1800");
                dialog.dismiss();
            }
        });

        btn_2000.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundaytwo.setText("2000");
                dialog.dismiss();
            }
        });

        btn_close.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                btn_sundaytwo.setText("----");
                dialog.dismiss();
            }
        });
    };
}