package com.example.diabetescalc;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Switch;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by brandon on 3/15/16.
 */
public class Alarm {

    Intent alarmIntent;
    PendingIntent pi;
    EditText notesText,dateText,timeText;
    Switch active;


    Switch recurring;
    Integer alarmID;
    Context context;
    Calendar cal;



    public Alarm( EditText notesText, EditText dateText, EditText timeText, Switch active, Switch recurring, Integer alarmID, Context context, Calendar cal)
    {

        this.notesText = notesText;
        this.dateText = dateText;
        this.timeText = timeText;
        this.active = active;

        this.recurring = recurring;
        this.alarmID = alarmID;
        this.context = context;
        this.cal = cal;

        this.alarmIntent = new Intent("com.example.diabetescalc");
        this.alarmIntent.putExtra( "alarm", this.alarmID );
        this.pi = PendingIntent.getBroadcast( context, this.alarmID, alarmIntent, PendingIntent.FLAG_CANCEL_CURRENT );
        setTags();
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "alarmIntent=" + alarmIntent +
                ", pi=" + pi +
                ", notesText=" + notesText +
                ", dateText=" + dateText +
                ", timeText=" + timeText +
                ", active=" + active +
                ", recurring=" + recurring +
                ", alarmID=" + alarmID +
                ", context=" + context +
                ", cal=" + cal +
                '}';
    }

    public void setTags(){
        notesText.setTag( this);
        dateText.setTag(this);
        timeText.setTag(this);
        active.setTag(this);
        recurring.setTag(this);
    }


    public void updateDateTime() {
        String myFormat = "MM-dd-yy hh:mm a";
        SimpleDateFormat sdf = new SimpleDateFormat( myFormat, Locale.US );
        dateText.setText( sdf.format( cal.getTime() ) );


    }
    public void setNotes( String notes ) {
        notesText.setText( notes );
        alarmIntent.putExtra( "notes", notesText.getText().toString() );
    }
    public void setAlarm( String date ) {
        dateText.setText( date );
        alarmIntent.putExtra( date, dateText.getText().toString() );
    }
}
