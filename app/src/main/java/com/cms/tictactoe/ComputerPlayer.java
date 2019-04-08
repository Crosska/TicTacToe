package com.cms.tictactoe;

import java.util.Random;

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
        Random rand = new Random();
        int[] bot_choice = new int[2];
        int random_choice = rand.nextInt(4);
        switch (random_choice) {
            case 0:
                bot_choice = horizontal_way(cell, turn);
                break;
            case 1:
                bot_choice = reverse_horizontal_way(cell, turn);
                break;
            case 2:
                bot_choice = vertical_way(cell, turn);
                break;
            case 3:
                bot_choice = reverse_vertical_way(cell, turn);
                break;
            default:
                break;
        }
        return bot_choice;
    }

    private int[] reverse_vertical_way(int[][] cell, int turn) {
        int[] bot_choice = new int[2];
        boolean find = false;
        for (int j = cell.length - 1; j >= 0; j--) {
            for (int i = cell[0].length - 1; i >= 0; i--) {
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

    private int[] vertical_way(int[][] cell, int turn) {
        int[] bot_choice = new int[2];
        boolean find = false;
        for (byte j = 0; j < cell.length; j++) {
            for (byte i = 0; i < cell[0].length; i++) {
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

    private int[] reverse_horizontal_way(int[][] cell, int turn) {
        int[] bot_choice = new int[2];
        boolean find = false;
        for (int i = cell.length - 1; i >= 0; i--) {
            for (int j = cell[0].length - 1; j >= 0; j--) {
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

    private int[] horizontal_way(int[][] cell, int turn) {
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

    public void HardComputer(int[][] cell, int turn) {


    }

}
