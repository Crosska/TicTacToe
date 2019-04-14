package com.cms.tictactoe;

import java.util.Random;

public class ZComputerPlayer {

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

    public int[] HardComputer3x3(int[][] cell, int turn) {
        int[] bot_choice = new int[2];
        if ((cell[0][0] == 1 && cell[0][1] == 1) || (cell[0][0] == 2 && cell[0][1] == 2)) {
            if (cell[0][2] == 0) {
                bot_choice[0] = 0;
                bot_choice[1] = 2;
                return bot_choice;
            }
        }
        if ((cell[1][0] == 1 && cell[1][1] == 1) || (cell[1][0] == 2 && cell[1][1] == 2)) {
            if (cell[1][2] == 0) {
                bot_choice[0] = 1;
                bot_choice[1] = 2;
                return bot_choice;
            }
        }
        if ((cell[2][0] == 1 && cell[2][1] == 1) || (cell[2][0] == 2 && cell[2][1] == 2)) {
            if (cell[2][2] == 0) {
                bot_choice[0] = 2;
                bot_choice[1] = 2;
                return bot_choice;
            }
        }
        if ((cell[0][1] == 1 && cell[0][2] == 1) || (cell[0][1] == 2 && cell[0][2] == 2)) {
            if (cell[0][0] == 0) {
                bot_choice[0] = 0;
                bot_choice[1] = 0;
                return bot_choice;
            }
        }
        if ((cell[1][1] == 1 && cell[1][2] == 1) || (cell[1][1] == 2 && cell[1][2] == 2)) {
            if (cell[1][0] == 0) {
                bot_choice[0] = 1;
                bot_choice[1] = 0;
                return bot_choice;
            }
        }
        if ((cell[2][1] == 1 && cell[2][2] == 1) || (cell[2][1] == 2 && cell[2][2] == 2)) {
            if (cell[2][0] == 0) {
                bot_choice[0] = 2;
                bot_choice[1] = 0;
                return bot_choice;
            }
        }
        if ((cell[0][0] == 1 && cell[1][0] == 1) || (cell[0][0] == 2 && cell[1][0] == 2)) {
            if (cell[2][0] == 0) {
                bot_choice[0] = 2;
                bot_choice[1] = 0;
                return bot_choice;
            }
        }
        if ((cell[0][1] == 1 && cell[1][1] == 1) || (cell[0][1] == 2 && cell[1][1] == 2)) {
            if (cell[2][1] == 0) {
                bot_choice[0] = 2;
                bot_choice[1] = 1;
                return bot_choice;
            }
        }
        if ((cell[0][2] == 1 && cell[1][2] == 1) || (cell[0][2] == 2 && cell[1][2] == 2)) {
            if (cell[2][2] == 0) {
                bot_choice[0] = 2;
                bot_choice[1] = 2;
                return bot_choice;
            }
        }
        if ((cell[1][0] == 1 && cell[2][0] == 1) || (cell[1][0] == 2 && cell[2][0] == 2)) {
            if (cell[2][0] == 0) {
                bot_choice[0] = 0;
                bot_choice[1] = 0;
                return bot_choice;
            }
        }
        if ((cell[1][1] == 1 && cell[2][1] == 1) || (cell[1][1] == 2 && cell[2][1] == 2)) {
            if (cell[0][1] == 0) {
                bot_choice[0] = 0;
                bot_choice[1] = 1;
                return bot_choice;
            }
        }
        if ((cell[1][2] == 1 && cell[2][2] == 1) || (cell[1][2] == 2 && cell[2][2] == 2)) {
            if (cell[0][2] == 0) {
                bot_choice[0] = 0;
                bot_choice[1] = 2;
                return bot_choice;
            }
        }
        if ((cell[0][0] == 1 && cell[1][1] == 1) || (cell[0][0] == 2 && cell[1][1] == 2)) {
            if (cell[2][2] == 0) {
                bot_choice[0] = 2;
                bot_choice[1] = 2;
                return bot_choice;
            }
        }
        if ((cell[1][1] == 1 && cell[2][2] == 1) || (cell[1][1] == 2 && cell[2][2] == 2)) {
            if (cell[0][0] == 0) {
                bot_choice[0] = 0;
                bot_choice[1] = 0;
                return bot_choice;
            }
        }
        if ((cell[2][0] == 1 && cell[1][1] == 1) || (cell[2][0] == 2 && cell[1][1] == 2)) {
            if (cell[0][2] == 0) {
                bot_choice[0] = 0;
                bot_choice[1] = 2;
                return bot_choice;
            }
        }
        if ((cell[1][1] == 1 && cell[0][2] == 1) || (cell[1][1] == 2 && cell[0][2] == 2)) {
            if (cell[2][0] == 0) {
                bot_choice[0] = 2;
                bot_choice[1] = 0;
                return bot_choice;
            }
        }
        if ((cell[0][0] == 1 && cell[0][2] == 1) || (cell[0][0] == 2 && cell[0][2] == 2)) {
            if (cell[0][1] == 0) {
                bot_choice[0] = 0;
                bot_choice[1] = 1;
                return bot_choice;
            }
        }
        if ((cell[1][0] == 1 && cell[1][2] == 1) || (cell[1][0] == 2 && cell[1][2] == 2)) {
            if (cell[1][1] == 0) {
                bot_choice[0] = 1;
                bot_choice[1] = 1;
                return bot_choice;
            }
        }
        if ((cell[2][0] == 1 && cell[2][2] == 1) || (cell[2][0] == 2 && cell[2][2] == 2)) {
            if (cell[2][1] == 0) {
                bot_choice[0] = 2;
                bot_choice[1] = 1;
                return bot_choice;
            }
        }
        if ((cell[0][0] == 1 && cell[2][0] == 1) || (cell[0][0] == 2 && cell[2][0] == 2)) {
            if (cell[1][0] == 0) {
                bot_choice[0] = 1;
                bot_choice[1] = 0;
                return bot_choice;
            }
        }
        if ((cell[0][1] == 1 && cell[2][1] == 1) || (cell[0][1] == 2 && cell[2][1] == 2)) {
            if (cell[1][1] == 0) {
                bot_choice[0] = 1;
                bot_choice[1] = 1;
                return bot_choice;
            }
        }
        if ((cell[0][2] == 1 && cell[2][2] == 1) || (cell[0][2] == 2 && cell[2][2] == 2)) {
            if (cell[1][2] == 0) {
                bot_choice[0] = 1;
                bot_choice[1] = 2;
                return bot_choice;
            }
        }
        if ((cell[2][0] == 1 && cell[0][2] == 1) || (cell[2][0] == 2 && cell[0][2] == 2)) {
            if (cell[1][1] == 0) {
                bot_choice[0] = 1;
                bot_choice[1] = 1;
                return bot_choice;
            }
        }
        if ((cell[0][0] == 1 && cell[2][2] == 1) || (cell[0][0] == 2 && cell[2][2] == 2)) {
            if (cell[1][1] == 0) {
                bot_choice[0] = 1;
                bot_choice[1] = 1;
                return bot_choice;
            }
        }
        bot_choice = RandomMark3x3(cell, turn);
        return bot_choice;
    }

