package com.example.myflight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
  /**Button btnHit;
    TextView txtJson;
    ProgressDialog pd;**/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);
        Button next = (Button) findViewById(R.id.speichernbtn);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Zielort.class);
                startActivityForResult(myIntent, 0);
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