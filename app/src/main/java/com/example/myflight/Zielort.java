package com.example.myflight;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Zielort extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zielort);
        Bundle bundle = getIntent().getExtras();
        String benutzerName = bundle.getString("BenutzerName");
        Benutzer b = new Benutzer(benutzerName);
        TextView willkommen = (TextView) findViewById(R.id.textView3);
        willkommen.append(" "+b.getName());
    }
}
