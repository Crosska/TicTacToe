package com.cms.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MenuActivity extends AppCompatActivity {

    Button Start_button;
    Button Settings_button;
    Button Exit_button;
    TextView LoginTextView;
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_menu);
        ((MyApplication) this.getApplication()).setLanguageRus(true); // Включение исходного языка - русского

        try {
            readText();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mPlayer = MediaPlayer.create(this, R.raw.music);
        LoginTextView = findViewById(R.id.login_textview);
        Start_button = findViewById(R.id.button_start);
        Settings_button = findViewById(R.id.button_settings);
        Exit_button = findViewById(R.id.button_exit);
        Context c = getApplicationContext();
        String pre_path = c.getFilesDir().getPath();
        String file_path = pre_path + "/RecentAccounts.txt";
        String[] Lines = new String[2];
        String temp_line;
        //mPlayer.start();
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
        setText();
    }

    private void setText() {
        String temp = ((MyApplication) this.getApplication()).getTextLine(0);
        Start_button.setText(temp);
        temp = ((MyApplication) this.getApplication()).getTextLine(1);
        Settings_button.setText(temp);
        temp = ((MyApplication) this.getApplication()).getTextLine(2);
        Exit_button.setText(temp);
    }

    private void readText() throws IOException {
        BufferedInputStream bf = new BufferedInputStream(getResources().openRawResource(R.raw.russian));
        Scanner s = new Scanner(bf).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";
        //
        Context c = getApplicationContext();
        String pre_path = c.getFilesDir().getPath();
        String file_path = pre_path + "/Russian.txt";
        //
        try (FileWriter writer = new FileWriter(file_path)) {
            writer.write(result);
            writer.flush();
        } catch (IOException ex) {
            //
        }
        //
        String[] tempText = new String[75];
        String temp_line;
        File file = new File(file_path);
        //
        FileReader FileInput;
        try {
            FileInput = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(FileInput);
            int i = 0;
            while ((temp_line = bufferedReader.readLine()) != null) {
                tempText[i] = temp_line;
                i++;
            }
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ((MyApplication) this.getApplication()).setText(tempText);
            ((MyApplication) this.getApplication()).setLanguageRus(true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
            String temp = ((MyApplication) this.getApplication()).getTextLine(72);
            temp += " ";
            temp += Lines[0];
            LoginTextView.setText(temp);
        } catch (Exception e) {
            LoginTextView.setText("");
            //Toast.makeText(this, "Не получилось открыть RecentFiles.txt", Toast.LENGTH_LONG).show();
        }
        setText();
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


