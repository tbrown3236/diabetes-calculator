package com.example.diabetescalc;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by spike on 1/27/2016.
 */
public class baseActivity extends Activity {

    String delimiter = "<=>";
    String BloodSugarFileName = "Log.txt";
    String AlarmFileName = "AlarmLog.txt";
    public static String drEmail;
    public static String drSubject;
    public static String drNotes;
    public void toastit(String msg ) {
        Toast.makeText( getApplicationContext(),msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
      getMenuInflater().inflate(R.menu.mastermenu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId() ){
            case R.id.switchToBloodPage :
                SwitchToblood(null);

                break;
            case R.id.switchToLogPage :
                switchtologger(null);

                break;
            case R.id.switchToChartPage :
                switchToChart(null);
                break;
            case R.id.switchToAlarmPage :
                switchToAlarm(null);

                break;
            case R.id.switchToAbout :
                switchToAbout(null);

                break;
            case R.id.switchToPreferences :
                switchToPreferences(null);

                break;
            default:
                return  super.onOptionsItemSelected(item);
        }
        return true;
    }
    public void SwitchToblood( View v) {
        startActivity( new Intent(this, MyActivity.class));
    }
    public void switchToChart( View v) {
        //startActivity( new Intent(this, TerrysChart.class));
    }
    public void switchToAlarm( View v) {
        startActivity( new Intent(this, AlarmActivity.class));
    }
    public void switchtologger(View v){
        Intent extras = new Intent(this,logFile.class);
        extras.putExtra("Answer",MyActivity.txtanswer.getText().toString());
        extras.putExtra("Glucose",MyActivity.edtglucose.getText().toString());
        extras.putExtra("Blood",MyActivity.blood);
        startActivity(extras);
    }
    public void switchToAbout( View v) {
        startActivity( new Intent(this, About.class));
    }
    public void switchToPreferences( View v) {startActivity( new Intent(this, preferences.class));}

}
