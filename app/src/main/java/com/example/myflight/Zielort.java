package com.example.myflight;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.orm.SugarContext;

public class Zielort extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zielort);
        SugarContext.init(this);

        String text;
        BenutzerDAO bDAO = new BenutzerDAO();
        Benutzer benutzerDB;
        try {
            benutzerDB = bDAO.readBenutzer();
        }catch (Exception e){
            e.printStackTrace();
            benutzerDB = null;
        }


        if (benutzerDB != null){
            text = "Willkommen " + benutzerDB.getName();
            TextView willkommen = (TextView) findViewById(R.id.willkommen);
            willkommen.setText(text);

        }else {
            Bundle bundle = getIntent().getExtras();
            String benutzerName = bundle.getString("BenutzerName");
            Benutzer b = new Benutzer(benutzerName);

            bDAO.insertBenutzer(b);

            text = "Willkommen " + b.getName();

            TextView willkommen = (TextView) findViewById(R.id.willkommen);
            willkommen.setText(text);
        }


    }

}
