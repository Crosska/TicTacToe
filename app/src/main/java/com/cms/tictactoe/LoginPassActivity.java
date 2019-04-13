package com.cms.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LoginPassActivity extends AppCompatActivity {

    private int ChosenWay;

    EditText username;
    EditText password;
    TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pass);
        Bundle SavedData = getIntent().getExtras();
        if (SavedData != null) {
            ChosenWay = SavedData.getInt("fd(73fhH64!@_", 0);
        }
        username = findViewById(R.id.line_username);
        password = findViewById(R.id.line_password);
        error = findViewById(R.id.error_textview);
    }

    public void login_button_pressed(View view) {
        String CODE_USER_NAME = "h&3gt(*h%tr48";
        String CODE_WINS_COUNT = "8h@#f09g__08f";
        String CODE_LOSES_COUNT = "VrFQ}Ig}5Vn$M";

        String username_entered;
        String password_entered;
        String file_path;

        username_entered = username.getText().toString();
        password_entered = password.getText().toString();
        file_path = "/data/data/com.cms.tictactoe/files/" + username_entered + ".txt";

        String[] Lines = new String[3];
        String temp_line;
        String password_read = "---";

        try {
            File file = new File(file_path);
            FileReader FileInput = new FileReader(file); // поток который подключается к текстовому файлу
            BufferedReader bufferedReader = new BufferedReader(FileInput); // соединяем FileReader с BufferedReader

            int i = 0;
            while ((temp_line = bufferedReader.readLine()) != null) {
                Lines[i] = temp_line; // записываем содержимое файла в массив String построчно
                i++;
            }
            password_read = Lines[0]; // Присваеваем контрольное значение String пароля
            bufferedReader.close(); // закрываем поток
        } catch (Exception e) {
            error.setText("Ошибка, аккаунт не найден.");
        }
        if (password_entered.equals(password_read)) {
            Toast.makeText(this, "Здравствуйте, " + username_entered, Toast.LENGTH_LONG).show();
            int wins = Integer.parseInt(Lines[1]);
            int loses = Integer.parseInt(Lines[2]);
            if (ChosenWay == 0) {
                Intent intent = new Intent(LoginPassActivity.this, RecordsTableActivity.class);
                intent.putExtra(CODE_USER_NAME, username_entered);
                intent.putExtra(CODE_WINS_COUNT, wins);
                intent.putExtra(CODE_LOSES_COUNT, loses);
                startActivity(intent);
            } else {
                Intent intent = new Intent(LoginPassActivity.this, PrivateCabinetActivity.class);
                //intent.putExtra()
                startActivity(intent);
            }
        } else {
            error.setText("Ошибка, проверьте введенные данные.");
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
