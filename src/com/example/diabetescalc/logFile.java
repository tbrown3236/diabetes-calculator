package com.example.diabetescalc;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class logFile extends baseActivity {
    /**
     * Called when the activity is first created.
     */
    Button btnback;
    Double blood;

    String a1c;
    String glucose;
    String answer;
    EditText edta1clog;
    EditText edtanswerlog;


    EditText edtnotes;
    TextView edtDate;
    TextView edtTime;
    private Calendar c = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, monthOfYear);
            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setCurrentDateOnView();
        }
    };

    TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener(){
        @Override
        public void onTimeSet ( TimePicker view, int hourOfDay, int minute){
            c.set(Calendar.HOUR_OF_DAY,hourOfDay);
            c.set(Calendar.MINUTE,minute);
            setCurrentDateOnView();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log);
        edtanswerlog = (EditText) findViewById(R.id.edtanswerlog);


        edtnotes = (EditText) findViewById(R.id.edtnotes);
        edtDate = (TextView) findViewById(R.id.edtStartDate);
        edtTime = (TextView) findViewById(R.id.edtTime);

        getIntentData();
        setCurrentDateOnView();
    }
    public void emailLogToDr (View v){
        // send the email
        toastit("Email sent to: " + drEmail );
        String subject = "Subject: \n\n" + drSubject;
        String notes = "Dr. Notes: \n\n" + drNotes;

        //create intent to use email system on ondroid
        final Intent emailIntent = new Intent (Intent.ACTION_SEND );
        

    }
    public void dateonClick(View v){
        new DatePickerDialog(this, date, c.get( Calendar.YEAR),
                c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show();
    }
    public  void  timeOnClick ( View v){
        new TimePickerDialog(this , time, c.get(Calendar.HOUR),
                c.get(Calendar.MINUTE), false).show();
    }


    private void getIntentData() {
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            answer = extras.getString("Answer");

            edtanswerlog.setText(answer);




        }
    }
    public  void setCurrentDateOnView(){
        String dateFormat =  "MM/dd/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.US );
        edtDate.setText( sdf.format(c.getTime()) );

        SimpleDateFormat stf = new SimpleDateFormat( "hh:mm a", Locale.US);
        edtTime.setText( stf.format(c.getTime()) );

    }


    public void saveData(View v){
        String dataPoint =
                edtDate.getText().toString() +
                        delimiter + edtTime.getText().toString()+
                        delimiter+ edtanswerlog.getText().toString()+
                        delimiter+ edtnotes.getText().toString() + "\n";
        Log.i("Blood Sugar", dataPoint );

        try{
            FileOutputStream out = openFileOutput( BloodSugarFileName, Context.MODE_APPEND);
            out.write( dataPoint.getBytes() );
            out.close();
            toastit( "Entry Saved" );
        } catch ( Exception ex){
            ex.printStackTrace();
        }

    }
    @Override
    protected void onResume(){
        super.onResume();
        getIntentData();
    }
    public void SwitchToblood( View v) {
        startActivity( new Intent(this, MyActivity.class));
    }
    public void switchToChart( View v) {
      //  startActivity( new Intent(this, TerrysChart.class));
    }
}

