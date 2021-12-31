/**
 *
 * @author paz malul
 * the Brain of the operation:
 * this is the main screen of the app.
 *
 */

package com.example.lesson18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    TextView count_display;
    EditText nameInput;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count_display = (TextView) findViewById(R.id.count_display);
        nameInput = (EditText) findViewById(R.id.NameInput);

        SharedPreferences getPrevs=getSharedPreferences("Previous",MODE_PRIVATE);
        String name = getPrevs.getString("name","no name found :(");
        count = getPrevs.getInt("count", 0);

        nameInput.setText(name);
        count_display.setText("" + count);

    }

    /**
     * add 1 to count and updates text
     * @param view
     */

    public void add(View view) {
        count += 1;
        count_display.setText("" + count);
    }

    /**
     * resets count var and updates text
     * @param view
     */

    public void reset_count(View view) {
        count = 0;
        count_display.setText("0");
    }

    /**
     * exits app after saving count and name in file.
     * @param view
     */

    public void exit_app(View view) {
        SharedPreferences setPrevs=getSharedPreferences("Previous",MODE_PRIVATE);
        SharedPreferences.Editor editor=setPrevs.edit();
        editor.putString("name",     nameInput.getText().toString());
        editor.putInt("count",count);
        editor.commit();
        finish();
    }

    /**
     * option menu create
     * @param menu
     * @return
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * option menu item function
     * @param item
     * @return
     */

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.credits){
            Intent creds = new Intent(this,creditscreen.class);
            startActivity(creds);
        }

        return true;
    }
}