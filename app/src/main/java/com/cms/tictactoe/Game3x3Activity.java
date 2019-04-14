package com.cms.tictactoe;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Game3x3Activity extends AppCompatActivity {

    int turn;
    int[][] cell = new int[3][3];
    boolean end = false;
    int computer_difficulty;
    int mark_type;
    int player_type;
    int[] bot_choice = new int[2];

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
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_game3x3);
        Bundle SavedData = getIntent().getExtras();
        if (SavedData != null) {
            computer_difficulty = SavedData.getInt("VrFQ}Ig}5Vn$M", 1);
            mark_type = SavedData.getInt("h&3gt(*h%tr48", 2);
            player_type = SavedData.getInt("*M68m=bvBn6%5", 2);
            turn = mark_type;
        }
        setUpElements();
        if (mark_type == 1) {
            if (player_type == 1) {
                turn = 2;
                ComputerTurn();
                turn = 1;
            }
        }
        updateTurnText();
        String temp;
        temp = ((MyApplication) this.getApplication()).getTextLine(37);
        mButton_white_flag.setText(temp);
    }

    private void setUpElements() {
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

    public void white_flag_pressed(View view) {
        String temp;
        if (!end && player_type == 1) {
            scoreDown();
            temp = ((MyApplication) this.getApplication()).getTextLine(31);
            Toast.makeText(this, temp, Toast.LENGTH_SHORT).show();
        } else if (!end && turn == 1) {
            temp = ((MyApplication) this.getApplication()).getTextLine(32);
            Toast.makeText(this, temp, Toast.LENGTH_SHORT).show();
        } else if (!end && turn == 2) {
            temp = ((MyApplication) this.getApplication()).getTextLine(33);
            Toast.makeText(this, temp, Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    private void updateTurnText() {
        String temp;
        if (turn == 1) {
            temp = ((MyApplication) this.getApplication()).getTextLine(30);
            mTextViewTurn.setText(temp);
        } else {
            temp = ((MyApplication) this.getApplication()).getTextLine(29);
            mTextViewTurn.setText(temp);
        }
    }

    private void updateTurnValue() {
        if (turn == 1) turn = 2;
        else turn = 1;
    }

    private void checkWin() {
        int res;
        ZLogicCalculation3x3 Calc = new ZLogicCalculation3x3();
        res = Calc.LogicCheck(cell);
        String temp;
        switch (res) {
            case 0:
                temp = ((MyApplication) this.getApplication()).getTextLine(34);
                mTextViewTurn.setText(temp);
                updateButtonsUsabilty(false);
                temp = ((MyApplication) this.getApplication()).getTextLine(13);
                mButton_white_flag.setText(temp);
                end = true;
                break;
            case 1:
                if (player_type == 1) {
                    if (mark_type == 1) scoreUp();
                    else scoreDown();
                }
                temp = ((MyApplication) this.getApplication()).getTextLine(36);
                mTextViewTurn.setText(temp);
                temp = ((MyApplication) this.getApplication()).getTextLine(13);
                mButton_white_flag.setText(temp);
                updateButtonsUsabilty(false);
                end = true;
                break;
            case 2:
                if (player_type == 1) {
                    if (mark_type == 2) scoreUp();
                    else scoreDown();
                }
                temp = ((MyApplication) this.getApplication()).getTextLine(35);
                mTextViewTurn.setText(temp);
                updateButtonsUsabilty(false);
                temp = ((MyApplication) this.getApplication()).getTextLine(13);
                mButton_white_flag.setText(temp);
                end = true;
                break;
            case -1:
                break;
            default:
                mTextViewTurn.setText("------");
                updateButtonsUsabilty(false);
                temp = ((MyApplication) this.getApplication()).getTextLine(13);
                mButton_white_flag.setText(temp);
                end = true;
                break;
        }
    }

    private void fillNewFile(String login, String[] Lines) {
        FileOutputStream FileOutput = null;
        try {
            FileOutput = openFileOutput(login + ".txt", MODE_PRIVATE);
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

    private void scoreUp() {
        Context c = getApplicationContext();
        String pre_path = c.getFilesDir().getPath();
        String file_path = pre_path + "/RecentAccounts.txt";
        boolean recent = false;
        String login = "null";
        try {
            File file = new File(file_path);
            FileReader FileInput = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(FileInput);
            login = bufferedReader.readLine();
            bufferedReader.close();
            recent = true;
        } catch (Exception e) {
            //Toast.makeText(this, "Не получилось открыть RecentFiles.txt", Toast.LENGTH_LONG).show();
        }
        if (recent) {
            file_path = pre_path + "/" + login + ".txt";
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
            } catch (Exception e) {
                Toast.makeText(this, "Ошибка в чтении аккаунта", Toast.LENGTH_SHORT).show();
            }
            deleteOldFile(file_path); // Удаляем старый файл
            byte action = 0;
            Lines[1] = changeScore(action, Lines); //
            fillNewFile(login, Lines); // Создаем новый файл и заполняем старыми данными
        } else {
            //Toast.makeText(this, "Ошибка!", Toast.LENGTH_LONG).show();
        }
    }

    private void scoreDown() {
        Context c = getApplicationContext();
        String pre_path = c.getFilesDir().getPath();
        String file_path = pre_path + "/RecentAccounts.txt";
        boolean recent = false;
        String login = "null";
        try {
            File file = new File(file_path);
            FileReader FileInput = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(FileInput);
            login = bufferedReader.readLine();
            bufferedReader.close();
            recent = true;
        } catch (Exception e) {
            //Toast.makeText(this, "Не получилось открыть RecentFiles.txt", Toast.LENGTH_LONG).show();
        }
        if (recent) {
            file_path = pre_path + "/" + login + ".txt";
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
            byte action = 1;
            Lines[2] = changeScore(action, Lines); // Изменяем данные игрока
            fillNewFile(login, Lines); // Создаем новый файл и заполняем старыми данными
        } else {
            //Toast.makeText(this, "Ошибка!", Toast.LENGTH_LONG).show();
        }
    }

    private String changeScore(byte action, String[] Lines) {
        if (action == 0) {
            int wins_count = Integer.parseInt(Lines[1]);
            wins_count++;
            Lines[1] = String.valueOf(wins_count);
            return Lines[1];
        } else {
            int loses_count = Integer.parseInt(Lines[2]);
            loses_count++;
            Lines[2] = String.valueOf(loses_count);
            return Lines[2];
        }
    }

    private void deleteOldFile(String file_path) {
        File file = new File(file_path);
        file.delete();
    }

    private void ComputerTurn() {
        if (!end) {
            ZComputerPlayer Bot = new ZComputerPlayer();
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
                    bot_choice = Bot.HardComputer3x3(cell, turn);
                    SetComputerMark(bot_choice);
                    break;
                default:
                    Toast.makeText(this, "Возникла ошибка в работе бота!", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

    private void SetComputerMark(int[] bot_choice) {
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
            }
        }
    }

    public void onBackPressed() {
    }
}
