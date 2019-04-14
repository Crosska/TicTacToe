package com.cms.tictactoe;

public class ZLogicCalculation3x3 extends Game3x3Activity {

    public int LogicCheck(int[][] cell) {
        if ((cell[0][0] == 1 && cell[0][1] == 1 && cell[0][2] == 1) ||
                (cell[1][0] == 1 && cell[1][1] == 1 && cell[1][2] == 1) ||
                (cell[2][0] == 1 && cell[2][1] == 1 && cell[2][2] == 1) ||
                (cell[0][0] == 1 && cell[1][0] == 1 && cell[2][0] == 1) ||
                (cell[0][1] == 1 && cell[1][1] == 1 && cell[2][1] == 1) ||
                (cell[0][2] == 1 && cell[1][2] == 1 && cell[2][2] == 1) ||
                (cell[0][0] == 1 && cell[1][1] == 1 && cell[2][2] == 1) ||
                (cell[2][0] == 1 && cell[1][1] == 1 && cell[0][2] == 1)) {
            return 1;
        } else if ((cell[0][0] == 2 && cell[0][1] == 2 && cell[0][2] == 2) ||
                (cell[1][0] == 2 && cell[1][1] == 2 && cell[1][2] == 2) ||
                (cell[2][0] == 2 && cell[2][1] == 2 && cell[2][2] == 2) ||
                (cell[0][0] == 2 && cell[1][0] == 2 && cell[2][0] == 2) ||
                (cell[0][1] == 2 && cell[1][1] == 2 && cell[2][1] == 2) ||
                (cell[0][2] == 2 && cell[1][2] == 2 && cell[2][2] == 2) ||
                (cell[0][0] == 2 && cell[1][1] == 2 && cell[2][2] == 2) ||
                (cell[2][0] == 2 && cell[1][1] == 2 && cell[0][2] == 2)) {
            return 2;
        } else if (cell[0][0] != 0 && cell[0][1] != 0 && cell[0][2] != 0 &&
                cell[1][0] != 0 && cell[1][1] != 0 && cell[1][2] != 0 &&
                cell[2][0] != 0 && cell[2][1] != 0 && cell[2][2] != 0) {
            return 0;
        }
        return -1;
    }
}
