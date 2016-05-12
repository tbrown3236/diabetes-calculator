package com.example.diabetescalc;

import android.app.*;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TimePicker;

import java.io.FileOutputStream;
import java.util.Calendar;


/**
 * Created by brandon on 3/13/16.
 */


public class AlarmActivity extends baseActivity {

    private Alarm currentAlarm;
    private PendingIntent pi;
    private AlarmManager am;
    private Calendar a = Calendar.getInstance();
    private BroadcastReceiver br;
    TimePickerDialog timePicker;
    private Switch switchRecurring1;
    private Switch switchRecurring2;
    private Switch switchRecurring3;
    private Switch switchRecurring4;
    private Switch switchRecurring5;
    private Switch switchRecurring6;
    private Switch switchRecurring7;
    private Switch switchRecurring8;
    private Switch switchRecurring9;
    private Switch switchRecurring10;
    private Switch switchActive1;
    private Switch switchActive2;
    private Switch switchActive3;
    private Switch switchActive4;
    private Switch switchActive5;
    private Switch switchActive6;
    private Switch switchActive7;
    private Switch switchActive8;
    private Switch switchActive9;
    private Switch switchActive10;
    private Alarm[] alarms = new Alarm[10];
    private EditText notesText1;
    private EditText notesText2;
    private EditText notesText3;
    private EditText notesText4;
    private EditText notesText5;
    private EditText notesText6;
    private EditText notesText7;
    private EditText notesText8;
    private EditText notesText9;
    private EditText notesText10;
    private EditText dateText1;
    private EditText dateText2;
    private EditText dateText3;
    private EditText dateText4;
    private EditText dateText5;
    private EditText dateText6;
    private EditText dateText7;
    private EditText dateText8;
    private EditText dateText9;
    private EditText dateText10;
    private EditText timeText1;
    private EditText timeText2;
    private EditText timeText3;
    private EditText timeText4;
    private EditText timeText5;
    private EditText timeText6;
    private EditText timeText7;
    private EditText timeText8;
    private EditText timeText9;
    private EditText timeText10;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarmslayout);


        switchRecurring1 = (Switch) findViewById(R.id.SwitchRecurring1);
        switchRecurring2 = (Switch) findViewById(R.id.SwitchRecurring2);
        switchRecurring3 = (Switch) findViewById(R.id.SwitchRecurring3);
        switchRecurring4 = (Switch) findViewById(R.id.SwitchRecurring4);
        switchRecurring5 = (Switch) findViewById(R.id.SwitchRecurring5);
        switchRecurring6 = (Switch) findViewById(R.id.SwitchRecurring6);
        switchRecurring7 = (Switch) findViewById(R.id.SwitchRecurring7);
        switchRecurring8 = (Switch) findViewById(R.id.SwitchRecurring8);
        switchRecurring9 = (Switch) findViewById(R.id.SwitchRecurring9);
        switchRecurring10 = (Switch) findViewById(R.id.SwitchRecurring10);
        switchActive1 = (Switch) findViewById(R.id.alarmswitch1);
        switchActive2 = (Switch) findViewById(R.id.alarmswitch2);
        switchActive3 = (Switch) findViewById(R.id.alarmswitch3);
        switchActive4 = (Switch) findViewById(R.id.alarmswitch4);
        switchActive5 = (Switch) findViewById(R.id.alarmswitch5);
        switchActive6 = (Switch) findViewById(R.id.alarmswitch6);
        switchActive7 = (Switch) findViewById(R.id.alarmswitch7);
        switchActive8 = (Switch) findViewById(R.id.alarmswitch8);
        switchActive9 = (Switch) findViewById(R.id.alarmswitch9);
        switchActive10 = (Switch) findViewById(R.id.alarmswitch10);
        notesText1 = (EditText) findViewById(R.id.edtnotes1);
        notesText2 = (EditText) findViewById(R.id.edtnotes2);
        notesText3 = (EditText) findViewById(R.id.edtnotes3);
        notesText4 = (EditText) findViewById(R.id.edtnotes4);
        notesText5 = (EditText) findViewById(R.id.edtnotes5);
        notesText6 = (EditText) findViewById(R.id.edtnotes6);
        notesText7 = (EditText) findViewById(R.id.edtnotes7);
        notesText8 = (EditText) findViewById(R.id.edtnotes8);
        notesText9 = (EditText) findViewById(R.id.edtnotes9);
        notesText10 = (EditText) findViewById(R.id.edtnotes10);
        dateText1 = (EditText) findViewById(R.id.edtDate1);
        dateText2 = (EditText) findViewById(R.id.edtDate2);
        dateText3 = (EditText) findViewById(R.id.edtDate3);
        dateText4 = (EditText) findViewById(R.id.edtDate4);
        dateText5 = (EditText) findViewById(R.id.edtDate5);
        dateText6 = (EditText) findViewById(R.id.edtDate6);
        dateText7 = (EditText) findViewById(R.id.edtDate7);
        dateText8 = (EditText) findViewById(R.id.edtDate8);
        dateText9 = (EditText) findViewById(R.id.edtDate9);
        dateText10 = (EditText) findViewById(R.id.edtDate10);
        timeText1 = (EditText) findViewById(R.id.edtTime1);
        timeText2 = (EditText) findViewById(R.id.edtTime2);
        timeText3 = (EditText) findViewById(R.id.edtTime3);
        timeText4 = (EditText) findViewById(R.id.edtTime4);
        timeText5 = (EditText) findViewById(R.id.edtTime5);
        timeText6 = (EditText) findViewById(R.id.edtTime6);
        timeText7 = (EditText) findViewById(R.id.edtTime7);
        timeText8 = (EditText) findViewById(R.id.edtTime8);
        timeText9 = (EditText) findViewById(R.id.edtTime9);
        timeText10 = (EditText) findViewById(R.id.edtTime10);


        br = new BroadcastReceiver(){
            @Override
            public void onReceive( Context context, Intent intent ){

                int alarmID = 0;

                Bundle extras = intent.getExtras();
                if (extras != null) {
                     alarmID = extras.getInt( "alarm" );
                    if( alarms[alarmID].recurring.isChecked()){
                      //  alarms[ alarmID ].cal.add( Calendar.HOUR, 24 );
                        am.set( AlarmManager.RTC_WAKEUP, alarms[ alarmID ].cal.getTimeInMillis(), alarms[ alarmID ].pi );
                    }

                }

                createnotification(alarmID );

            }
        };

        registerReceiver(br, new IntentFilter("com.example.diabetescalc"));

        am = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);


        alarms[0] = new Alarm(notesText1, dateText1, timeText1, switchActive1,switchRecurring1,  0, this, Calendar.getInstance());
        alarms[1] = new Alarm(notesText2, dateText2, timeText2, switchActive2,switchRecurring2,  1, this, Calendar.getInstance());
        alarms[2] = new Alarm(notesText3, dateText3, timeText3, switchActive3,switchRecurring3,  2, this, Calendar.getInstance());
        alarms[3] = new Alarm(notesText4, dateText4, timeText4, switchActive4,switchRecurring4,  3, this, Calendar.getInstance());
        alarms[4] = new Alarm(notesText5, dateText5, timeText5, switchActive5,switchRecurring5,  4, this, Calendar.getInstance());
        alarms[5] = new Alarm(notesText6, dateText6, timeText6, switchActive6,switchRecurring6,  5, this, Calendar.getInstance());
        alarms[6] = new Alarm(notesText7, dateText7, timeText7, switchActive7,switchRecurring7,  6, this, Calendar.getInstance());
        alarms[7] = new Alarm(notesText8, dateText8, timeText8, switchActive8,switchRecurring8,  7, this, Calendar.getInstance());
        alarms[8] = new Alarm(notesText9, dateText9, timeText9, switchActive9,switchRecurring9,  8, this, Calendar.getInstance());
        alarms[9] = new Alarm(notesText10, dateText10, timeText10,switchActive10, switchRecurring10,  9, this, Calendar.getInstance());





    }



    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet( DatePicker view, int year, int monthOfYear, int dayOfMonth ) {
            Alarm am = currentAlarm;

            am.cal.set( Calendar.YEAR, year );
            am.cal.set( Calendar.MONTH, monthOfYear );
            am.cal.set( Calendar.DAY_OF_MONTH, dayOfMonth );
            am.updateDateTime();
            timePicker.show();  // Launches the TimePicker right after the DatePicker closes
        }
    };

    TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet( TimePicker view, int hour, int minute ) {
            Alarm am = currentAlarm;
            am.cal.set( Calendar.HOUR, hour );
            am.cal.set( Calendar.MINUTE, minute );
            am.updateDateTime();
        }
    };

    public void activeOnClick1( View view ) {
        Alarm am = (Alarm)view.getTag();
        currentAlarm = am;
        timePicker = new TimePickerDialog(AlarmActivity.this, time,
                am.cal.get( Calendar.HOUR ),
                am.cal.get( Calendar.MINUTE ), false );
         new DatePickerDialog( AlarmActivity.this, date,
                am.cal.get( Calendar.YEAR ),
                am.cal.get( Calendar.MONTH ),
                am.cal.get( Calendar.DAY_OF_MONTH ) ).show();
    }

    public void toggleAlarm( View v ) {
        if( v.getId() == switchActive1.getId() ) {
            if (switchActive1.isChecked()) {
                alarms[0].setNotes(notesText1.getText().toString());
                am.set(AlarmManager.RTC_WAKEUP, alarms[0].cal.getTimeInMillis(), alarms[0].pi);

                toastit("Alarm On: " + notesText1.getText().toString());
            }else {
                toastit( "Alarm Off: " + notesText2.getText().toString() );
            }

        } else if( v.getId() == switchActive2.getId() ) {
            if( switchActive2.isChecked() ) {
                alarms[1].setNotes( notesText2.getText().toString() );
                am.set( AlarmManager.RTC_WAKEUP, alarms[ 1 ].cal.getTimeInMillis(), alarms[ 1 ].pi );
                toastit( "Alarm On: " + notesText2.getText().toString());

            } else {
                toastit( "Alarm Off: " + notesText2.getText().toString() );
            }
        }
        else if( v.getId() == switchActive3.getId() ) {
            if( switchActive3.isChecked() ) {
                alarms[2].setNotes( notesText3.getText().toString() );
                am.set( AlarmManager.RTC_WAKEUP, alarms[ 2 ].cal.getTimeInMillis(), alarms[ 2 ].pi );
                toastit( "Alarm On: " + notesText3.getText().toString()  );

            } else {
                toastit( "Alarm Off: " + notesText3.getText().toString() );
            }
        }
        else if( v.getId() == switchActive4.getId() ) {
            if( switchActive4.isChecked() ) {
                alarms[3].setNotes( notesText4.getText().toString() );
                am.set( AlarmManager.RTC_WAKEUP, alarms[ 3 ].cal.getTimeInMillis(), alarms[ 3 ].pi );
                toastit( "Alarm On: " + notesText4.getText().toString() );

            } else {
                toastit( "Alarm Off: " + notesText4.getText().toString() );
            }
        }
        else if( v.getId() == switchActive5.getId() ) {
            if( switchActive5.isChecked() ) {
                alarms[4].setNotes( notesText5.getText().toString() );
                am.set( AlarmManager.RTC_WAKEUP, alarms[ 4 ].cal.getTimeInMillis(), alarms[ 4 ].pi );
                toastit( "Alarm On: " +  notesText5.getText().toString()  );

            } else {
                toastit( "Alarm Off: " + notesText5.getText().toString() );
            }
        }
        else if( v.getId() == switchActive6.getId() ) {
            if( switchActive6.isChecked() ) {
                alarms[5].setNotes( notesText6.getText().toString() );
                am.set( AlarmManager.RTC_WAKEUP, alarms[ 5 ].cal.getTimeInMillis(), alarms[ 5 ].pi );
                toastit( "Alarm On: " + notesText6.getText().toString() );

            } else {
                toastit( "Alarm Off: " + notesText6.getText().toString() );
            }
        }
        else if( v.getId() == switchActive7.getId() ) {
            if( switchActive7.isChecked() ) {
                alarms[6].setNotes( notesText7.getText().toString() );
                am.set( AlarmManager.RTC_WAKEUP, alarms[ 6 ].cal.getTimeInMillis(), alarms[ 6 ].pi );
                toastit( "Alarm On: " + notesText7.getText().toString() );

            } else {
                toastit( "Alarm Off: " + notesText7.getText().toString() );
            }
        }
        else if( v.getId() == switchActive8.getId() ) {
            if( switchActive8.isChecked() ) {
                alarms[7].setNotes( notesText8.getText().toString() );
                am.set( AlarmManager.RTC_WAKEUP, alarms[ 7 ].cal.getTimeInMillis(), alarms[ 7 ].pi );
                toastit( "Alarm On: " + notesText8.getText().toString());

            } else {
                toastit( "Alarm Off: " + notesText8.getText().toString() );
            }
        }
        else if( v.getId() == switchActive9.getId() ) {
            if( switchActive2.isChecked() ) {
                alarms[8].setNotes( notesText9.getText().toString() );
                am.set( AlarmManager.RTC_WAKEUP, alarms[ 8 ].cal.getTimeInMillis(), alarms[ 8 ].pi );
                toastit( "Alarm On: " + notesText9.getText().toString() );

            } else {
                toastit( "Alarm Off: " + notesText9.getText().toString() );
            }
        }
        else if( v.getId() == switchActive10.getId() ) {
            if( switchActive10.isChecked() ) {
                alarms[9].setNotes( notesText10.getText().toString() );
                am.set( AlarmManager.RTC_WAKEUP, alarms[ 9 ].cal.getTimeInMillis(), alarms[ 9 ].pi );
                toastit( "Alarm On: " + notesText10.getText().toString() );

            } else {
                toastit( "Alarm Off: " + notesText10.getText().toString() );
            }
        }
    }




    public void createnotification(int alarmID) {

        Intent intent = new Intent(this, AlarmActivity.class);
        PendingIntent pintent = PendingIntent.getActivity(this, alarmID, intent, 0);
        Notification n = new Notification.Builder(this)
                .setContentTitle("Medication Alarm")
                .setContentText(alarms[alarmID].notesText.getText().toString())
                .setSmallIcon(R.drawable.ic_alarm)
                .setContentIntent(pintent)
                .build();
      //  toastit( "alarm"  );


        NotificationManager notificationManager =
                (NotificationManager)getSystemService( NOTIFICATION_SERVICE );
        notificationManager.notify( alarmID,n );

    }


    public void saveAlarmData(View v){
        String dataPoint =" ";

        for(int i = 0;i <= 8; i++)
            dataPoint +=alarms[i];
        Log.i("Alarm Log", dataPoint );

        try{
            FileOutputStream out = openFileOutput( AlarmFileName, Context.MODE_PRIVATE);
            out.write( dataPoint.getBytes() );
            out.close();
            toastit( "Alarms Saved" );
        } catch ( Exception ex){
            ex.printStackTrace();
        }

    }
    @Override
    protected void onDestroy() {
        am.cancel( pi );
        unregisterReceiver( br );
        super.onDestroy();
    }

}
