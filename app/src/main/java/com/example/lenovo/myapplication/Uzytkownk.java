package com.example.lenovo.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Uzytkownk extends AppCompatActivity {

    private static String firstname;
    private static String surname;
    public Cursor cursor;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uzytkownk);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(pokazTytul());
    }



    private String pokazTytul() {
        String a = null;
        cursor = db.rawQuery(" SELECT*" + " FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper.COL_6 + "=?", new String[]{Logowanie.logi.getText().toString()});
        if (cursor.getCount() > 0) {
            StringBuffer buffer = new StringBuffer();
            while (cursor.moveToNext()) {
                a = cursor.getString(1);
                a = "Witaj" + ' ' +  a + ' ' + cursor.getString(2);
            }
        }
        return a;
    }
}