package com.cms.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class PrivateCabinetActivity extends AppCompatActivity {

    TextView username;
    TextView password;
    TextView player_stage;
    EditText new_login;
    EditText new_password;

    String login_data;
    String password_data;
    int wins_count;
    int loses_count;
    boolean recent;

    String CODE_WINS_COUNT = "wins";
    String CODE_LOSES_COUNT = "loses";
    String CODE_LOGIN = "login";
    String CODE_PASSWORD = "password";
    String CODE_RECENT = "recent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_private_cabinet);
        Bundle SavedData = getIntent().getExtras();
        if (SavedData != null) {
            login_data = SavedData.getString(CODE_LOGIN);
            password_data = SavedData.getString(CODE_PASSWORD);
            wins_count = SavedData.getInt(CODE_WINS_COUNT);
            loses_count = SavedData.getInt(CODE_LOSES_COUNT);
            recent = SavedData.getBoolean(CODE_RECENT, false);
        }
        setElements();
        setData();
    }

    private void setData() {
        username.setText(login_data);
        password.setText(password_data);
        int player_skill = wins_count - loses_count;
        if (player_skill < -30) {
            player_stage.setText("Отвратительный");
        } else if (player_skill >= -30 && player_skill < -20) {
            player_stage.setText("Ужасный");
        } else if (player_skill >= -20 && player_skill < -10) {
            player_stage.setText("Очень плохой");
        } else if (player_skill >= -10 && player_skill < 0) {
            player_stage.setText("Плохой");
        } else if (player_skill >= 0 && player_skill < 10) {
            player_stage.setText("Хороший");
        } else if (player_skill >= 10 && player_skill < 20) {
            player_stage.setText("Очень хороший");
        } else if (player_skill >= 20 && player_skill < 30) {
            player_stage.setText("Прекрасный");
        } else if (player_skill >= 30) {
            player_stage.setText("Богоподобный");
        }
    }

    private void setElements() {
        username = findViewById(R.id.login_textview);
        password = findViewById(R.id.password_textview);
        player_stage = findViewById(R.id.player_textview);
        new_login = findViewById(R.id.new_login_edittext);
        new_password = findViewById(R.id.new_password_edittext);
    }

    private void fillLoginNewFile(String login_new_data, String[] Lines) {
        FileOutputStream FileOutput = null;
        try {
            FileOutput = openFileOutput(login_new_data + ".txt", MODE_PRIVATE);
            FileOutput.write(Lines[0].getBytes());
            FileOutput.write("\n".getBytes());
            FileOutput.write(Lines[1].getBytes());
            FileOutput.write("\n".getBytes());
            FileOutput.write(Lines[2].getBytes());
        } catch (IOException ex) {
            Toast.makeText(this, "Ошибка создания", Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (FileOutput != null) FileOutput.close();
            } catch (IOException ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void deleteOldFile(String file_path) {
        File file = new File(file_path);
        file.delete();
    }

    private void refreshRecent() {
        FileOutputStream FileOutput = null;
        try {
            FileOutput = openFileOutput("RecentAccounts.txt", MODE_PRIVATE);
            FileOutput.write(login_data.getBytes());
            FileOutput.write("\n".getBytes());
            FileOutput.write(password_data.getBytes());
        } catch (IOException ex) {
            Toast.makeText(this, "Недавний аккаунт не сохранен!!!", Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (FileOutput != null) FileOutput.close();
            } catch (IOException ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void change_login_button_pressed(View view) {
        String login_new_data = new_login.getText().toString();
        if (!login_new_data.equals("") && login_new_data.length() <= 10 && !login_new_data.equals(" ")) {
            Context c = getApplicationContext();
            String pre_path = c.getFilesDir().getPath();
            String file_path = pre_path + "/" + login_data + ".txt";
            String[] Lines = new String[3];
            String temp_line;
            try {
                File file = new File(file_path);
                FileReader FileInput = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(FileInput);
                byte i = 0;
                while ((temp_line = bufferedReader.readLine()) != null) {
                    Lines[i] = temp_line;
                    i++;
                }
                bufferedReader.close();
            } catch (Exception e) {
                Toast.makeText(this, "Ошибка", Toast.LENGTH_SHORT).show();
            }
            deleteOldFile(file_path); // Удаляем старый файл
            fillLoginNewFile(login_new_data, Lines); // Создаем новый файл и заполняем старыми данными
            login_data = login_new_data;
            setData();
            refreshRecent();
        } else {
            Toast.makeText(this, "Ошибка! Введите корректный логин (Макс. 10 символов)!", Toast.LENGTH_LONG).show();
        }
    }

    public void change_password_button_pressed(View view) {
        String password_new_data = new_password.getText().toString();
        if (!password_new_data.equals("") && password_new_data.length() <= 10 && !password_new_data.equals(" ")) {
            Context c = getApplicationContext();
            String pre_path = c.getFilesDir().getPath();
            String file_path = pre_path + "/" + login_data + ".txt";
            String[] Lines = new String[3];
            String temp_line;
            try {
                File file = new File(file_path);
                FileReader FileInput = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(FileInput);
                byte i = 0;
                while ((temp_line = bufferedReader.readLine()) != null) {
                    Lines[i] = temp_line;
                    i++;
                }
                bufferedReader.close();
            } catch (Exception e) {
                Toast.makeText(this, "Ошибка", Toast.LENGTH_SHORT).show();
            }
            deleteOldFile(file_path); // Удаляем старый файл
            Lines[0] = password_new_data;
            fillPasswordNewFile(Lines); // Создаем новый файл и заполняем старыми данными
            password_data = password_new_data;
            setData();
            refreshRecent();
        } else {
            Toast.makeText(this, "Ошибка! Введите корректный пароль(Макс. 10 символов)!", Toast.LENGTH_LONG).show();
        }
    }

    private void fillPasswordNewFile(String[] Lines) {
        FileOutputStream FileOutput = null;
        try {
            FileOutput = openFileOutput(login_data + ".txt", MODE_PRIVATE);
            FileOutput.write(Lines[0].getBytes());
            FileOutput.write("\n".getBytes());
            FileOutput.write(Lines[1].getBytes());
            FileOutput.write("\n".getBytes());
            FileOutput.write(Lines[2].getBytes());
        } catch (IOException ex) {
            Toast.makeText(this, "Ошибка создания", Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (FileOutput != null) FileOutput.close();
            } catch (IOException ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void logout_button_clicked(View view) {
        Context c = getApplicationContext();
        String pre_path = c.getFilesDir().getPath();
        pre_path += "/";
        File file = new File(pre_path, "RecentAccounts.txt");
        file.delete();
        finish();
    }

    public void onBackPressed() {
        if (recent) {
            Intent intent = new Intent(PrivateCabinetActivity.this, SettingsActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else {
            finish();
        }
    }

    public void back_button_pressed(View view) {
        if (recent) {
            Intent intent = new Intent(PrivateCabinetActivity.this, SettingsActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else {
            finish();
        }
    }
}
