package com.cms.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void start_button_pressed(View view) {
    }

    public void settings_button_pressed(View view) {
    }

    public void exit_button_pressed(View view) {
        finish();
    }
}
