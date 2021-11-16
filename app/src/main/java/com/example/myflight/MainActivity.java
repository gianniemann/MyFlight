package com.example.myflight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
  /**Button btnHit;
    TextView txtJson;
    ProgressDialog pd;**/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);
        Button next = (Button) findViewById(R.id.speichernbtn);
        EditText nameFeld = (EditText) findViewById(R.id.editTextTextPersonName);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name = nameFeld.getText().toString();
                Intent myIntent = new Intent(view.getContext(), Zielort.class);
                Bundle bundle = new Bundle();
                bundle.putString("BenutzerName", name);
                myIntent.putExtras(bundle);
                startActivity(myIntent);
            }
        });
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