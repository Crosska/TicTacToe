package com.cms.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SettingsActivity extends AppCompatActivity {

    ToggleButton sound_switch;
    Button color_button;
    Button language_button;
    Button score_table_button;
    Button private_cabinet_button;
    Button back_button;
    TextView settings_textview;
    TextView color_textview;
    TextView language_textview;
    TextView score_table_textview;
    TextView private_cabinet_textview;
    TextView sound_textview;

    boolean Sound = true;
    boolean LoginEnable;
    int ChosenWay;

    String CODE_CHOSEN_WAY = "fd(73fhH64!@_";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_settings);
        setUpElements();
        setText();
        sound_switch.setChecked(true);
    }

    private void setUpElements() {
        sound_switch = findViewById(R.id.switch_sound);
        color_button = findViewById(R.id.color_button);
        language_button = findViewById(R.id.language_button);
        score_table_button = findViewById(R.id.score_button);
        private_cabinet_button = findViewById(R.id.cabinet_button);
        back_button = findViewById(R.id.back_button);
        settings_textview = findViewById(R.id.settings_textview);
        color_textview = findViewById(R.id.color_textview);
        language_textview = findViewById(R.id.language_textview);
        score_table_textview = findViewById(R.id.score_textview);
        private_cabinet_textview = findViewById(R.id.cabinet_textview);
        sound_textview = findViewById(R.id.sound_textview);
    }

    private void setText() {
        String temp = ((MyApplication) this.getApplication()).getTextLine(1);
        settings_textview.setText(temp);
        temp = ((MyApplication) this.getApplication()).getTextLine(3);
        color_textview.setText(temp);
        temp = ((MyApplication) this.getApplication()).getTextLine(4);
        language_textview.setText(temp);
        temp = ((MyApplication) this.getApplication()).getTextLine(5);
        score_table_textview.setText(temp);
        temp = ((MyApplication) this.getApplication()).getTextLine(6);
        private_cabinet_textview.setText(temp);
        temp = ((MyApplication) this.getApplication()).getTextLine(7);
        sound_textview.setText(temp);
        temp = ((MyApplication) this.getApplication()).getTextLine(8);
        color_button.setText(temp);
        temp = ((MyApplication) this.getApplication()).getTextLine(8);
        language_button.setText(temp);
        temp = ((MyApplication) this.getApplication()).getTextLine(9);
        score_table_button.setText(temp);
        temp = ((MyApplication) this.getApplication()).getTextLine(10);
        private_cabinet_button.setText(temp);
        temp = ((MyApplication) this.getApplication()).getTextLine(11);
        sound_switch.setTextOff(temp);
        temp = ((MyApplication) this.getApplication()).getTextLine(12);
        sound_switch.setTextOn(temp);
        temp = ((MyApplication) this.getApplication()).getTextLine(13);
        back_button.setText(temp);
        if (Sound) sound_switch.setChecked(true);
        else sound_switch.setChecked(false);
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

    public void language_button_clicked(View view) throws IOException {
        boolean languageRus = ((MyApplication) this.getApplication()).isLanguageRus();
        if (languageRus) {
            BufferedInputStream bf = new BufferedInputStream(getResources().openRawResource(R.raw.english));
            Scanner s = new Scanner(bf).useDelimiter("\\A");
            String result = s.hasNext() ? s.next() : "";
            //
            Context c = getApplicationContext();
            String pre_path = c.getFilesDir().getPath();
            String file_path = pre_path + "/English.txt";
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
                byte i = 0;
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
                ((MyApplication) this.getApplication()).setLanguageRus(false);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
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
                byte i = 0;
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
        setText();
    }

    @Override
    public void onResume() {
        super.onResume();
        setText();
    }
}
