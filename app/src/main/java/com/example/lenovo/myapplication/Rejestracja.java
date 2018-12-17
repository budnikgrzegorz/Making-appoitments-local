package com.example.lenovo.myapplication;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.myapplication.model.Person;

public class Rejestracja extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button btnreg;
    EditText _txtfname, _txtlname, _txtpassone, _txtpasstwo, _txtadress, _txtcode, _txtlogin, _txtemail, _txtphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejestracja);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        openHelper = new DatabaseHelper(this);
        _txtfname = (EditText) findViewById(R.id.txtfname);
        _txtlname = (EditText) findViewById(R.id.txtlname);
        _txtpassone = (EditText) findViewById(R.id.txtpassone);
        _txtpasstwo = (EditText) findViewById(R.id.txtpasstwo);
        _txtadress = (EditText) findViewById(R.id.txtadress);
        _txtcode = (EditText) findViewById(R.id.txtcode);
        _txtlogin = (EditText) findViewById(R.id.txtlogin);
        _txtemail = (EditText) findViewById(R.id.txtemail);
        _txtphone = (EditText) findViewById(R.id.txtphone);
        btnreg = (Button) findViewById(R.id.btnreg);


        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = openHelper.getWritableDatabase();
                String fname = _txtfname.getText().toString();
                String lname = _txtlname.getText().toString();
                String passone = _txtpassone.getText().toString();
                String passtwo = _txtpasstwo.getText().toString();
                String adress = _txtadress.getText().toString();
                String code = _txtcode.getText().toString();
                String login = _txtlogin.getText().toString();
                String email = _txtemail.getText().toString();
                String phone = _txtphone.getText().toString();
                insertdata(fname, lname, passone, passtwo, adress, code, login, email, phone);
                Toast.makeText(getApplicationContext(), "Dziękujemy za rejestracje", Toast.LENGTH_LONG).show();

            }
        });

    }

    //    Dodać sprawdzenie poprawności hasła
    private void insertdata(String fname, String lname, String login, String passone, String passtwo, String adress, String code, String email, String phone) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, fname);
        contentValues.put(DatabaseHelper.COL_3, lname);
        contentValues.put(DatabaseHelper.COL_4, adress);
        contentValues.put(DatabaseHelper.COL_5, code);
        contentValues.put(DatabaseHelper.COL_6, login);
        contentValues.put(DatabaseHelper.COL_7, passone);
        contentValues.put(DatabaseHelper.COL_8, email);
        contentValues.put(DatabaseHelper.COL_9, phone);
        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);

    }


}
