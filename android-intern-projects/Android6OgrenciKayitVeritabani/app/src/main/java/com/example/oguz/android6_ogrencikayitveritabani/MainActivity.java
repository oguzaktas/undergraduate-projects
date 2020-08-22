package com.example.oguz.android6_ogrencikayitveritabani;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;
    Button kaydet;
    Button listele;
    SQLiteDatabase db;

    public MainActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editText = (EditText) findViewById(R.id.editText);
        this.editText2 = (EditText) findViewById(R.id.editText2);
        this.kaydet = (Button) findViewById(R.id.button);
        this.listele = (Button) findViewById(R.id.button2);

        this.db = this.openOrCreateDatabase("OgrenciDB", 0, (SQLiteDatabase.CursorFactory) null);
        this.db.execSQL("CREATE TABLE IF NOT EXISTS ogrenci(id INTEGER PRIMARY KEY AUTOINCREMENT, isim VARCHAR, mail VARCHAR);");

        Cursor c;
        this.kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().trim().length() == 0 || editText2.getText().toString().trim().length() == 0) {
                    showMessage("Hata", "Tum degerleri doldurmaniz gerekmektedir.");
                    return;
                }

                db.execSQL("INSERT INTO ogrenci VALUES(null, \'" + editText.getText() + "\',\'" + editText2.getText() + "\');");
                showMessage("Basarili", "Ogrenci eklendi.");
                clearText();
            }
        });

        this.listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = db.rawQuery("SELECT * FROM ogrenci", (String[]) null);
                if (c.getCount() == 0) {
                    showMessage("Hata", "Kayitli ogrenci yoktur.");
                    return;
                }

                StringBuffer buffer = new StringBuffer();

                while (c.moveToNext()) {
                    buffer.append("Ad soyad: " + c.getString(1) + "\n");
                    buffer.append("Mail: " + c.getString(2) + "\n\n");
                }

                showMessage("Ogrencilerin detayli listesi", buffer.toString());
            }
        });
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void clearText() {
        this.editText.setText("");
        this.editText2.setText("");
        this.editText.requestFocus();
    }

}