    private int[] RandomMark3x3(int[][] cell, int turn) {
        int[] bot_choice = new int[2];
        Random rand = new Random();
        int random_x = rand.nextInt(3);
        int random_y = rand.nextInt(3);
        while ((cell[random_x][random_y]) != 0) {
            random_x = rand.nextInt(3);
            random_y = rand.nextInt(3);
        }
        bot_choice[0] = random_x;
        bot_choice[1] = random_y;
        return bot_choice;
    }

    public int[] HardComputer4x4(int[][] cell) {
        int[] bot_choice = new int[2];
        if ((cell[0][0] == 1 && cell[0][1] == 1 && cell[0][2] == 1) || (cell[0][0] == 2 && cell[0][1] == 2 && cell[0][2] == 2)) {
            if (cell[0][3] == 0) {
                bot_choice[0] = 0;
                bot_choice[1] = 3;
                return bot_choice;
            }
        }
        if ((cell[1][0] == 1 && cell[1][1] == 1 && cell[1][2] == 1) || (cell[1][0] == 2 && cell[1][1] == 2 && cell[1][2] == 2)) {
            if (cell[1][3] == 0) {
                bot_choice[0] = 1;
                bot_choice[1] = 3;
                return bot_choice;
            }
        }
        if ((cell[2][0] == 1 && cell[2][1] == 1 && cell[2][2] == 1) || (cell[2][0] == 2 && cell[2][1] == 2 && cell[2][2] == 2)) {
            if (cell[2][3] == 0) {
                bot_choice[0] = 2;
                bot_choice[1] = 3;
                return bot_choice;
            }
        }
        if ((cell[3][0] == 1 && cell[3][1] == 1 && cell[3][2] == 1) || (cell[3][0] == 2 && cell[3][1] == 2 && cell[3][2] == 2)) {
            if (cell[3][3] == 0) {
                bot_choice[0] = 3;
                bot_choice[1] = 3;
                return bot_choice;
            }
        }
        if ((cell[0][1] == 1 && cell[0][2] == 1 && cell[0][3] == 1) || (cell[0][1] == 2 && cell[0][2] == 2 && cell[0][3] == 2)) {
            if (cell[0][0] == 0) {
                bot_choice[0] = 0;
                bot_choice[1] = 0;
                return bot_choice;
            }
        }
        if ((cell[1][1] == 1 && cell[1][2] == 1 && cell[1][3] == 1) || (cell[1][1] == 2 && cell[1][2] == 2 && cell[1][3] == 2)) {
            if (cell[1][0] == 0) {
                bot_choice[0] = 1;
                bot_choice[1] = 0;
                return bot_choice;
            }
        }
        if ((cell[2][1] == 1 && cell[2][2] == 1 && cell[2][3] == 1) || (cell[2][1] == 2 && cell[2][2] == 2 && cell[2][3] == 2)) {
            if (cell[2][0] == 0) {
                bot_choice[0] = 2;
                bot_choice[1] = 0;
                return bot_choice;
            }
        }
        if ((cell[3][1] == 1 && cell[3][2] == 1 && cell[3][3] == 1) || (cell[3][1] == 2 && cell[3][2] == 2 && cell[3][3] == 2)) {
            if (cell[3][0] == 0) {
                bot_choice[0] = 3;
                bot_choice[1] = 0;
                return bot_choice;
            }
        }
        if ((cell[0][0] == 1 && cell[1][0] == 1 && cell[2][0] == 1) || (cell[0][0] == 2 && cell[1][0] == 2 && cell[2][0] == 2)) {
            if (cell[3][0] == 0) {
                bot_choice[0] = 3;
                bot_choice[1] = 0;
                return bot_choice;
            }
        }
        if ((cell[0][1] == 1 && cell[1][1] == 1 && cell[2][1] == 1) || (cell[0][1] == 2 && cell[1][1] == 2 && cell[2][1] == 2)) {
            if (cell[3][1] == 0) {
                bot_choice[0] = 3;
                bot_choice[1] = 1;
                return bot_choice;
            }
        }
        if ((cell[0][2] == 1 && cell[1][2] == 1 && cell[2][2] == 1) || (cell[0][2] == 2 && cell[1][2] == 2 && cell[2][2] == 2)) {
            if (cell[3][2] == 0) {
                bot_choice[0] = 3;
                bot_choice[1] = 2;
                return bot_choice;
            }
        }
        if ((cell[0][3] == 1 && cell[1][3] == 1 && cell[2][3] == 1) || (cell[0][3] == 2 && cell[1][3] == 2 && cell[2][3] == 2)) {
            if (cell[3][3] == 0) {
                bot_choice[0] = 3;
                bot_choice[1] = 3;
                return bot_choice;
            }
        }
        if ((cell[3][0] == 1 && cell[2][0] == 1 && cell[1][0] == 1) || (cell[3][0] == 2 && cell[2][0] == 2 && cell[1][0] == 2)) {
            if (cell[0][0] == 0) {
                bot_choice[0] = 0;
                bot_choice[1] = 0;
                return bot_choice;
            }
        }
        if ((cell[3][1] == 1 && cell[2][1] == 1 && cell[1][1] == 1) || (cell[3][1] == 2 && cell[2][1] == 2 && cell[1][1] == 2)) {
            if (cell[0][1] == 0) {
                bot_choice[0] = 0;
                bot_choice[1] = 1;
                return bot_choice;
            }
        }
        if ((cell[3][2] == 1 && cell[2][2] == 1 && cell[1][2] == 1) || (cell[3][2] == 2 && cell[2][2] == 2 && cell[1][2] == 2)) {
            if (cell[0][2] == 0) {
                bot_choice[0] = 0;
                bot_choice[1] = 2;
                return bot_choice;
            }
        }
        if ((cell[3][3] == 1 && cell[2][3] == 1 && cell[1][3] == 1) || (cell[3][3] == 2 && cell[2][3] == 2 && cell[1][3] == 2)) {
            if (cell[0][3] == 0) {
                bot_choice[0] = 0;
                bot_choice[1] = 3;
                return bot_choice;
            }
        }
        if ((cell[3][0] == 1 && cell[2][1] == 1 && cell[1][2] == 1) || (cell[3][0] == 2 && cell[2][1] == 2 && cell[1][2] == 2)) {
            if (cell[0][3] == 0) {
                bot_choice[0] = 0;
                bot_choice[1] = 3;
                return bot_choice;
            }
        }
        if ((cell[2][1] == 1 && cell[1][2] == 1 && cell[0][3] == 1) || (cell[2][1] == 2 && cell[1][2] == 2 && cell[0][3] == 2)) {
            if (cell[3][0] == 0) {
                bot_choice[0] = 3;
                bot_choice[1] = 0;
                return bot_choice;
            }
        }
        if ((cell[0][0] == 1 && cell[1][1] == 1 && cell[2][2] == 1) || (cell[0][0] == 2 && cell[1][1] == 2 && cell[2][2] == 2)) {
            if (cell[3][3] == 0) {
                bot_choice[0] = 3;
                bot_choice[1] = 3;
                return bot_choice;
            }
        }
        if ((cell[1][1] == 1 && cell[2][2] == 1 && cell[3][3] == 1) || (cell[1][1] == 2 && cell[2][2] == 2 && cell[3][3] == 2)) {
            if (cell[0][0] == 0) {
                bot_choice[0] = 0;
                bot_choice[1] = 0;
                return bot_choice;
            }
        }
        if ((cell[0][0] == 1 && cell[0][1] == 1 && cell[0][3] == 1) || (cell[0][0] == 2 && cell[0][1] == 2 && cell[0][3] == 2)) {
            if (cell[0][2] == 0) {
                bot_choice[0] = 0;
                bot_choice[1] = 2;
                return bot_choice;
            }
        }
        if ((cell[1][0] == 1 && cell[1][1] == 1 && cell[1][3] == 1) || (cell[1][0] == 2 && cell[1][1] == 2 && cell[1][3] == 2)) {
            if (cell[1][2] == 0) {
                bot_choice[0] = 1;
                bot_choice[1] = 2;
                return bot_choice;
            }
        }
        if ((cell[2][0] == 1 && cell[2][1] == 1 && cell[2][3] == 1) || (cell[2][0] == 2 && cell[2][1] == 2 && cell[2][3] == 2)) {
            if (cell[2][2] == 0) {
                bot_choice[0] = 2;
                bot_choice[1] = 2;
                return bot_choice;
            }
        }
        if ((cell[3][0] == 1 && cell[3][1] == 1 && cell[3][3] == 1) || (cell[3][0] == 2 && cell[3][1] == 2 && cell[3][3] == 2)) {
            if (cell[3][2] == 0) {
                bot_choice[0] = 3;
                bot_choice[1] = 2;
                return bot_choice;
            }
        }
        if ((cell[0][0] == 1 && cell[1][0] == 1 && cell[3][0] == 1) || (cell[0][0] == 2 && cell[1][0] == 2 && cell[3][0] == 2)) {
            if (cell[2][0] == 0) {
                bot_choice[0] = 2;
                bot_choice[1] = 0;
                return bot_choice;
            }
        }
        if ((cell[0][1] == 1 && cell[1][1] == 1 && cell[3][1] == 1) || (cell[0][1] == 2 && cell[1][1] == 2 && cell[3][1] == 2)) {
            if (cell[2][1] == 0) {
                bot_choice[0] = 2;
                bot_choice[1] = 1;
                return bot_choice;
            }
        }
        if ((cell[0][2] == 1 && cell[1][2] == 1 && cell[3][2] == 1) || (cell[0][2] == 2 && cell[1][2] == 2 && cell[3][2] == 2)) {
            if (cell[2][2] == 0) {
                bot_choice[0] = 2;
                bot_choice[1] = 2;
                return bot_choice;
            }
        }
        if ((cell[0][3] == 1 && cell[1][3] == 1 && cell[3][3] == 1) || (cell[0][3] == 2 && cell[1][3] == 2 && cell[3][3] == 2)) {
            if (cell[2][3] == 0) {
                bot_choice[0] = 2;
                bot_choice[1] = 3;
                return bot_choice;
            }
        }
        if ((cell[0][0] == 1 && cell[2][0] == 1 && cell[3][0] == 1) || (cell[0][0] == 2 && cell[2][0] == 2 && cell[3][0] == 2)) {
            if (cell[1][0] == 0) {
                bot_choice[0] = 1;
                bot_choice[1] = 0;
                return bot_choice;
            }
        }
        if ((cell[0][1] == 1 && cell[2][1] == 1 && cell[3][1] == 1) || (cell[0][1] == 2 && cell[2][1] == 2 && cell[3][1] == 2)) {
            if (cell[1][1] == 0) {
                bot_choice[0] = 1;
                bot_choice[1] = 1;
                return bot_choice;
            }
        }
        if ((cell[0][2] == 1 && cell[2][2] == 1 && cell[3][2] == 1) || (cell[0][2] == 2 && cell[2][2] == 2 && cell[3][2] == 2)) {
            if (cell[1][2] == 0) {
                bot_choice[0] = 1;
                bot_choice[1] = 2;
                return bot_choice;
            }
        }
        if ((cell[0][3] == 1 && cell[2][3] == 1 && cell[3][3] == 1) || (cell[0][3] == 2 && cell[2][3] == 2 && cell[3][3] == 2)) {
            if (cell[1][3] == 0) {
                bot_choice[0] = 1;
                bot_choice[1] = 3;
                return bot_choice;
            }
        }
        if ((cell[0][0] == 1 && cell[0][2] == 1 && cell[0][3] == 1) || (cell[0][0] == 2 && cell[0][2] == 2 && cell[0][3] == 2)) {
            if (cell[0][1] == 0) {
                bot_choice[0] = 0;
                bot_choice[1] = 1;
                return bot_choice;
            }
        }
        if ((cell[1][0] == 1 && cell[1][2] == 1 && cell[1][3] == 1) || (cell[1][0] == 2 && cell[1][2] == 2 && cell[1][3] == 2)) {
            if (cell[1][1] == 0) {
                bot_choice[0] = 1;
                bot_choice[1] = 1;
                return bot_choice;
            }
        }
        if ((cell[2][0] == 1 && cell[2][2] == 1 && cell[2][3] == 1) || (cell[2][0] == 2 && cell[2][2] == 2 && cell[2][3] == 2)) {
            if (cell[2][1] == 0) {
                bot_choice[0] = 2;
                bot_choice[1] = 1;
                return bot_choice;
            }
        }
        if ((cell[3][0] == 1 && cell[3][2] == 1 && cell[3][3] == 1) || (cell[3][0] == 2 && cell[3][2] == 2 && cell[3][3] == 2)) {
            if (cell[3][1] == 0) {
                bot_choice[0] = 3;
                bot_choice[1] = 1;
                return bot_choice;
            }
        }
        if ((cell[3][0] == 1 && cell[2][1] == 1 && cell[0][3] == 1) || (cell[3][0] == 2 && cell[2][1] == 2 && cell[0][3] == 2)) {
            if (cell[1][2] == 0) {
                bot_choice[0] = 1;
                bot_choice[1] = 2;
                return bot_choice;
            }
        }
        if ((cell[3][0] == 1 && cell[1][2] == 1 && cell[0][3] == 1) || (cell[3][0] == 2 && cell[1][2] == 2 && cell[0][3] == 2)) {
            if (cell[2][1] == 0) {
                bot_choice[0] = 2;
                bot_choice[1] = 1;
                return bot_choice;
            }
        }
        if ((cell[0][0] == 1 && cell[2][2] == 1 && cell[3][3] == 1) || (cell[0][0] == 2 && cell[2][2] == 2 && cell[3][3] == 2)) {
            if (cell[1][1] == 0) {
                bot_choice[0] = 1;
                bot_choice[1] = 1;
                return bot_choice;
            }
        }
        if ((cell[0][0] == 1 && cell[1][1] == 1 && cell[3][3] == 1) || (cell[0][0] == 2 && cell[1][1] == 2 && cell[3][3] == 2)) {
            if (cell[2][2] == 0) {
                bot_choice[0] = 2;
                bot_choice[1] = 2;
                return bot_choice;
            }
        }
        bot_choice = RandomMark4x4(cell);
        return bot_choice;
    }

    private int[] RandomMark4x4(int[][] cell) {
        int[] bot_choice = new int[2];
        Random rand = new Random();
        int random_x = rand.nextInt(4);
        int random_y = rand.nextInt(4);
        while ((cell[random_x][random_y]) != 0) {
            random_x = rand.nextInt(4);
            random_y = rand.nextInt(4);
        }
        bot_choice[0] = random_x;
        bot_choice[1] = random_y;
        return bot_choice;
    }

}
