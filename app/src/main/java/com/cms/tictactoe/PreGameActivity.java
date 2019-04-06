package com.cms.tictactoe;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

public class PreGameActivity extends AppCompatActivity {

    RadioButton computer_radio;
    RadioButton human_radio;
    RadioButton easy_radio;
    RadioButton normal_radio;
    RadioButton hard_radio;
    RadioButton grid3x3_radio;
    RadioButton grid4x4_radio;
    RadioButton cross_radio;
    RadioButton oval_radio;

    String CODE_3X3_MARK = "h&3gt(*h%tr48";
    String CODE_4X4_MARK = "8h@#f09g__08f";
    String CODE_3X3_DIFFICULTY = "VrFQ}Ig}5Vn$M";
    String CODE_4X4_DIFFICULTY = "4FyGED3B8WgXe";
    String CODE_3X3_PLAYER_TYPE = "*M68m=bvBn6%5";
    String CODE_4X4_PLAYER_TYPE = "8{#e6c?~qL%?OK";

    public int computer_difficulty;
    public int grid_size;
    public int mark_type;
    public int player_type;

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
        cross_radio = findViewById(R.id.cross_radio_button);
        oval_radio = findViewById(R.id.oval_radio_button);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            computer_radio.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
            human_radio.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
            easy_radio.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
            normal_radio.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
            hard_radio.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
            grid3x3_radio.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
            grid4x4_radio.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
            cross_radio.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
            oval_radio.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
        }
        computer_radio.setChecked(true);
        easy_radio.setChecked(true);
        grid3x3_radio.setChecked(true);
        cross_radio.setChecked(true);
        mark_type = 2;
        computer_difficulty = 1;
        grid_size = 1;
        player_type = 1;
    }

    public void back_button_pressed(View view) {
        finish();
    }

    public void start_button_pressed(View view) {
        if (grid_size == 1) {
            Intent intent = new Intent(PreGameActivity.this, Game3x3Activity.class);
            intent.putExtra(CODE_3X3_MARK, mark_type);
            intent.putExtra(CODE_3X3_DIFFICULTY, computer_difficulty);
            intent.putExtra(CODE_3X3_PLAYER_TYPE, player_type);
            startActivity(intent);
        } else {
            Intent intent = new Intent(PreGameActivity.this, Game4x4Activity.class);
            intent.putExtra(CODE_4X4_MARK, mark_type);
            intent.putExtra(CODE_4X4_DIFFICULTY, computer_difficulty);
            intent.putExtra(CODE_4X4_PLAYER_TYPE, player_type);
            startActivity(intent);
        }
    }

    public void computer_radio_clicked(View view) {
        easy_radio.setEnabled(true);
        normal_radio.setEnabled(true);
        hard_radio.setEnabled(true);
        cross_radio.setEnabled(true);
        oval_radio.setEnabled(true);
        player_type = 1;
    }

    public void human_radio_clicked(View view) {
        easy_radio.setEnabled(false);
        normal_radio.setEnabled(false);
        hard_radio.setEnabled(false);
        cross_radio.setEnabled(false);
        oval_radio.setEnabled(false);
        player_type = 2;
        mark_type = 2;
    }

    public void easy_radio_clicked(View view) {
        computer_difficulty = 1;
    }

    public void normal_radio_clicked(View view) {
        computer_difficulty = 2;
    }

    public void hard_radio_clicked(View view) {
        computer_difficulty = 3;
    }

    public void cell3x3_radio_clicked(View view) {
        grid_size = 1;
    }

    public void cell4x4_radio_clicked(View view) {
        grid_size = 2;
    }

    public void cross_radio_clicked(View view) {
        mark_type = 2;
    }

    public void oval_radio_clicked(View view) {
        mark_type = 1;
    }
}
