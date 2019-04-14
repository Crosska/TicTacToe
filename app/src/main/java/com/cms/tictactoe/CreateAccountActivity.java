package com.cms.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateAccountActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    TextView error;
    TextView header;
    TextView username_hint;
    TextView password_hint;
    Button create;
    Button back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        setUpElements();
        setText();
    }

    private void setText() {
        String temp = ((MyApplication) this.getApplication()).getTextLine(38);
        header.setText(temp);
        temp = ((MyApplication) this.getApplication()).getTextLine(39);
        username_hint.setText(temp);
        temp = ((MyApplication) this.getApplication()).getTextLine(40);
        password_hint.setText(temp);
        temp = ((MyApplication) this.getApplication()).getTextLine(41);
        create.setText(temp);
        temp = ((MyApplication) this.getApplication()).getTextLine(13);
        back.setText(temp);
    }

    private void setUpElements() {
        username = findViewById(R.id.line_username);
        password = findViewById(R.id.line_password);
        error = findViewById(R.id.error_textview);
        header = findViewById(R.id.header_textview);
        username_hint = findViewById(R.id.login_hint_textview);
        password_hint = findViewById(R.id.password_hint_textview);
        create = findViewById(R.id.create_button);
        back = findViewById(R.id.back_button);
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
                    String temp = ((MyApplication) this.getApplication()).getTextLine(42);
                    Toast.makeText(this, temp, Toast.LENGTH_SHORT).show();
                } catch (IOException ex) {
                    String temp = ((MyApplication) this.getApplication()).getTextLine(45);
                    Toast.makeText(this, temp, Toast.LENGTH_SHORT).show();
                } finally {
                    try {
                        if (FileOutput != null) FileOutput.close();
                    } catch (IOException ex) {
                        Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                finish();
            } else {
                String temp = ((MyApplication) this.getApplication()).getTextLine(43);
                error.setText(temp);
            }
        } else if (username_entered.equals("") || password_entered.equals("")) {
            String temp = ((MyApplication) this.getApplication()).getTextLine(44);
            error.setText(temp);
        }
    }

    public void back_button_pressed(View view) {
        finish();
    }

    private void refreshError() {
        error.setText("");
    }

}
