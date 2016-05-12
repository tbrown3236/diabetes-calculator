package com.example.diabetescalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by terrybrown on 4/26/16.
 */
public class preferences extends baseActivity  {

   // Button savePreferences = findViewById(R.id)
    EditText edtDrEmail;
    EditText edtSubject;
    EditText edtDrNotes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.preferences );
        edtDrEmail = (EditText)findViewById( R.id.edtDrEmail);
        edtSubject = (EditText)findViewById( R.id.edtSubject);
        edtDrNotes = (EditText)findViewById( R.id.edtDrNotes);
    }
    public void savePreferencesClick ( View v ){

         drEmail = edtDrEmail.getText().toString();
         drSubject = edtSubject.getText().toString();
         drNotes = edtDrNotes.getText().toString();
        savesPreferences();
        toastit("Preferences Saved: ");
    }

    public void savesPreferences(){
        //save preferences to file
    }
}
