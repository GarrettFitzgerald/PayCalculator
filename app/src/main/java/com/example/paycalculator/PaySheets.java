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
import java.util.Calendar;
import java.util.Date;

@RequiresApi(api = Build.VERSION_CODES.O)
public class PaySheets extends AppCompatActivity
{
    // TODO Set date to last recent Monday in Array
    LocalDateTime date = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    Calendar cal = Calendar.getInstance();
    DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yy");

    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;

    Button btn_input;
    Button btn_breakdown;
    Button btn_back;

    TextView txt_previousdate;
    TextView txt_currentdate;
    TextView txt_futuredate;

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

        txt_previousdate = findViewById(R.id.txt_previousdate);
        txt_currentdate = findViewById(R.id.txt_currentdate);
        txt_futuredate = findViewById(R.id.txt_futuredate);
        btn_information = findViewById( R.id.btn_information);
        btn_future = findViewById( R.id.btn_future);
        btn_history = findViewById( R.id.btn_history);

        txt_previousdate.setText( sdf.format( date.plusDays( -15 ) ) + " - " +
                                  sdf.format( date.plusDays( -1 ) ) );

        txt_currentdate.setText( sdf.format( date ) + " - " +
                                 sdf.format( date.plusDays( 13 ) ) );

        txt_futuredate.setText( sdf.format( date.plusDays( 14 ) ) + " - " +
                                sdf.format( date.plusDays( 27 ) ) );

        btn_information.setOnClickListener(new View.OnClickListener() //Sends user to Information activity
        {
            @Override
            public void onClick(View view)
            {
                Intent intentToInformation = new Intent(PaySheets.this, Information.class);
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

        txt_previousdate.setOnClickListener(new View.OnClickListener() //Creates popup for previous pay sheet
        {
            @Override
            public void onClick(View view)
            {
                createNewInputBreakdownDialog();
            }
        });

        txt_currentdate.setOnClickListener(new View.OnClickListener() //Creates popup for current pay sheet
        {
            @Override
            public void onClick(View view)
            {
                createNewInputBreakdownDialog();
            }
        });

        txt_futuredate.setOnClickListener(new View.OnClickListener() //Creates popup for next pay sheet
        {
            @Override
            public void onClick(View view)
            {
                createNewInputBreakdownDialog();
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

    public void createNewInputBreakdownDialog() //Input and Breakdown Popup
    {
        dialogBuilder = new AlertDialog.Builder( PaySheets.this );
        View inputBreakdownPopUpView = getLayoutInflater().inflate( R.layout.popup_inputbreakdown, null );

        btn_back = inputBreakdownPopUpView.findViewById( R.id.btn_back );
        btn_input = inputBreakdownPopUpView.findViewById( R.id.btn_input );
        btn_breakdown = inputBreakdownPopUpView.findViewById( R.id.btn_breakdown);

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
                startActivity( intentGoToShiftInput);
                            }
        });

        btn_breakdown.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intentGoToBreakdown = new Intent ( PaySheets.this, Breakdown.class);
                startActivity( intentGoToBreakdown);
            }
        });
    }
}