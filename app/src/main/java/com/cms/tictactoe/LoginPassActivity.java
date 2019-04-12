package com.cms.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;

public class LoginPassActivity extends AppCompatActivity {

    private int ChosenWay;
    private String Filename = "RecentAccounts.txt";

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
        String username_entered;
        String password_entered;
        String password_read = "---";

        username_entered = username.getText().toString();
        password_entered = password.getText().toString();

        FileInputStream FileInput = null;
        try {
            FileInput = openFileInput(username_entered + ".txt");
            byte[] bytes = new byte[FileInput.available()];
            FileInput.read(bytes);
            password_read = new String(bytes);
        } catch (IOException Error) {
            Toast.makeText(this, "Пользователь не найден.", Toast.LENGTH_SHORT).show();
        }
        try {
            if (FileInput != null)
                FileInput.close();
        } catch (IOException Error) {
            Toast.makeText(this, "Ошибка закрытия файла.", Toast.LENGTH_SHORT).show();
        }
        if (password_entered.equals(password_read)) {
            Toast.makeText(this, "Здравствуйте, " + username_entered, Toast.LENGTH_LONG).show();
            if (ChosenWay == 0) {
                Intent intent = new Intent(LoginPassActivity.this, RecordsTableActivity.class);
                //intent.putExtra()
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
