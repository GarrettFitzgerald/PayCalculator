package com.example.paycalculator;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItemView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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
    LocalDate toSendCycle;
    int currentID;

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

    DbHandler db = new DbHandler(PaySheets.this);

    ListView shiftList;
    List<LocalDate> shifts;

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
                Intent toLoginScreen=new Intent(PaySheets.this, LogInScreen.class);
                toLoginScreen.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(toLoginScreen);
                finish();
                break;
            case R.id.mnu_userlist:
                Intent toUserList=new Intent(PaySheets.this, UserList.class);
                startActivity(toUserList);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_sheets);

        btn_previousdate = findViewById(R.id.btn_previousdate);
        btn_currentdate = findViewById(R.id.btn_currentdate);
        btn_futuredate = findViewById(R.id.btn_futuredate);
        btn_information = findViewById(R.id.btn_information);

        int currentID = getIntent().getIntExtra("CurrentID", 0);

        startDate = LocalDate.of(2022, 1, 3);
        endDate = LocalDate.of(2022, 12, 31);
        currentDate = LocalDate.now();

        List<LocalDate> newCycle = new ArrayList<>();

        while (startDate.isBefore(endDate)) {
            newCycle.add(startDate);
            startDate = startDate.plusDays(14);
        }

        int i = 0;
        do {
            currentCycle = newCycle.get(i);
            i++;
        } while (currentDate.isAfter(newCycle.get(i)));

        btn_previousdate.setText(sdf.format(currentCycle.plusDays(-14)) + " - " +
                sdf.format(currentCycle.plusDays(-1)));

        btn_currentdate.setText(sdf.format(currentCycle) + " - " +
                sdf.format(currentCycle.plusDays(13)));

        btn_futuredate.setText(sdf.format(currentCycle.plusDays(14)) + " - " +
                sdf.format(currentCycle.plusDays(27)));

        btn_information.setOnClickListener(new View.OnClickListener() //Sends user to Information activity
        {
            @Override
            public void onClick(View view) {
                Intent intentToInformation = new Intent(PaySheets.this, Information.class);
                intentToInformation.putExtra("CurrentID", currentID);
                startActivity(intentToInformation);
            }
        });

        btn_currentdate.setOnClickListener(new View.OnClickListener() //Creates popup for current pay sheet
        {
            @Override
            public void onClick(View view)
            {
                createNewInputBreakdownDialog(currentCycle);
            }
        });

        btn_previousdate.setOnClickListener(new View.OnClickListener() //Creates popup for previous pay sheet
        {
            @Override
            public void onClick(View view) {
                toSendCycle = currentCycle.plusDays(-14);
                createNewInputBreakdownDialog(toSendCycle);
            }
        });

        btn_futuredate.setOnClickListener(new View.OnClickListener() //Creates popup for next pay sheet
        {
            @Override
            public void onClick(View view)
            {
                toSendCycle = currentCycle.plusDays( 14 );
                createNewInputBreakdownDialog( toSendCycle );
            }
        });
    }

    public void createNewInputBreakdownDialog( LocalDate displayDate ) //Input and Breakdown Popup
    {
        HashMap<String, String> tableDetails;
        dialogBuilder = new AlertDialog.Builder( PaySheets.this );
        View inputBreakdownPopUpView = getLayoutInflater().inflate( R.layout.popup_inputbreakdown, null );

        btn_back = inputBreakdownPopUpView.findViewById( R.id.btn_back );
        btn_input = inputBreakdownPopUpView.findViewById( R.id.btn_input );
        btn_breakdown = inputBreakdownPopUpView.findViewById( R.id.btn_breakdown);
        txt_dateselected = inputBreakdownPopUpView.findViewById(R.id.txt_dateselected);

        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yy");
        txt_dateselected.setText( sdf.format( displayDate ) + " - " +
                                  sdf.format( displayDate.plusDays( 13 ) ) );
        currentID = getIntent().getIntExtra("CurrentID", 0);

        Boolean tableExists = db.checkPayCycleExists( currentID, displayDate);
        if(tableExists == true)
        {
            // Load the table
            tableDetails = db.getPayCycleTable( currentID, displayDate);
        }
        else
        {
            // Create the table then load it

            PayCycleModal cycle = null;
            try
            {
                cycle = new PayCycleModal(-1, currentID, displayDate);
            }
            catch (Exception e)
            {
                Toast.makeText(PaySheets.this, "Error creating the table",Toast.LENGTH_SHORT).show();
            }

            DbHandler dbHandler = new DbHandler(PaySheets.this);
            dbHandler.insertTableDetails(cycle);

            //Load the table
            tableDetails = db.getPayCycleTable( currentID, displayDate);
        }

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
                intentGoToShiftInput.putExtra("tabledetails", (Serializable) tableDetails);
                intentGoToShiftInput.putExtra("CurrentID", currentID );
                startActivity( intentGoToShiftInput);
                dialog.dismiss();
            }
        });

        btn_breakdown.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intentGoToBreakdown = new Intent ( PaySheets.this, Breakdown.class);
                intentGoToBreakdown.putExtra("tabledetails", (Serializable) tableDetails);
                intentGoToBreakdown.putExtra("CurrentID", currentID );
                startActivity( intentGoToBreakdown);
                dialog.dismiss();
            }
        });
    }
}