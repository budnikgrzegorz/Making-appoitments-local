package com.example.lenovo.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Logowanie extends AppCompatActivity {

    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    public Cursor cursor;
    public Cursor cursor1;
    Button zaloguj;
    EditText log, haslo;
    public static EditText logi;
    public static String lname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logowanie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        log = (EditText) findViewById(R.id.login);
        logi = (EditText) findViewById(R.id.login);


        haslo = (EditText) findViewById(R.id.haslo);
        zaloguj = (Button) findViewById(R.id.btnzaloguj);
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
    }

    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.rejestracja:

                intent = new Intent(Logowanie.this, Rejestracja.class);
                startActivity(intent);
                break;
            case R.id.btnzaloguj:
                logowanie();
//                pobierzDane();
//usuniecieRekordu();
                break;
        }
    }


    public void logowanie() {
        String login = log.getText().toString();
        String pass = haslo.getText().toString();
        cursor1 = db.rawQuery(" SELECT " + DatabaseHelper.COL_2 +" FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_6 + "=? AND " + DatabaseHelper.COL_7 + "=?", new String[]{login, pass});

//       lname = cursor1.getString(3);
        cursor = db.rawQuery("SELECT *FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_6 + "=? AND " + DatabaseHelper.COL_7 + "=?", new String[]{login, pass});
//        cursor1 = db.rawQuery(" SELECT " + DatabaseHelper.COL_1 + " FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_6 + "=? AND " + DatabaseHelper.COL_7 + "=?", new String[]{login, pass});
        if (cursor != null) {
            if (cursor.getCount() > 0) {


                Toast.makeText(getApplicationContext(), "Dziękujemy za zalogowanie", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(Logowanie.this, Uzytkownk.class);
                startActivity(intent);


            } else {
                Toast.makeText(getApplicationContext(), "Błędny login lub hasło", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void pobierzDane() {
        cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME, null);
        if (cursor.getCount() > 0) {
            StringBuffer buffer = new StringBuffer();
            while (cursor.moveToNext()) {
                buffer.append("ID: " + cursor.getString(0) + "\n");
                buffer.append("Imię: " + cursor.getString(1) + "\n");
                buffer.append("Nazwisko: " + cursor.getString(2) + "\n");
                buffer.append("Adres: " + cursor.getString(3) + "\n");
                buffer.append("Kod pocztowy i Miasto: " + cursor.getString(4) + "\n");
                buffer.append("Login: " + cursor.getString(5) + "\n");
                buffer.append("Hasło: " + cursor.getString(6) + "\n");
                buffer.append("Email: " + cursor.getString(7) + "\n");
                buffer.append("Telefon: " + cursor.getString(8) + "\n");
                pokazWiadomosc("rekord", buffer.toString());
            }
        } else {
            pokazWiadomosc("Brak", "Niestety brak");
        }
    }

    public void pokazWiadomosc(String title, String wiadomosc) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setMessage(wiadomosc);
        builder.setTitle(title);
        builder.show();
    }

    public void usuniecieRekordu() {
        db.delete(DatabaseHelper.TABLE_NAME, "id= ?", new String[]{"3"});
    }
//
//    public void przekarzDane() {
//        cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME, String[][login]);
//        if (cursor.getCount() > 0) {
//            StringBuffer buffer = new StringBuffer();
//            while (cursor.moveToNext()) {
//           buffer.append("ID: " + cursor.getString(0) + "\n");
//                buffer.append("Imię: " + cursor.getString(1) + "\n");
//                buffer.append("Nazwisko: " + cursor.getString(2) + "\n");
//                buffer.append("Adres: " + cursor.getString(3) + "\n");
//                buffer.append("Kod pocztowy i Miasto: " + cursor.getString(4) + "\n");
//                buffer.append("Login: " + cursor.getString(5) + "\n");
//                buffer.append("Hasło: " + cursor.getString(6) + "\n");
//                buffer.append("Email: " + cursor.getString(7) + "\n");
//                buffer.append("Telefon: " + cursor.getString(8) + "\n");
//                pokazWiadomosc("rekord", buffer.toString());
//            }
//        } else {
//            pokazWiadomosc("Brak", "Niestety brak");
//        }
//    }

}