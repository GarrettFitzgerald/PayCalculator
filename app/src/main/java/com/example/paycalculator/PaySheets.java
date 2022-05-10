package com.example.paycalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItemView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.O)
public class PaySheets extends AppCompatActivity
{
    // TODO Set date to last recent Monday in Array
    DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yy");
    LocalDate startDate;
    LocalDate endDate;
    LocalDate currentDate;
    LocalDate currentCycle;

    LocalDateTime date = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();


    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;

    Button btn_input;
    Button btn_breakdown;
    Button btn_back;
    TextView txt_dateselected;

    Button btn_previousdate;
    Button btn_currentdate;
    Button btn_futuredate;

    Button btn_information;
    Button btn_future;
    Button btn_history;

    ListView shiftList;
    String shifts[] = { "xx/xx/xx - xx/xx/xx",
        "xx/xx/xx - xx/xx/xx",
        "xx/xx/xx - xx/xx/xx",
        "xx/xx/xx - xx/xx/xx",
        "xx/xx/xx - xx/xx/xx"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_sheets);

        btn_previousdate = findViewById(R.id.btn_previousdate);
        btn_currentdate = findViewById(R.id.btn_currentdate);
        btn_futuredate = findViewById(R.id.btn_futuredate);
        btn_information = findViewById( R.id.btn_information);
        btn_future = findViewById( R.id.btn_future);
        btn_history = findViewById( R.id.btn_history);

        String username = getIntent().getStringExtra("Username");

        startDate = LocalDate.of(2022, 1,3);
        endDate = LocalDate.of(2022, 12,31);
        currentDate = LocalDate.now();

        List<LocalDate> newCycle = new ArrayList<>();

        while (startDate.isBefore(endDate))
        {
            newCycle.add(startDate);
            startDate = startDate.plusDays(14);
        }

        int i = 0;
        do
        {
            currentCycle = newCycle.get(i);
            i++;
        } while (currentDate.isAfter(newCycle.get(i)));

        btn_previousdate.setText( sdf.format( currentCycle.plusDays( -14 ) ) + " - " +
                                  sdf.format( currentCycle.plusDays( -1 ) ) );

        btn_currentdate.setText( sdf.format( currentCycle ) + " - " +
                                 sdf.format( currentCycle.plusDays( 13 ) ) );

        btn_futuredate.setText( sdf.format( currentCycle.plusDays( 14 ) ) + " - " +
                                sdf.format( currentCycle.plusDays( 27 ) ) );

        btn_information.setOnClickListener(new View.OnClickListener() //Sends user to Information activity
        {
            @Override
            public void onClick(View view)
            {
                Intent intentToInformation = new Intent(PaySheets.this, Information.class);
                intentToInformation.putExtra("Username", username );
                startActivity( intentToInformation );
            }
        });

        btn_history.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                createNewHistoryShiftsDialog();
            }
        });

        btn_future.setOnClickListener(new View.OnClickListener() //Loads up display with future pay sheets
        {
            @Override
            public void onClick(View view)
            {
                createNewFutureShiftDialog();
            }
        });

        btn_previousdate.setOnClickListener(new View.OnClickListener() //Creates popup for previous pay sheet
        {
            @Override
            public void onClick(View view)
            {
                createNewInputBreakdownDialog( currentCycle.plusDays( -14 ));
            }
        });

        btn_currentdate.setOnClickListener(new View.OnClickListener() //Creates popup for current pay sheet
        {
            @Override
            public void onClick(View view)
            {
                //TODO Check if entry matching user id and startdate exists
                createNewInputBreakdownDialog( currentCycle );
            }
        });

        btn_futuredate.setOnClickListener(new View.OnClickListener() //Creates popup for next pay sheet
        {
            @Override
            public void onClick(View view)
            {
                createNewInputBreakdownDialog( currentCycle.plusDays( 14 ));
            }
        });
    }

    public void createNewHistoryShiftsDialog()
    {
        dialogBuilder = new AlertDialog.Builder( PaySheets.this);
        View otherShiftsSelecter = getLayoutInflater().inflate( R.layout.popup_historyshifts, null );

        shiftList = otherShiftsSelecter.findViewById( R.id.list_shifts);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>( this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, shifts );
        shiftList.setAdapter(arr);

        dialogBuilder.setView( otherShiftsSelecter );
        dialog = dialogBuilder.create();
        dialog.show();
    }

    public void createNewFutureShiftDialog()
    {
        dialogBuilder = new AlertDialog.Builder( PaySheets.this);
        View otherShiftsSelecter = getLayoutInflater().inflate( R.layout.popup_futureshifts, null );

        shiftList = otherShiftsSelecter.findViewById( R.id.list_shifts);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>( this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, shifts );
        shiftList.setAdapter(arr);

        dialogBuilder.setView( otherShiftsSelecter );
        dialog = dialogBuilder.create();
        dialog.show();
    };

    public void createNewInputBreakdownDialog( LocalDate displayDate ) //Input and Breakdown Popup
    {
        dialogBuilder = new AlertDialog.Builder( PaySheets.this );
        View inputBreakdownPopUpView = getLayoutInflater().inflate( R.layout.popup_inputbreakdown, null );

        btn_back = inputBreakdownPopUpView.findViewById( R.id.btn_back );
        btn_input = inputBreakdownPopUpView.findViewById( R.id.btn_input );
        btn_breakdown = inputBreakdownPopUpView.findViewById( R.id.btn_breakdown);
        txt_dateselected = inputBreakdownPopUpView.findViewById(R.id.txt_dateselected);

                DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yy");
        txt_dateselected.setText( sdf.format( displayDate ) + " - " +
                                  sdf.format( displayDate.plusDays( 13 ) ) );

        String username = getIntent().getStringExtra("Username");

        dialogBuilder.setView( inputBreakdownPopUpView );
        dialog = dialogBuilder.create();
        dialog.show();

        btn_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dialog.dismiss();
            }
        });

        btn_input.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intentGoToShiftInput = new Intent ( PaySheets.this, ShiftInput.class);
                intentGoToShiftInput.putExtra("Username", username );
                startActivity( intentGoToShiftInput);
                            }
        });

        btn_breakdown.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intentGoToBreakdown = new Intent ( PaySheets.this, Breakdown.class);
                intentGoToBreakdown.putExtra("Username", username );
                startActivity( intentGoToBreakdown);
            }
        });
    }
}