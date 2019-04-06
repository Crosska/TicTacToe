package com.cms.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    public void cell_0_0_pressed(View view) {
    }

    public void cell_0_1_pressed(View view) {
    }

    public void cell_0_2_pressed(View view) {
    }

    public void cell_1_0_pressed(View view) {
    }

    public void cell_1_1_pressed(View view) {
    }

    public void cell_1_2_pressed(View view) {
    }

    public void cell_2_0_pressed(View view) {
    }

    public void cell_2_1_pressed(View view) {
    }

    public void cell_2_2_pressed(View view) {
    }

    public void white_flag_pressed(View view) {
        Toast.makeText(this, "Вы проиграли!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
