package com.example.diabetescalc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MyActivity extends baseActivity {
    /**
     * Called when the activity is first created.
     */
    Button calculate;
   public static EditText edtglucose;
    public static EditText edta1c;
    RadioButton rdoadag;
    RadioButton rdodcct;
   public static TextView txtanswer;
    public static double blood;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        calculate = (Button)findViewById(R.id.btncalc);
        edtglucose = (EditText)findViewById(R.id.edtglucose);
        edta1c = (EditText)findViewById(R.id.edta1c);
        rdoadag = (RadioButton)findViewById(R.id.rdoadag);
        rdodcct = (RadioButton)findViewById(R.id.rdodcct);
        txtanswer = (EditText) findViewById(R.id.txtanswer);
    }
    public void radiobuttonclicked(View v){

    }
    public void switchtologger(View v){
        Intent extras = new Intent(this,logFile.class);
        extras.putExtra("Answer",txtanswer.getText().toString());
        extras.putExtra("Glucose",edtglucose.getText().toString());
        extras.putExtra("Blood",blood);
        startActivity(extras);
    }
    public void calculate(View v){
        //get data from txt view
        // ADAG Formula: Average Blood Glucose eAG = (1.583 * A1c - 2.52) * 18.05
        //DCCT Formula:   eAG = (A1c * 35.6) - 77.3
        Double glucose = Double.parseDouble(edtglucose.getText().toString());
        Double a1c = Double.parseDouble(edta1c.getText().toString());
        if( (edtglucose.getText().length()==0)||(rdodcct.isChecked()))
        {
            Double dcct = (a1c * 35.6) - 77.3;
            txtanswer.setText(String.format("%.2f",dcct));
        }
        else if ( (edtglucose.getText().length()==0)||(rdoadag.isChecked()))
        {
            Double adag = (1.583 * a1c - 2.52) * 18.05;
            txtanswer.setText(String.format("%.2f",adag));
        }
        else if ( (edta1c.getText().length()==0)||(rdodcct.isChecked()))
        {
            Double dcct = (a1c * 35.6) - 77.3;
            txtanswer.setText(String.format("%.2f",dcct));
        }
        else if ( (edta1c.getText().length()==0)||(rdoadag.isChecked()))
        {
            Double adag = (1.583 * a1c - 2.52) * 18.05;
            txtanswer.setText(String.format("%.2f",adag));
        }

    }
    @Override
    public void onPause (){
        super.onPause();

    }
}

