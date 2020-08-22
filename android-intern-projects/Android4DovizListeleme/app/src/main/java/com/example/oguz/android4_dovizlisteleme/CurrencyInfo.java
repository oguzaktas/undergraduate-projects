package com.example.oguz.android4_dovizlisteleme;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CurrencyInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_info);
        //ekranda ki textViewları tanımladık
        TextView txt_currency_name = (TextView) findViewById(R.id.txtCurrencyName);
        TextView txt_buying = (TextView) findViewById(R.id.txtBuying);
        TextView txt_curr_code = (TextView) findViewById(R.id.txtCurrCode);
        TextView txt_curr_rate = (TextView) findViewById(R.id.txtCurrRate);
        TextView txt_selling = (TextView) findViewById(R.id.txtSelling);

        //yaşayan intentler çekiliyor.
        Intent intent = getIntent();
        txt_currency_name.setText(intent.getStringExtra("full_name"));
        /**burada sonda yazdığımız değer, eğer herhangi bir veri gelmezse default olarak
         * ne çekeceğini gösteriyor.
         */
        txt_buying.setText(Double.toString(intent.getDoubleExtra("buying",0.00)));
        txt_selling.setText(Double.toString(intent.getDoubleExtra("selling",0.00)));
        if (intent.getDoubleExtra("change_rate",0.00)<0)
            txt_curr_rate.setTextColor(getResources().getColor(R.color.colorRed));
        else
            txt_curr_rate.setTextColor(getResources().getColor(R.color.colorGreen));

        txt_curr_rate.setText(Double.toString(intent.getDoubleExtra("change_rate",0.00)));
        txt_curr_code.setText(intent.getStringExtra("code"));
    }
}