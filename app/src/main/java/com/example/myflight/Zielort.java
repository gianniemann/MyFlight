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

        BenutzerDAO bDAO = new BenutzerDAO();
        Benutzer benutzerDB = bDAO.readBenutzer();

        if (benutzerDB != null){
            TextView willkommen = (TextView) findViewById(R.id.textView3);
            willkommen.append(" " + benutzerDB.getName());

        }else {
            Bundle bundle = getIntent().getExtras();
            String benutzerName = bundle.getString("BenutzerName");
            Benutzer b = new Benutzer(benutzerName);

            bDAO.insertBenutzer(b);

            TextView willkommen = (TextView) findViewById(R.id.textView3);
            willkommen.append(" " + b.getName());
        }
    }
}
