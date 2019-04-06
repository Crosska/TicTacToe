package com.cms.tictactoe;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PreGameActivity extends AppCompatActivity {

    RadioButton computer_radio;
    RadioButton human_radio;
    RadioButton easy_radio;
    RadioButton normal_radio;
    RadioButton hard_radio;
    RadioButton grid3x3_radio;
    RadioButton grid4x4_radio;
    RadioGroup difficulty_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_pre_game);
        computer_radio = findViewById(R.id.computer_radio_button);
        human_radio = findViewById(R.id.human_radio_button);
        easy_radio = findViewById(R.id.easy_radio_button);
        normal_radio = findViewById(R.id.normal_radio_button);
        hard_radio = findViewById(R.id.hard_radio_button);
        grid3x3_radio = findViewById(R.id.cell3x3_radio_button);
        grid4x4_radio = findViewById(R.id.cell4x4_radio_button);
        difficulty_group = findViewById(R.id.difficulty_radio_group);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            computer_radio.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
            human_radio.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
            easy_radio.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
            normal_radio.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
            hard_radio.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
            grid3x3_radio.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
            grid4x4_radio.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
        }
        computer_radio.setChecked(true);
        easy_radio.setChecked(true);
        grid3x3_radio.setChecked(true);
    }

    public void back_button_pressed(View view) {
        finish();
    }

    public void start_button_pressed(View view) {
        Intent intent = new Intent(PreGameActivity.this, GameActivity.class);
        startActivity(intent);
    }

    public void computer_radio_clicked(View view) {
        easy_radio.setEnabled(true);
        normal_radio.setEnabled(true);
        hard_radio.setEnabled(true);
    }

    public void human_radio_clicked(View view) {
        easy_radio.setEnabled(false);
        normal_radio.setEnabled(false);
        hard_radio.setEnabled(false);
    }

    public void easy_radio_clicked(View view) {
    }

    public void normal_radio_clicked(View view) {
    }

    public void hard_radio_clicked(View view) {
    }

    public void cell3x3_radio_clicked(View view) {
    }

    public void cell4x4_radio_clicked(View view) {
    }
}
