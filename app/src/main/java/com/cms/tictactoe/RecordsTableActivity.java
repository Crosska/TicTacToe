package com.cms.tictactoe;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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

    TextView Header;
    TextView Wins_header;
    TextView Loses_header;
    TextView User;
    TextView Wins;
    TextView Loses;
    TextView Player;
    Button Back;

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
        setText();
        setData();
    }

    private void setText() {
        String temp = ((MyApplication) this.getApplication()).getTextLine(51);
        Header.setText(temp);
        temp = ((MyApplication) this.getApplication()).getTextLine(52);
        Wins_header.setText(temp);
        temp = ((MyApplication) this.getApplication()).getTextLine(53);
        Loses_header.setText(temp);
        temp = ((MyApplication) this.getApplication()).getTextLine(13);
        Back.setText(temp);
        temp = ((MyApplication) this.getApplication()).getTextLine(54);
        Player.setText(temp);
    }

    private void setUpElements() {
        User = findViewById(R.id.user_textview);
        Wins = findViewById(R.id.wins_textview);
        Loses = findViewById(R.id.loses_textview);
        Header = findViewById(R.id.header_textview);
        Wins_header = findViewById(R.id.wins_header_textview);
        Loses_header = findViewById(R.id.loses_header_textview);
        Back = findViewById(R.id.back_button);
        Player = findViewById(R.id.player_textview);
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
