package com.cms.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RecordsTableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records_table);
    }

    public void back_button_pressed(View view) {
        finish();
    }

    public void onBackPressed() {
        finish();
    }
}
