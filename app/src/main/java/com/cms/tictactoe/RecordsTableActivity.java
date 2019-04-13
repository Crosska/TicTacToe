package com.cms.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class RecordsTableActivity extends AppCompatActivity {

    public int wins_count;
    public int loses_count;
    public String user_name;

    String CODE_USER_NAME = "h&3gt(*h%tr48";
    String CODE_WINS_COUNT = "8h@#f09g__08f";
    String CODE_LOSES_COUNT = "VrFQ}Ig}5Vn$M";

    TextView User;
    TextView Wins;
    TextView Loses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records_table);
        Bundle SavedData = getIntent().getExtras();
        if (SavedData != null) {
            wins_count = SavedData.getInt(CODE_WINS_COUNT, 0);
            loses_count = SavedData.getInt(CODE_LOSES_COUNT, 0);
            user_name = SavedData.getString(CODE_USER_NAME, "Default");
        }
        User = findViewById(R.id.user_textview);
        Wins = findViewById(R.id.wins_textview);
        Loses = findViewById(R.id.loses_textview);
        setData();
    }

    private void setData() {
        String temp_wins = String.valueOf(wins_count);
        String temp_loses = String.valueOf(loses_count);
        User.setText(user_name);
        Wins.setText(temp_wins);
        Loses.setText(temp_loses);
    }

    public void back_button_pressed(View view) {
        finish();
    }

    public void onBackPressed() {
        finish();
    }
}
