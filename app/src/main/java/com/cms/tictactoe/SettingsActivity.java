package com.cms.tictactoe;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ToggleButton;

public class SettingsActivity extends AppCompatActivity {

    ToggleButton sound_switch;

    boolean Sound = true;
    boolean LoginEnable;
    int ChosenWay;

    String CODE_CHOSEN_WAY = "fd(73fhH64!@_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_settings);
        sound_switch = findViewById(R.id.switch_sound);
        sound_switch.setChecked(true);
    }

    public void color_button_pressed(View view) {
    }

    public void back_button_pressed(View view) {
        finish();
    }

    public void sound_button_clicked(View view) {
        if (Sound) Sound = false;
        else Sound = true;
    }

    public void cabinet_button_clicked(View view) {
        if (!LoginEnable) {
            ChosenWay = 1;
            Intent intent = new Intent(SettingsActivity.this, LoginPassActivity.class);
            intent.putExtra(CODE_CHOSEN_WAY, ChosenWay);
            startActivity(intent);
        } else {
            Intent intent = new Intent(SettingsActivity.this, PrivateCabinetActivity.class);
            startActivity(intent);
        }
    }

    public void score_button_clicked(View view) {
        if (!LoginEnable) {
            ChosenWay = 0;
            Intent intent = new Intent(SettingsActivity.this, LoginPassActivity.class);
            intent.putExtra(CODE_CHOSEN_WAY, ChosenWay);
            startActivity(intent);
        } else {
            Intent intent = new Intent(SettingsActivity.this, RecordsTableActivity.class);
            startActivity(intent);
        }
    }

    public void language_button_clicked(View view) {
    }
}
