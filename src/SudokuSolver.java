import java.util.*;

public class SudokuSolver {
    private char[][] board;
    private int[] box = {0, 0, 0, 3, 3, 3, 6, 6, 6};

    public void solveSudoku(char[][] board) {
        this.board = board;
        int count = 81;
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++)
                if(board[i][j] != '.') count--;
        int place = 0;
        while(count != 0){
            int x = place % 9, y = place / 9;
            if(board[x][y] == '.') count -= guess(x, y);
            place++;
            if(place > 80) place = 0;
        }
    }

    private int guess(int x, int y){
        Set<Character> contains = new HashSet<>();
        for(int i = 0; i < 9; i++){
            char c = board[i][y];
            if(c != '.') contains.add(c);
        }
        for(int j = 0; j < 9; j++){
            char c = board[x][j];
            if(c != '.') contains.add(c);
        }
        for(int k = 0; k < 9; k++){
            int a = box[x] + (k % 3);
            int b = box[y] + (k / 3);
            char c = board[a][b];
            if(c != '.') contains.add(c);
        }
        if(contains.size() != 8) return 0;
        int curr = 45;
        for(char c : contains) curr -= ((int) c - 48);
        board[x][y] = (char) (curr + 48);
        return 1;
    }
}
