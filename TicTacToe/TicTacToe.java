package TicTacToe;

import java.util.Arrays;

public class TicTacToe {
    private static final int X = 1;
    private static final int O = -1;
    private static final int EMPTY = 0;
    private int[][] board = new int[3][3];
    private int player;

    public TicTacToe() {
        clearBoard();
    }

    public void clearBoard(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 0;
            }
        }
        player = 1;

    }
    public boolean isWin(int mark){
        if(board[0][0] + board[0][1] + board[0][2] == mark*3) return true;
        if(board[1][0] + board[1][1] + board[1][2] == mark*3) return true;
        if(board[2][0] + board[2][1] + board[2][2] == mark*3) return true;
        if(board[0][0] + board[1][0] + board[2][0] == mark*3) return true;
        if(board[0][1] + board[1][1] + board[2][1] == mark*3) return true;
        if(board[0][2] + board[1][2] + board[2][2] == mark*3) return true;
        if(board[0][0] + board[1][1] + board[2][2] == mark*3) return true;
        return board[2][0] + board[1][1] + board[0][2] == mark * 3;
    }
    public int winner(){
        if (isWin(X)) return X;
        if(isWin(O)) return O;
        return EMPTY;
    }

    public void putMark(int x, int y) throws IllegalArgumentException{
        if(x < 0 || y < 0 || x > 2 || y > 2) throw new IllegalArgumentException("out of bound");
        if(board[x][y] != 0) throw new IllegalArgumentException("position is occupied");
        board[x][y] = player;
        player = -player;
    }

    @Override
    public String toString() {
        StringBuilder sg = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j] == X) sg.append("X");
                if(board[i][j] == O) sg.append("0");
                if(board[i][j] == EMPTY) sg.append(" ");
                sg.append(" ");
                if(j == 2) sg.append("\n-----\n");
            }
        }
        return sg.toString();
    }

    public static void main(String[] var0) {
        TicTacToe var1 = new TicTacToe();
        var1.putMark(1, 1);
        var1.putMark(0, 2);
        var1.putMark(2, 2);
        var1.putMark(0, 0);
        var1.putMark(0, 1);
        var1.putMark(2, 1);
        var1.putMark(1, 2);
        var1.putMark(1, 0);
        var1.putMark(2, 0);
        System.out.println(var1);
        int var2 = var1.winner();
        String[] var3 = new String[]{"O wins", "Tie", "X wins"};
        System.out.println(var3[1 + var2]);
    }
}
