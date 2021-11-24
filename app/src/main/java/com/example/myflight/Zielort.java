package com.example.myflight;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.orm.SugarContext;

public class Zielort extends Activity {

    /**
     * @param savedInstanceState
     */
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
        } catch (Exception e) {
            e.printStackTrace();
            benutzerDB = null;
        }


        if (benutzerDB != null) {
            text = "Willkommen " + benutzerDB.getName();
            TextView willkommen = (TextView) findViewById(R.id.willkommen);
            willkommen.setText(text);

        } else {
            Bundle bundle = getIntent().getExtras();
            String benutzerName = bundle.getString("BenutzerName");
            Benutzer b = new Benutzer(benutzerName);

            bDAO.insertBenutzer(b);

            text = "Willkommen " + b.getName();

            TextView willkommen = (TextView) findViewById(R.id.willkommen);
            willkommen.setText(text);
        }

        Button suchen = (Button) findViewById(R.id.button3);

        suchen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText zielortFeld = (EditText) findViewById(R.id.textInputEditText);
                String zielort = zielortFeld.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("ZielOrt", zielort);

                Intent myIntent = new Intent(view.getContext(), Abfluege.class);
                myIntent.putExtras(bundle);
                startActivity(myIntent);
            }
        });


        Button abmelden = (Button) findViewById(R.id.button2);

        abmelden.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                BenutzerDAO benutzerLoeschen = new BenutzerDAO();
                benutzerLoeschen.deleteBenutzer();

                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                startActivity(myIntent);
            }
        });

    }

}
