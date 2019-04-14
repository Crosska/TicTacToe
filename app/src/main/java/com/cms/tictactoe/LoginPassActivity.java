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

public class LoginPassActivity extends AppCompatActivity {
    int ChosenWay;

    EditText username;
    EditText password;
    TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_login_pass);
        Bundle SavedData = getIntent().getExtras();
        if (SavedData != null) {
            ChosenWay = SavedData.getInt("fd(73fhH64!@_", 0);
        }
        setUpElements();
        boolean RecentIs = false;
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
            RecentIs = true;
        } catch (Exception e) {
            //Toast.makeText(this, "Не получилось открыть RecentFiles.txt", Toast.LENGTH_LONG).show();
        }
        if (RecentIs) {
            recentAccountFounded(ChosenWay, Lines);
        }
    }

    private void setUpElements() {
        username = findViewById(R.id.line_username);
        password = findViewById(R.id.line_password);
        error = findViewById(R.id.error_textview);
    }

    public void login_button_pressed(View view) {
        String CODE_USER_NAME = "user";
        String CODE_WINS_COUNT = "wins";
        String CODE_LOSES_COUNT = "loses";
        String CODE_LOGIN = "login";
        String CODE_PASSWORD = "password";
        String username_entered = username.getText().toString();
        String password_entered = password.getText().toString();
        Context c = getApplicationContext();
        String pre_path = c.getFilesDir().getPath();
        String file_path = pre_path + "/" + username_entered + ".txt";
        String[] Lines = new String[3];
        String temp_line;
        String password_read = "---";
        // Поиск заданного аккаунта
        try {
            File file = new File(file_path);
            FileReader FileInput = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(FileInput);
            byte i = 0;
            while ((temp_line = bufferedReader.readLine()) != null) {
                Lines[i] = temp_line;
                i++;
            }
            password_read = Lines[0];
            bufferedReader.close();
        } catch (Exception e) {
            error.setText("Ошибка, аккаунт не найден.");
        }
        // Конец поиска заданного аккаунта
        if (password_entered.equals(password_read)) { // Сравнение введенного пароля
            Toast.makeText(this, "Здравствуйте, " + username_entered, Toast.LENGTH_LONG).show();
            int wins = Integer.parseInt(Lines[1]);
            int loses = Integer.parseInt(Lines[2]);
            // Запись недавнего аккаунта
            FileOutputStream FileOutput = null;
            try {
                FileOutput = openFileOutput("RecentAccounts.txt", MODE_PRIVATE);
                FileOutput.write(username_entered.getBytes());
                FileOutput.write("\n".getBytes());
                FileOutput.write(password_entered.getBytes());
            } catch (IOException ex) {
                Toast.makeText(this, "Недавний аккаунт не сохранен!!!", Toast.LENGTH_SHORT).show();
            } finally {
                try {
                    if (FileOutput != null) FileOutput.close();
                } catch (IOException ex) {
                    Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            // Конец записи недавнего аккаунта
            if (ChosenWay == 0) {
                Intent intent = new Intent(LoginPassActivity.this, RecordsTableActivity.class);
                intent.putExtra(CODE_USER_NAME, username_entered);
                intent.putExtra(CODE_WINS_COUNT, wins);
                intent.putExtra(CODE_LOSES_COUNT, loses);
                startActivity(intent);
            } else {
                Intent intent = new Intent(LoginPassActivity.this, PrivateCabinetActivity.class);
                intent.putExtra(CODE_LOGIN, username_entered);
                intent.putExtra(CODE_PASSWORD, password_read);
                intent.putExtra(CODE_WINS_COUNT, wins);
                intent.putExtra(CODE_LOSES_COUNT, loses);
                startActivity(intent);
            }
        } else {
            error.setText("Ошибка, проверьте введенные данные.");
        }
    }

    private void recentAccountFounded(int ChosenWay, String[] RecentLines) {
        String CODE_USER_NAME = "user";
        String CODE_WINS_COUNT = "wins";
        String CODE_LOSES_COUNT = "loses";
        String CODE_LOGIN = "login";
        String CODE_PASSWORD = "password";
        String CODE_RECENT = "recent";
        String temp_line;
        String[] Lines = new String[3];
        Context c = getApplicationContext();
        String pre_path = c.getFilesDir().getPath();
        String file_path = pre_path + "/" + RecentLines[0] + ".txt";
        boolean recent = true;
        try {
            File file = new File(file_path);
            FileReader FileInput = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(FileInput);
            int i = 0;
            while ((temp_line = bufferedReader.readLine()) != null) {
                Lines[i] = temp_line;
                i++;
            }
            bufferedReader.close(); // закрываем поток
        } catch (Exception e) {
            Toast.makeText(this, "Ошибка, недавний аккаунт не открыт", Toast.LENGTH_SHORT).show();
        }
        int wins = Integer.parseInt(Lines[1]);
        int loses = Integer.parseInt(Lines[2]);

        if (ChosenWay == 0) {
            Intent intent = new Intent(LoginPassActivity.this, RecordsTableActivity.class);
            intent.putExtra(CODE_USER_NAME, RecentLines[0]);
            intent.putExtra(CODE_WINS_COUNT, wins);
            intent.putExtra(CODE_LOSES_COUNT, loses);
            intent.putExtra(CODE_RECENT, recent);
            startActivity(intent);
        } else {
            Intent intent = new Intent(LoginPassActivity.this, PrivateCabinetActivity.class);
            intent.putExtra(CODE_LOGIN, RecentLines[0]);
            intent.putExtra(CODE_PASSWORD, RecentLines[1]);
            intent.putExtra(CODE_WINS_COUNT, wins);
            intent.putExtra(CODE_LOSES_COUNT, loses);
            intent.putExtra(CODE_RECENT, recent);
            startActivity(intent);
        }
    }

    public void back_button_pressed(View view) {
        finish();
    }

    public void create_button_pressed(View view) {
        Intent intent = new Intent(LoginPassActivity.this, CreateAccountActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPause() {
        super.onPause();
        refreshAll();
    }

    private void refreshAll() {
        error.setText("");
        username.setText("");
        password.setText("");
    }
}