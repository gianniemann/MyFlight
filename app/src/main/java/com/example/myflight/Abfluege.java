package com.example.myflight;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Abfluege extends Activity {
    TableLayout table;
    String search;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abfluege);
        Bundle bundle = getIntent().getExtras();
        search = bundle.getString("ZielOrt");
        new JsonTask().execute("https://dxp-fds.flughafen-zuerich.ch/flights");
        Button zurueck = (Button) findViewById(R.id.zurueckbtn);
        zurueck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Zielort.class);
                startActivity(myIntent);
            }
        });
        Button search = (Button) findViewById(R.id.searchbtn);
        EditText zielort = (EditText) findViewById(R.id.zielortListeInput);
        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String zielorttxt = zielort.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("ZielOrt", zielorttxt);

                Intent myIntent = new Intent(Abfluege.this, Abfluege.class);
                myIntent.putExtras(bundle);
                startActivity(myIntent);
            }
        });
    }


    private class JsonTask extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();

        }

        /**
         *
         * @param params
         * @return JSON as String
         */
        protected String doInBackground(String... params) {


            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();


                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                    Log.d("Response: ", "> " + line + "\n");   //here u ll get whole response...... :-)

                }
                return buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        /**
         *
         * @param result
         */
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                table = (TableLayout) findViewById(R.id.myTableLayout1);
                JSONArray jsonArray = new JSONArray(result);
                List<String> flugnummern = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsnobj = jsonArray.getJSONObject(i);
                    TableRow row = new TableRow(new ContextThemeWrapper(Abfluege.this,R.style.MyTableRowStyle));
                    String flugnummer = "";
                    String std = "";
                    String etd = "";
                    String cityDe = "";
                    String statusTextDe = "";
                    String airline = "";
                    String typ = "";



                    List<String> testList = new ArrayList<>();
                    String testString = "abc";
                    testList.add(testString);

                    if(!testList.contains("abc")){
                        Log.d("TEST SUCCESSFULL","abc is not in testlist");
                    }else{
                        Log.d("TEST UNSUCCESSFULL","abc is in testlist");
                    }

                    if (jsnobj.has("FLC") && jsnobj.has("FLN"))
                        flugnummer = jsnobj.getString("FLC");
                        flugnummer += " " + jsnobj.getString("FLN");

                    if (jsnobj.getString("flightType").equals("D") && jsnobj.getString("search").contains(search) && !flugnummern.contains(flugnummer)) {
                        if (jsnobj.has("FLC") && jsnobj.has("FLN"))
                            flugnummern.add(flugnummer);
                        System.out.println(flugnummern);

                        if (jsnobj.has("STD"))
                            std = jsnobj.getString("STD");

                        if (jsnobj.has("ETD"))
                            etd = jsnobj.getString("ETD");

                        if (jsnobj.has("cityDe"))
                            cityDe = jsnobj.getString("cityDe");

                        if (jsnobj.has("statusTextDe"))
                            statusTextDe = jsnobj.getString("statusTextDe");

                        if (jsnobj.has("airline"))
                            airline = jsnobj.getString("airline");

                        if (jsnobj.has("TYP"))
                            typ = jsnobj.getString("TYP");


                        TextView tv1 = new TextView(new ContextThemeWrapper(Abfluege.this,R.style.MyTextViewStyle));
                        tv1.setText(flugnummer);
                        TextView tv2 = new TextView(new ContextThemeWrapper(Abfluege.this,R.style.MyTextViewStyle));
                        if(!std.equalsIgnoreCase(""))
                            std = convertDate(std);

                        tv2.setText(std);
                        TextView tv3 = new TextView(new ContextThemeWrapper(Abfluege.this,R.style.MyTextViewStyle));
                        if(!etd.equalsIgnoreCase(""))
                            etd = convertDate(etd);

                        tv3.setText(etd);
                        TextView tv4 = new TextView(new ContextThemeWrapper(Abfluege.this,R.style.MyTextViewStyle));
                        tv4.setText(cityDe);
                        TextView tv5 = new TextView(new ContextThemeWrapper(Abfluege.this,R.style.MyTextViewStyle));
                        tv5.setText(statusTextDe);
                        TextView tv6 = new TextView(new ContextThemeWrapper(Abfluege.this,R.style.MyTextViewStyle));
                        tv6.setText(airline);
                        TextView tv7 = new TextView(new ContextThemeWrapper(Abfluege.this,R.style.MyTextViewStyle));
                        tv7.setText(typ);


                        row.addView(tv1);
                        row.addView(tv2);
                        row.addView(tv3);
                        row.addView(tv4);
                        row.addView(tv5);
                        row.addView(tv6);
                        row.addView(tv7);
                        table.addView(row);
                    }

                }
                Log.d("JSON DONE","JSON SUCCESFULLY READ");
            } catch (JSONException e) {
                e.printStackTrace();
                Log.d("JSON FAILED","JSON FAILED READ");
            }


        }

        /**
         *
         * @param std
         * @return std
         */
        public String convertDate(String std){
            String date_s = std;
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            try {
                Date date = dt.parse(date_s);

                SimpleDateFormat dt1 = new SimpleDateFormat("HH:mm");
                System.out.println(dt1.format(date));
                std = dt1.format(date);
            }catch(Exception e){
                e.printStackTrace();
            }

            return std;
        }
    }
}