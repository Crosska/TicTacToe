package com.cms.tictactoe;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class RecordsTableActivity extends AppCompatActivity {

    int wins_count;
    int loses_count;
    boolean recent;
    String user_name;

    String CODE_USER_NAME = "user";
    String CODE_WINS_COUNT = "wins";
    String CODE_LOSES_COUNT = "loses";
    String CODE_RECENT = "recent";

    TextView User;
    TextView Wins;
    TextView Loses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_records_table);
        Bundle SavedData = getIntent().getExtras();
        if (SavedData != null) {
            wins_count = SavedData.getInt(CODE_WINS_COUNT, 0);
            loses_count = SavedData.getInt(CODE_LOSES_COUNT, 0);
            user_name = SavedData.getString(CODE_USER_NAME, "Default");
            recent = SavedData.getBoolean(CODE_RECENT, false);
        }
        setUpElements();
        setData();
    }

    private void setUpElements() {
        User = findViewById(R.id.user_textview);
        Wins = findViewById(R.id.wins_textview);
        Loses = findViewById(R.id.loses_textview);
    }

    private void setData() {
        String temp_wins = String.valueOf(wins_count);
        String temp_loses = String.valueOf(loses_count);
        User.setText(user_name);
        Wins.setText(temp_wins);
        Loses.setText(temp_loses);
    }

    public void back_button_pressed(View view) {
        if (recent) {
            Intent intent = new Intent(RecordsTableActivity.this, SettingsActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        if (recent) {
            Intent intent = new Intent(RecordsTableActivity.this, SettingsActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else {
            finish();
        }
    }
}
