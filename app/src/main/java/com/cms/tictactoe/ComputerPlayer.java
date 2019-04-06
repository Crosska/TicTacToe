package com.cms.tictactoe;

public class ComputerPlayer {

    public int[] EasyComputer(int[][] cell, int turn) {
        int[] bot_choice = new int[2];
        boolean find = false;
        for (byte i = 0; i < cell.length; i++) {
            for (byte j = 0; j < cell[0].length; j++) {
                if (cell[i][j] == 0) {
                    if (turn == 1) {
                        cell[i][j] = 1;
                        bot_choice[0] = i;
                        bot_choice[1] = j;
                        find = true;
                        break;
                    } else {
                        cell[i][j] = 2;
                        bot_choice[0] = i;
                        bot_choice[1] = j;
                        find = true;
                        break;
                    }
                }
                if (find) break;
            }
            if (find) break;
        }
        return bot_choice;
    }

    public int[] NormalComputer(int[][] cell, int turn) {
        int[] bot_choice = new int[2];
        return bot_choice;
    }

    public void HardComputer(int[][] cell, int turn) {

    }

}
