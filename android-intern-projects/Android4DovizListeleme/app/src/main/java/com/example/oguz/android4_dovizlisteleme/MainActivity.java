package com.example.oguz.android4_dovizlisteleme;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import static android.R.layout.simple_list_item_1;

public class MainActivity extends AppCompatActivity {
    //heryerden erişebilmek için en yukarıda tanımladık
    ListView listCurrency;
    String[] currList;
    Doviz[] currArray = new Doviz[68];
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listCurrency = (ListView) findViewById(R.id.listCurrency);
        //class çağırılıyor
        JsonParsing jsonParsing = new JsonParsing();

        jsonParsing.execute();
        //listView'a tıklandığında çalışacak method
        listCurrency.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent myIntent = new Intent(MainActivity.this, CurrencyInfo.class);
                myIntent.putExtra("code", currArray[position].code);
                myIntent.putExtra("buying", currArray[position].buying);
                myIntent.putExtra("change_rate", currArray[position].change_rate);
                myIntent.putExtra("curr", currArray[position].curr);
                myIntent.putExtra("selling", currArray[position].selling);
                myIntent.putExtra("full_name", currArray[position].fullName);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }

    //androidde json ile veri çekebilmek için en iyi yöntem AsyncTask
    protected class JsonParsing extends AsyncTask<Void,Void,Void>{
        String result = "";
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                //URL olarak api adresi verilir
                URL doviz_url = new URL("https://www.doviz.com/api/v1/currencies/all/latest");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(doviz_url.openStream()));
                String line = "";
                //her bir satır teker teker kaydedilir
                while((line=bufferedReader.readLine()) != null){
                    result += line;
                }
                bufferedReader.close();

                JSONArray jsonArray = new JSONArray(result);
                currList = new String[jsonArray.length()];
                //arrayde ki parametreler ayrıştırılır
                for (int i=0 ; i<jsonArray.length(); i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Doviz doviz = new Doviz();
                    doviz.buying = jsonObject.getDouble("buying");
                    doviz.selling = jsonObject.getDouble("selling");
                    doviz.change_rate = jsonObject.getDouble("change_rate");
                    doviz.curr = jsonObject.getInt("currency");
                    doviz.name = jsonObject.getString("name");
                    doviz.fullName = jsonObject.getString("full_name");
                    doviz.code = jsonObject.getString("code");
                    currArray[i]=doviz;
                }
                //listviewda gösterilecek veriler ayarlanır
                for (int i=0; i<jsonArray.length(); i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    currList[i]=jsonObject.getString("full_name");
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            //bütün işlemler bittikten sonra listview'a aktarılır
            ArrayAdapter adapter = new ArrayAdapter<>(getBaseContext(), simple_list_item_1, currList);
            listCurrency.setAdapter(adapter);
        }
    }



}