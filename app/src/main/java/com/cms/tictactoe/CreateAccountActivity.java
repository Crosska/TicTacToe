package com.cms.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateAccountActivity extends AppCompatActivity {


    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        username = findViewById(R.id.line_username);
        password = findViewById(R.id.line_password);
    }

    public void create_button_pressed(View view) {
        String username_entered;
        String password_entered;

        username_entered = username.getText().toString();
        password_entered = password.getText().toString();
        FileOutputStream FileOutput = null;

        try {
            FileOutput = openFileOutput(username_entered + ".txt", MODE_PRIVATE);
            FileOutput.write(password_entered.getBytes());
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
    }


    public void back_button_pressed(View view) {
        finish();
    }
}
