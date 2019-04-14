package com.cms.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateAccountActivity extends AppCompatActivity {


    EditText username;
    EditText password;
    TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        username = findViewById(R.id.line_username);
        password = findViewById(R.id.line_password);
        error = findViewById(R.id.error_textview);
    }

    public void create_button_pressed(View view) {
        String username_entered;
        username_entered = username.getText().toString();
        String password_entered;
        password_entered = password.getText().toString();
        if (!username_entered.equals("") && !password_entered.equals("")) {
            if (username_entered.length() <= 10 && password_entered.length() <= 10) {
                refreshError();
                FileOutputStream FileOutput = null;
                try {
                    String temp_score = "0";
                    FileOutput = openFileOutput(username_entered + ".txt", MODE_PRIVATE);
                    FileOutput.write(password_entered.getBytes());
                    FileOutput.write("\n".getBytes());
                    FileOutput.write(temp_score.getBytes());
                    FileOutput.write("\n".getBytes());
                    FileOutput.write(temp_score.getBytes());
                    Toast.makeText(this, "Аккаунт успешно создан", Toast.LENGTH_SHORT).show();
                } catch (IOException ex) {
                    Toast.makeText(this, "Ошибка создания", Toast.LENGTH_SHORT).show();
                } finally {
                    try {
                        if (FileOutput != null) FileOutput.close();
                    } catch (IOException ex) {
                        Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                finish();
            } else {
                error.setText("Максимальная длина полей 10 символов.");
            }
        } else if (username_entered.equals("") || password_entered.equals("")) {
            error.setText("Поля не должны быть пустыми");
        }
    }

    public void back_button_pressed(View view) {
        finish();
    }

    private void refreshError() {
        error.setText("");
    }

}
