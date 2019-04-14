package com.cms.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MenuActivity extends AppCompatActivity {

    TextView LoginTextView;
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_menu);
        mPlayer = MediaPlayer.create(this, R.raw.music);
        LoginTextView = findViewById(R.id.login_textview);
        Context c = getApplicationContext();
        String pre_path = c.getFilesDir().getPath();
        String file_path = pre_path + "/RecentAccounts.txt";
        String[] Lines = new String[2];
        String temp_line;
        mPlayer.start();
        try {
            File file = new File(file_path);
            FileReader FileInput = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(FileInput);
            int i = 0;
            while ((temp_line = bufferedReader.readLine()) != null) {
                Lines[i] = temp_line;
                i++;
            }
            bufferedReader.close();
            String temp = "Текущий аккаунт: " + Lines[0];
            LoginTextView.setText(temp);
        } catch (Exception e) {
            //Toast.makeText(this, "Не получилось открыть RecentFiles.txt", Toast.LENGTH_LONG).show();
        }
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

    @Override
    public void onResume() {
        super.onResume();
        Context c = getApplicationContext();
        String pre_path = c.getFilesDir().getPath();
        String file_path = pre_path + "/RecentAccounts.txt";
        String[] Lines = new String[3];
        String temp_line;
        try {
            File file = new File(file_path);
            FileReader FileInput = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(FileInput);
            int i = 0;
            while ((temp_line = bufferedReader.readLine()) != null) {
                Lines[i] = temp_line;
                i++;
            }
            bufferedReader.close();
            String temp = "Текущий аккаунт: " + Lines[0];
            LoginTextView.setText(temp);
        } catch (Exception e) {
            LoginTextView.setText("");
            //Toast.makeText(this, "Не получилось открыть RecentFiles.txt", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPlayer.isPlaying()) {
            stopPlay();
        }
    }

    private void stopPlay() {
        mPlayer.stop();
    }

}


