package ScoreBoard;

import java.util.Arrays;

public class ScoreBoard {
    private static class GameEntry{
        private final String name;
        private final int score;

        public GameEntry(String name, int score) {
            this.name = name;
            this.score = score;
        }
        public String getName() {
            return name;
        }
        public int getScore() {
            return score;
        }
        @Override
        public String toString() {
            return "GameEntry{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }

    private int numEntries;
    private GameEntry[] board;

    public ScoreBoard(int length) {
        this.board = new GameEntry[length];
    }

    public void add(GameEntry ge) {
    if (numEntries < board.length || ge.score > board[numEntries-1].score){
        if(numEntries < board.length) ++numEntries;
        int i = numEntries - 1;
        while (i > 0 && board[i-1].score < ge.score) {
            board[i] = board[i - 1];
            i--;
        }
        board[i] = ge;
    }
    }
    public GameEntry remove(int index) {
        if(index < 0 || index >= numEntries) throw new IndexOutOfBoundsException("out of index");

        GameEntry result = board[index];

        for (int i = index; i < numEntries - 1; i++) {
            board[i] = board[i + 1];
        }
        board[--numEntries] = null;
        return result;
    }

    @Override
    public String toString() {
        return "ScoreBoard{" +
                "numEntries=" + numEntries +
                ", board=" + Arrays.toString(board) +
                '}';
    }

    public static void main(String[] args) {
        ScoreBoard var1 = new ScoreBoard(5);
        String[] var2 = new String[]{"Rob", "Mike", "Rose", "Jill", "Jack", "Anna", "Paul", "Bob"};
        int[] var3 = new int[]{750, 1105, 590, 740, 510, 660, 720, 400};

        for(int var4 = 0; var4 < var2.length; ++var4) {
            GameEntry var5 = new GameEntry(var2[var4], var3[var4]);
            System.out.println("Adding " + var5);
            var1.add(var5);
            System.out.println(" Scoreboard: " + var1);
        }

        System.out.println("Removing score at index 3");
        var1.remove(3);
        System.out.println(var1);
        System.out.println("Removing score at index 0");
        var1.remove(0);
        System.out.println(var1);
        System.out.println("Removing score at index 1");
        var1.remove(1);
        System.out.println(var1);
        System.out.println("Removing score at index 1");
        var1.remove(1);
        System.out.println(var1);
        System.out.println("Removing score at index 0");
        var1.remove(0);
        System.out.println(var1);
    }
}
