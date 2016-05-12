package com.example.diabetescalc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by terrybrown on 4/13/16.
 */
public class About extends baseActivity{

  //  Button contact = (Button)findViewById( R.id.btnContact);
  //  Button about = (Button)findViewById( R.id.btnAbout);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

    }

    public void clickContact(View v) {
        Intent contactIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://portfolio.theterrybrown.com/contact.php"));
        startActivity( contactIntent );

    }
    public void clickAbout(View v) {
        Intent aboutIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://portfolio.theterrybrown.com/about.php"));
        startActivity( aboutIntent );

    }


}
