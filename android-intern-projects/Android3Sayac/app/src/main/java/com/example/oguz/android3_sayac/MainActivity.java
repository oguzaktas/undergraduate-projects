package com.example.oguz.android3_sayac;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int sayac;
    TextView sayacdegeri;
    Button arttir;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    AlertDialog.Builder builder;
    EditText inputyenideger;
    EditText inputdegeridegistir;

    LinearLayout AlertDialogLayout;
    LinearLayout.LayoutParams layoutParameters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        degerleriTanimla();
        degerleriYukle();
        setSayac();
        buttonHandler();
    }

    public void degerleriTanimla() {
        sayacdegeri = (TextView) findViewById(R.id.sayac_degeri);
        arttir = (Button) findViewById(R.id.arttir_butonu);
        sharedPreferences = getSharedPreferences("sayac", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        builder = new AlertDialog.Builder(this);
        inputyenideger = new EditText(this);
    }

    public void degerleriYukle() {
        sharedPreferences = getSharedPreferences("sayac", Context.MODE_PRIVATE);
    }

    public void setSayac() {
        sayac = sharedPreferences.getInt("sayac", 0);
    }

    public void buttonHandler() {
        arttir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sayac != 0) {
                    sayac = sharedPreferences.getInt("sayac", 0);
                    sayac += 1;
                    sayacdegeri.setText(Integer.toString(sayac));
                } else {
                    sayac += 1;
                    sayacdegeri.setText(Integer.toString(sayac));
                }
                committoSharedPreferences();
            }
        });
    }

    public void committoSharedPreferences() {
        editor.putInt("sayac", sayac);
        editor.commit();
    }

    public void createAlertDialog() {
        builder = new AlertDialog.Builder(this);
        AlertDialogLayout = new LinearLayout(this);
        layoutParameters = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        AlertDialogLayout.setOrientation(LinearLayout.VERTICAL);
        AlertDialogLayout.setLayoutParams(layoutParameters);

        AlertDialogLayout.setGravity(Gravity.CENTER);
        AlertDialogLayout.setPadding(2, 2, 2, 2);

        inputdegeridegistir = new EditText(this);
        inputdegeridegistir.setHint("örnek: 129");
        inputdegeridegistir.setInputType(InputType.TYPE_CLASS_DATETIME);

        AlertDialogLayout.addView(inputdegeridegistir, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        builder.setView(AlertDialogLayout);
        builder.setCancelable(true);

        builder.setNegativeButton("İptal et", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sayac = Integer.parseInt(inputdegeridegistir.getText().toString());
                sayacdegeri.setText(Integer.toString(sayac));
                committoSharedPreferences();
            }
        });

        builder.setIcon(R.drawable.ic_info_black_24dp);
        builder.setTitle("Dogru degeri giriniz.");

        AlertDialog alertDialog = builder.create();

        try {
            alertDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sayac_input, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.degeri_degistir:
                createAlertDialog();
        }
        return super.onOptionsItemSelected(item);
    }
}
