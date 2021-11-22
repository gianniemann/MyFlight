package com.example.myflight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.orm.SugarContext;

public class MainActivity extends AppCompatActivity{
  /**Button btnHit;
    TextView txtJson;
    ProgressDialog pd;**/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SugarContext.init(this);

        /*List<Benutzer> b2= Benutzer.listAll(Benutzer.class);
        for (Benutzer b11 : b2) {
            System.out.println("halloooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
            System.out.println(b11.getName());
            Log.d( "DB_Test", "Benutzername: !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }*/
        //Test goToZielort();

        BenutzerDAO bDAO = new BenutzerDAO();
        Benutzer benutzer;

        try {
            benutzer = bDAO.readBenutzer();
        }catch (Exception e){
            e.printStackTrace();
            benutzer = null;
        }

        Bundle bundle = new Bundle();


        if (benutzer != null){
            goToZielort();
        }else{
            setContentView(R.layout.welcome_page);
            Button next = (Button) findViewById(R.id.speichernbtn);

            next.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    EditText nameFeld = (EditText) findViewById(R.id.editTextTextPersonName);
                    String name = nameFeld.getText().toString();
                    bundle.putString("BenutzerName", name);

                    Intent myIntent = new Intent(view.getContext(), Zielort.class);
                    myIntent.putExtras(bundle);
                    startActivity(myIntent);
                }
            });
        }

    }
    private void goToZielort() {
        Intent myIntent = new Intent(this, Zielort.class);
        startActivity(myIntent);
    }



    /**
     btnHit = (Button) findViewById(R.id.btnHit);
    txtJson = (TextView) findViewById(R.id.tvJsonItem);

btnHit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new JsonTask().execute("Url address here");
        }
    });
**/
}