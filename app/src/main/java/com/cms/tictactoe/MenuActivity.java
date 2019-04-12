package com.cms.tictactoe;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    TextView LoginTextView;

    public boolean LoginEnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        LoginTextView = findViewById(R.id.login_textview);
        if (LoginEnable) LoginTextView.setText("Вы зашли под своим пользователем.");
        setContentView(R.layout.activity_menu);
    }

    public void start_button_pressed(View view) {
        Intent intent = new Intent(MenuActivity.this, PreGameActivity.class);
        startActivity(intent);
    }

    public void settings_button_pressed(View view) {
        Intent intent = new Intent(MenuActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    public void exit_button_pressed(View view) {
        finish();
    }


}
