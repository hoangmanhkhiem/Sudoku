package V1.Model;


import java.util.Random;

public class Game {
    private Node[][] board_game;
    private final int[][] answer = {
            {3, 1, 6, 5, 7, 8, 4, 9, 2},
            {5, 2, 9, 1, 3, 4, 7, 6, 8},
            {4, 8, 7, 6, 2, 9, 5, 3, 1},
            {2, 6, 3, 4, 1, 5, 9, 8, 7},
            {9, 7, 4, 8, 6, 3, 1, 2, 5},
            {8, 5, 1, 7, 9, 2, 6, 4, 3},
            {1, 3, 8, 9, 4, 7, 2, 5, 6},
            {6, 9, 2, 3, 5, 1, 8, 7, 4},
            {7, 4, 5, 2, 8, 6, 3, 1, 9}
    };

//            3 1 6 5 7 8 4 9 2
//            5 2 9 1 3 4 7 6 8
//            4 8 7 6 2 9 5 3 1
//            2 6 3 4 1 5 9 8 7
//            9 7 4 8 6 3 1 2 5
//            8 5 1 7 9 2 6 4 3
//            1 3 8 9 4 7 2 5 6
//            6 9 2 3 5 1 8 7 4
//            7 4 5 2 8 6 3 1 9
    private boolean[][] isConst = new boolean[9][9];
    private boolean[][] isCorrect = new boolean[9][9];

    public Game() {
        board_game = new Node[9][9];
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(random.nextBoolean()){
                    board_game[i][j] = new Node(answer[i][j]);
                    isConst[i][j] = true;
                    isCorrect[i][j] = true;
                } else {
                    board_game[i][j] = new Node(0);
                    isConst[i][j] = false;
                    isCorrect[i][j] = false;
                }
            }
        }
    }

    public boolean checkInput(int row, int col){
        return isConst[row][col];
    }

    public boolean checkRow(int row, int value){
        for (int i = 0; i < 9; i++) {
            if (board_game[row][i].getValue() == value) {
                return false;
            }
        }
        return true;
    }

    public boolean checkCol(int col, int value){
        for (int i = 0; i < 9; i++) {
            if (board_game[i][col].getValue() == value) {
                return false;
            }
        }
        return true;
    }

    public boolean checkSquare(int row, int col, int value){
        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board_game[i][j].getValue() == value) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkValue(int row, int col, int value){
        return checkRow(row, value) && checkCol(col, value) && checkSquare(row, col, value);
    }

    public boolean checkWin(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board_game[i][j].getValue() != answer[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setValue(int row, int col, int value){
        board_game[row][col].setValue(value);
    }

    public Node[][] getBoard_game() {
        return board_game;
    }

    public void cheating() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                    board_game[i][j] = new Node(answer[i][j]);
                    isConst[i][j] = true;
                    isCorrect[i][j] = true;
            }
        }
    }


}
