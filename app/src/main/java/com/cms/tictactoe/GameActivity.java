package com.cms.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    public int turn = 1;
    public int[][] cell = new int[3][3];
    public boolean end = false;

    Button mButton_0_0;
    Button mButton_0_1;
    Button mButton_0_2;
    Button mButton_1_0;
    Button mButton_1_1;
    Button mButton_1_2;
    Button mButton_2_0;
    Button mButton_2_1;
    Button mButton_2_2;
    Button mButton_white_flag;
    TextView mTextViewTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mButton_0_0 = findViewById(R.id.cell_0_0);
        mButton_0_1 = findViewById(R.id.cell_0_1);
        mButton_0_2 = findViewById(R.id.cell_0_2);
        mButton_1_0 = findViewById(R.id.cell_1_0);
        mButton_1_1 = findViewById(R.id.cell_1_1);
        mButton_1_2 = findViewById(R.id.cell_1_2);
        mButton_2_0 = findViewById(R.id.cell_2_0);
        mButton_2_1 = findViewById(R.id.cell_2_1);
        mButton_2_2 = findViewById(R.id.cell_2_2);
        mButton_white_flag = findViewById(R.id.button_white_flag);
        mTextViewTurn = findViewById(R.id.TextViewTurn);
        updateTurnText();
        updateButtonsUsabilty(true);
    }

    public void cell_0_0_pressed(View view) {
        if (cell[0][0] != 1 && cell[0][0] != 2) { // 1 - нолик, 2 - крестик
            if (turn == 1) {
                cell[0][0] = 1;
                mButton_0_0.setText("O");
            } else {
                cell[0][0] = 2;
                mButton_0_0.setText("X");
            }
            updateTurnValue();
            updateTurnText();
            checkWin();
        } else {
            Toast.makeText(this, "Данная клетка уже занята", Toast.LENGTH_SHORT).show();
        }
    }

    public void cell_0_1_pressed(View view) {
        if (cell[0][1] != 1 && cell[0][1] != 2) { // 1 - нолик, 2 - крестик
            if (turn == 1) {
                cell[0][1] = 1;
                mButton_0_1.setText("O");
            } else {
                cell[0][1] = 2;
                mButton_0_1.setText("X");
            }
            updateTurnValue();
            updateTurnText();
            checkWin();
        } else {
            Toast.makeText(this, "Данная клетка уже занята", Toast.LENGTH_SHORT).show();
        }
    }

    public void cell_0_2_pressed(View view) {
        if (cell[0][2] != 1 && cell[0][2] != 2) { // 1 - нолик, 2 - крестик
            if (turn == 1) {
                cell[0][2] = 1;
                mButton_0_2.setText("O");
            } else {
                cell[0][2] = 2;
                mButton_0_2.setText("X");
            }
            updateTurnValue();
            updateTurnText();
            checkWin();
        } else {
            Toast.makeText(this, "Данная клетка уже занята", Toast.LENGTH_SHORT).show();
        }
    }

    public void cell_2_0_pressed(View view) {
        if (cell[2][0] != 1 && cell[2][0] != 2) { // 1 - нолик, 2 - крестик
            if (turn == 1) {
                cell[2][0] = 1;
                mButton_2_0.setText("O");
            } else {
                cell[2][0] = 2;
                mButton_2_0.setText("X");
            }
            updateTurnValue();
            updateTurnText();
            checkWin();
        } else {
            Toast.makeText(this, "Данная клетка уже занята", Toast.LENGTH_SHORT).show();
        }
    }

    public void cell_2_1_pressed(View view) {
        if (cell[2][1] != 1 && cell[2][1] != 2) { // 1 - нолик, 2 - крестик
            if (turn == 1) {
                cell[2][1] = 1;
                mButton_2_1.setText("O");
            } else {
                cell[2][1] = 2;
                mButton_2_1.setText("X");
            }
            updateTurnValue();
            updateTurnText();
            checkWin();
        } else {
            Toast.makeText(this, "Данная клетка уже занята", Toast.LENGTH_SHORT).show();
        }
    }

    public void cell_2_2_pressed(View view) {
        if (cell[2][2] != 1 && cell[2][2] != 2) { // 1 - нолик, 2 - крестик
            if (turn == 1) {
                cell[2][2] = 1;
                mButton_2_2.setText("O");
            } else {
                cell[2][2] = 2;
                mButton_2_2.setText("X");
            }
            updateTurnValue();
            updateTurnText();
            checkWin();
        } else {
            Toast.makeText(this, "Данная клетка уже занята", Toast.LENGTH_SHORT).show();
        }
    }

    public void cell_1_2_pressed(View view) {
        if (cell[1][2] != 1 && cell[1][2] != 2) { // 1 - нолик, 2 - крестик
            if (turn == 1) {
                cell[1][2] = 1;
                mButton_1_2.setText("O");
            } else {
                cell[1][2] = 2;
                mButton_1_2.setText("X");
            }
            updateTurnValue();
            updateTurnText();
            checkWin();
        } else {
            Toast.makeText(this, "Данная клетка уже занята", Toast.LENGTH_SHORT).show();
        }
    }

    public void cell_1_1_pressed(View view) {
        if (cell[1][1] != 1 && cell[1][1] != 2) { // 1 - нолик, 2 - крестик
            if (turn == 1) {
                cell[1][1] = 1;
                mButton_1_1.setText("O");
            } else {
                cell[1][1] = 2;
                mButton_1_1.setText("X");
            }
            updateTurnValue();
            updateTurnText();
            checkWin();
        } else {
            Toast.makeText(this, "Данная клетка уже занята", Toast.LENGTH_SHORT).show();
        }
    }

    public void cell_1_0_pressed(View view) {
        if (cell[1][0] != 1 && cell[1][0] != 2) { // 1 - нолик, 2 - крестик
            if (turn == 1) {
                cell[1][0] = 1;
                mButton_1_0.setText("O");
            } else {
                cell[1][0] = 2;
                mButton_1_0.setText("X");
            }
            updateTurnValue();
            updateTurnText();
            checkWin();
        } else {
            Toast.makeText(this, "Данная клетка уже занята", Toast.LENGTH_SHORT).show();
        }
    }

    public void white_flag_pressed(View view) {
        if (!end) Toast.makeText(this, "Вы проиграли!", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void updateTurnText() {
        if (turn == 1) {
            mTextViewTurn.setText("Ход ноликов");
        } else {
            mTextViewTurn.setText("Ход крестиков");
        }
    }

    public void updateTurnValue() {
        if (turn == 1) turn = 2;
        else turn = 1;
    }

    public void updateButtonsUsabilty(boolean Enable) {
        mButton_0_0.setEnabled(Enable);
        mButton_0_1.setEnabled(Enable);
        mButton_0_2.setEnabled(Enable);
        mButton_1_0.setEnabled(Enable);
        mButton_1_1.setEnabled(Enable);
        mButton_1_2.setEnabled(Enable);
        mButton_2_0.setEnabled(Enable);
        mButton_2_1.setEnabled(Enable);
        mButton_2_2.setEnabled(Enable);
    }

    public void checkWin() {
        int res;
        LogicCalculation Calc = new LogicCalculation();
        res = Calc.LogicCheck(cell);
        switch (res) {
            case 0:
                mTextViewTurn.setText("Ничья!");
                updateButtonsUsabilty(false);
                mButton_white_flag.setText("Назад");
                end = true;
                break;
            case 1:
                mTextViewTurn.setText("Нолики победили!");
                mButton_white_flag.setText("Назад");
                updateButtonsUsabilty(false);
                end = true;
                break;
            case 2:
                mTextViewTurn.setText("Крестики победили!");
                updateButtonsUsabilty(false);
                mButton_white_flag.setText("Назад");
                end = true;
                break;
            case -1:
                break;
            default:
                mTextViewTurn.setText("Произошла какая-то ошибка(");
                updateButtonsUsabilty(false);
                mButton_white_flag.setText("Валим отсюда");
                end = true;
                break;
        }
    }


}
