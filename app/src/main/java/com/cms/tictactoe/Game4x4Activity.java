package com.cms.tictactoe;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Game4x4Activity extends AppCompatActivity {

    public int turn;
    public int[][] cell = new int[4][4];
    public boolean end = false;
    int computer_difficulty;
    int mark_type;
    int player_type;
    public int[] bot_choice = new int[2];

    Button mButton_0_0;
    Button mButton_0_1;
    Button mButton_0_2;
    Button mButton_0_3;
    Button mButton_1_0;
    Button mButton_1_1;
    Button mButton_1_2;
    Button mButton_1_3;
    Button mButton_2_0;
    Button mButton_2_1;
    Button mButton_2_2;
    Button mButton_2_3;
    Button mButton_3_0;
    Button mButton_3_1;
    Button mButton_3_2;
    Button mButton_3_3;
    Button mButton_white_flag;
    TextView mTextViewTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_game4x4);
        Bundle SavedData = getIntent().getExtras();
        if (SavedData != null) {
            computer_difficulty = SavedData.getInt("4FyGED3B8WgXe", 1);
            mark_type = SavedData.getInt("8h@#f09g__08f", 2);
            player_type = SavedData.getInt("8{#e6c?~qL%?OK", 2);
            turn = mark_type;
        }
        mButton_0_0 = findViewById(R.id.cell_0_0);
        mButton_0_1 = findViewById(R.id.cell_0_1);
        mButton_0_2 = findViewById(R.id.cell_0_2);
        mButton_0_3 = findViewById(R.id.cell_0_3);
        mButton_1_0 = findViewById(R.id.cell_1_0);
        mButton_1_1 = findViewById(R.id.cell_1_1);
        mButton_1_2 = findViewById(R.id.cell_1_2);
        mButton_1_3 = findViewById(R.id.cell_1_3);
        mButton_2_0 = findViewById(R.id.cell_2_0);
        mButton_2_1 = findViewById(R.id.cell_2_1);
        mButton_2_2 = findViewById(R.id.cell_2_2);
        mButton_2_3 = findViewById(R.id.cell_2_3);
        mButton_3_0 = findViewById(R.id.cell_3_0);
        mButton_3_1 = findViewById(R.id.cell_3_1);
        mButton_3_2 = findViewById(R.id.cell_3_2);
        mButton_3_3 = findViewById(R.id.cell_3_3);
        mButton_white_flag = findViewById(R.id.button_white_flag);
        mTextViewTurn = findViewById(R.id.TextViewTurn);
        if (mark_type == 1) {
            if (player_type == 1) {
                turn = 2;
                ComputerTurn();
                turn = 1;
            }
        }
    }

    public void onBackPressed() {
        if (!end && player_type == 1)
            Toast.makeText(this, "Вы проиграли!", Toast.LENGTH_SHORT).show();
        else if (!end && turn == 1)
            Toast.makeText(this, "Нолики проиграли!", Toast.LENGTH_SHORT).show();
        else if (!end && turn == 2)
            Toast.makeText(this, "Крестики проиграли!", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void white_flag_pressed(View view) {
        if (!end && player_type == 1)
            Toast.makeText(this, "Вы проиграли!", Toast.LENGTH_SHORT).show();
        else if (!end && turn == 1)
            Toast.makeText(this, "Нолики проиграли!", Toast.LENGTH_SHORT).show();
        else if (!end && turn == 2)
            Toast.makeText(this, "Крестики проиграли!", Toast.LENGTH_SHORT).show();
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
        mButton_0_3.setEnabled(Enable);
        mButton_1_0.setEnabled(Enable);
        mButton_1_1.setEnabled(Enable);
        mButton_1_2.setEnabled(Enable);
        mButton_1_3.setEnabled(Enable);
        mButton_2_0.setEnabled(Enable);
        mButton_2_1.setEnabled(Enable);
        mButton_2_2.setEnabled(Enable);
        mButton_2_3.setEnabled(Enable);
        mButton_3_0.setEnabled(Enable);
        mButton_3_1.setEnabled(Enable);
        mButton_3_2.setEnabled(Enable);
        mButton_3_3.setEnabled(Enable);
    }

    public void checkWin() {
        int res;
        LogicCalculation4x4 Calc = new LogicCalculation4x4();
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
            if (player_type == 1) ComputerTurn();
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
            if (player_type == 1) ComputerTurn();
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
            if (player_type == 1) ComputerTurn();
        } else {
            Toast.makeText(this, "Данная клетка уже занята", Toast.LENGTH_SHORT).show();
        }
    }

    public void cell_0_3_pressed(View view) {
        if (cell[0][3] != 1 && cell[0][3] != 2) { // 1 - нолик, 2 - крестик
            if (turn == 1) {
                cell[0][3] = 1;
                mButton_0_3.setText("O");
            } else {
                cell[0][3] = 2;
                mButton_0_3.setText("X");
            }
            updateTurnValue();
            updateTurnText();
            checkWin();
            if (player_type == 1) ComputerTurn();
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
            if (player_type == 1) ComputerTurn();
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
            if (player_type == 1) ComputerTurn();
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
            if (player_type == 1) ComputerTurn();
        } else {
            Toast.makeText(this, "Данная клетка уже занята", Toast.LENGTH_SHORT).show();
        }
    }

    public void cell_1_3_pressed(View view) {
        if (cell[1][3] != 1 && cell[1][3] != 2) { // 1 - нолик, 2 - крестик
            if (turn == 1) {
                cell[1][3] = 1;
                mButton_1_3.setText("O");
            } else {
                cell[1][3] = 2;
                mButton_1_3.setText("X");
            }
            updateTurnValue();
            updateTurnText();
            checkWin();
            if (player_type == 1) ComputerTurn();
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
            if (player_type == 1) ComputerTurn();
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
            if (player_type == 1) ComputerTurn();
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
            if (player_type == 1) ComputerTurn();
        } else {
            Toast.makeText(this, "Данная клетка уже занята", Toast.LENGTH_SHORT).show();
        }
    }

    public void cell_2_3_pressed(View view) {
        if (cell[2][3] != 1 && cell[2][3] != 2) { // 1 - нолик, 2 - крестик
            if (turn == 1) {
                cell[2][3] = 1;
                mButton_2_3.setText("O");
            } else {
                cell[2][3] = 2;
                mButton_2_3.setText("X");
            }
            updateTurnValue();
            updateTurnText();
            checkWin();
            if (player_type == 1) ComputerTurn();
        } else {
            Toast.makeText(this, "Данная клетка уже занята", Toast.LENGTH_SHORT).show();
        }
    }

    public void cell_3_0_pressed(View view) {
        if (cell[3][0] != 1 && cell[3][0] != 2) { // 1 - нолик, 2 - крестик
            if (turn == 1) {
                cell[3][0] = 1;
                mButton_3_0.setText("O");
            } else {
                cell[3][0] = 2;
                mButton_3_0.setText("X");
            }
            updateTurnValue();
            updateTurnText();
            checkWin();
            if (player_type == 1) ComputerTurn();
        } else {
            Toast.makeText(this, "Данная клетка уже занята", Toast.LENGTH_SHORT).show();
        }
    }

    public void cell_3_1_pressed(View view) {
        if (cell[3][1] != 1 && cell[3][1] != 2) { // 1 - нолик, 2 - крестик
            if (turn == 1) {
                cell[3][1] = 1;
                mButton_3_1.setText("O");
            } else {
                cell[3][1] = 2;
                mButton_3_1.setText("X");
            }
            updateTurnValue();
            updateTurnText();
            checkWin();
            if (player_type == 1) ComputerTurn();
        } else {
            Toast.makeText(this, "Данная клетка уже занята", Toast.LENGTH_SHORT).show();
        }
    }

    public void cell_3_2_pressed(View view) {
        if (cell[3][2] != 1 && cell[3][2] != 2) { // 1 - нолик, 2 - крестик
            if (turn == 1) {
                cell[3][2] = 1;
                mButton_3_2.setText("O");
            } else {
                cell[3][2] = 2;
                mButton_3_2.setText("X");
            }
            updateTurnValue();
            updateTurnText();
            checkWin();
            if (player_type == 1) ComputerTurn();
        } else {
            Toast.makeText(this, "Данная клетка уже занята", Toast.LENGTH_SHORT).show();
        }
    }

    public void cell_3_3_pressed(View view) {
        if (cell[3][3] != 1 && cell[3][3] != 2) { // 1 - нолик, 2 - крестик
            if (turn == 1) {
                cell[3][3] = 1;
                mButton_3_3.setText("O");
            } else {
                cell[3][3] = 2;
                mButton_3_3.setText("X");
            }
            updateTurnValue();
            updateTurnText();
            checkWin();
            if (player_type == 1) ComputerTurn();
        } else {
            Toast.makeText(this, "Данная клетка уже занята", Toast.LENGTH_SHORT).show();
        }
    }

    public void ComputerTurn() {
        if (!end) {
            ComputerPlayer Bot = new ComputerPlayer();
            switch (computer_difficulty) {
                case 1:
                    bot_choice = Bot.EasyComputer(cell, turn);
                    SetComputerMark(bot_choice);
                    break;
                case 2:
                    bot_choice = Bot.NormalComputer(cell, turn);
                    SetComputerMark(bot_choice);
                    break;
                case 3:
                    bot_choice = Bot.HardComputer4x4(cell);
                    SetComputerMark(bot_choice);
                    break;
                default:
                    Toast.makeText(this, "Возникла ошибка в работе бота!", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

    public void SetComputerMark(int[] bot_choice) {
        if (!end) {
            if ((bot_choice[0] == 0) && (bot_choice[1] == 0)) {
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
            } else if ((bot_choice[0] == 0) && (bot_choice[1] == 1)) {
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
            } else if ((bot_choice[0] == 0) && (bot_choice[1] == 2)) {
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
            } else if ((bot_choice[0] == 0) && (bot_choice[1] == 3)) {
                if (turn == 1) {
                    cell[0][3] = 1;
                    mButton_0_3.setText("O");
                } else {
                    cell[0][3] = 2;
                    mButton_0_3.setText("X");
                }
                updateTurnValue();
                updateTurnText();
                checkWin();
            } else if ((bot_choice[0] == 1) && (bot_choice[1] == 0)) {
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
            } else if ((bot_choice[0] == 1) && (bot_choice[1] == 1)) {
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
            } else if ((bot_choice[0] == 1) && (bot_choice[1] == 2)) {
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
            } else if ((bot_choice[0] == 1) && (bot_choice[1] == 3)) {
                if (turn == 1) {
                    cell[1][3] = 1;
                    mButton_1_3.setText("O");
                } else {
                    cell[1][3] = 2;
                    mButton_1_3.setText("X");
                }
                updateTurnValue();
                updateTurnText();
                checkWin();
            } else if ((bot_choice[0] == 2) && (bot_choice[1] == 0)) {
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
            } else if ((bot_choice[0] == 2) && (bot_choice[1] == 1)) {
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
            } else if ((bot_choice[0] == 2) && (bot_choice[1] == 2)) {
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
            } else if ((bot_choice[0] == 2) && (bot_choice[1] == 3)) {
                if (turn == 1) {
                    cell[2][3] = 1;
                    mButton_2_3.setText("O");
                } else {
                    cell[2][3] = 2;
                    mButton_2_3.setText("X");
                }
                updateTurnValue();
                updateTurnText();
                checkWin();
            } else if ((bot_choice[0] == 3) && (bot_choice[1] == 0)) {
                if (turn == 1) {
                    cell[3][0] = 1;
                    mButton_3_0.setText("O");
                } else {
                    cell[3][0] = 2;
                    mButton_3_0.setText("X");
                }
                updateTurnValue();
                updateTurnText();
                checkWin();
            } else if ((bot_choice[0] == 3) && (bot_choice[1] == 1)) {
                if (turn == 1) {
                    cell[3][1] = 1;
                    mButton_3_1.setText("O");
                } else {
                    cell[3][1] = 2;
                    mButton_3_1.setText("X");
                }
                updateTurnValue();
                updateTurnText();
                checkWin();
            } else if ((bot_choice[0] == 3) && (bot_choice[1] == 2)) {
                if (turn == 1) {
                    cell[3][2] = 1;
                    mButton_3_2.setText("O");
                } else {
                    cell[3][2] = 2;
                    mButton_3_2.setText("X");
                }
                updateTurnValue();
                updateTurnText();
                checkWin();
            } else if ((bot_choice[0] == 3) && (bot_choice[1] == 3)) {
                if (turn == 1) {
                    cell[3][3] = 1;
                    mButton_3_3.setText("O");
                } else {
                    cell[3][3] = 2;
                    mButton_3_3.setText("X");
                }
                updateTurnValue();
                updateTurnText();
                checkWin();
            }
        }
    }

}
