/**
 *
 * @author also paz
 * credit screen.
 *
 */

package com.example.lesson18;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class creditscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditscreen);
    }

    /**
     * closes credit screen and goes back
     * @param view
     */
    public void back_back(View view) {
        finish();
    }
}