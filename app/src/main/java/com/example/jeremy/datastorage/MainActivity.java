package com.example.jeremy.datastorage;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import static android.app.PendingIntent.getActivity;


public class MainActivity extends Activity {
    Integer i  = 0;
    EditText count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = (EditText) findViewById(R.id.editText);
        count.setKeyListener(null);
        //Context context = getPreferences();
        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        i = sharedPref.getInt("Count", 0);
        count.setText(i.toString());
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void handleAdvanceClick(View view) {
        i++;
        count.setText(i.toString());
    }

    public void handleSaveContentClick(View view) {
        //count.setText(i.toString());
//        SharedPreferences sharedPref = getPreferences(MODE_PRIVATE);
//        SharedPreferences sharedPref = getPreferences(MODE_PRIVATE);
        SharedPreferences sharedPref = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPref.edit();
        edit.putInt("Count", i);
        edit.commit();



    }

}
