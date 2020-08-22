package com.example.oguz.android5_havadurumu;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    class WeatherInfo extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {
            try {

                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream is = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(is);

                int data = reader.read();
                String apiDetails = "";
                char current;

                while (data != -1) {
                    current = (char) data;
                    apiDetails += current;
                    data = reader.read();
                }

                return apiDetails;

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void getWeatherInfo(View view) {
        WeatherInfo weatherInfo = new WeatherInfo();
        EditText sehir = (EditText) findViewById(R.id.sehireditText);

        TextView weatherTextView = (TextView) findViewById(R.id.weatherTextView);

        try {

            if (sehir.getText().toString().isEmpty()) {
                Toast.makeText(this, "Sehir ismini giriniz.", Toast.LENGTH_SHORT).show();
                weatherTextView.setText("");
            } else {

            String weatherAPI = weatherInfo.execute("http://api.openweathermap.org/data/2.5/weather?q=" + sehir.getText().toString() + "&apikey=6ba2610243a8664fec8b20448358e78f").get();
            //Log.i("Weather API Info", weatherAPI);

            JSONObject jsonObject = new JSONObject(weatherAPI);
            String weather = jsonObject.getString("weather");
            Log.i("Weather Details", weather);

            JSONArray array = new JSONArray(weather);

            String main = "";
            String description = "";

            for (int i = 0; i < array.length(); i++) {
                JSONObject arrayObject = array.getJSONObject(i);
                main = arrayObject.getString("main");
                description = arrayObject.getString("description");
            }

            weatherTextView.setText("Main: " + main + "\n" + "Desc: " + description);

            //Log.i("Main", main);
            //Log.i("Description", description);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherInfo weatherInfo = new WeatherInfo();
        EditText sehir = (EditText) findViewById(R.id.sehireditText);

        try {

            String weatherAPI = weatherInfo.execute("https://samples.openweathermap.org/data/2.5/weather?q=" + sehir.getText().toString() + "&appid=6ba2610243a8664fec8b20448358e78f").get();
            Log.i("Weather API Info", weatherAPI);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
