package com.example.lenovo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.beginning) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void click(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.oMnie:
                intent = new Intent(MainActivity.this, AboutMe.class);
                startActivity(intent);
                break;
            case R.id.cennik:
                intent = new Intent(MainActivity.this, Cennik.class);
                startActivity(intent);
                break;
            case R.id.kontakt:
                intent = new Intent(MainActivity.this, Kontakt.class);
                startActivity(intent);
                break;
            case R.id.umowWizyte:
                intent = new Intent(MainActivity.this, Logowanie.class);
                startActivity(intent);
                break;

        }

    }


}
