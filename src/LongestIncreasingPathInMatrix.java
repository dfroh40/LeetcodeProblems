import java.util.*;
import javafx.util.Pair;

public class LongestIncreasingPathInMatrix {

    private int m, n;
    private int[][] mat;

    public int longestIncreasingPath(int[][] matrix) {
        this.mat = matrix;
        m = mat.length; n = mat[0].length;
        int longest = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                longest = Math.max(longest, getDist(i, j));
            }
        }
        return longest;
    }

    private int getDist(int x, int y){

        int count = 0;

        List<Pair<Integer, Integer>> q = new ArrayList<>();
        q.add(new Pair(x, y));

        do {
            List<Pair<Integer, Integer>> next = new ArrayList<>();
            for(Pair<Integer, Integer> v : q){
                int a = v.getKey(); int b = v.getValue();
                if(a > 0 && mat[a][b] < mat[a-1][b]) next.add(new Pair(a-1, b));
                if(a < m-1 && mat[a][b] < mat[a+1][b]) next.add(new Pair(a+1, b));
                if(b > 0 && mat[a][b] < mat[a][b-1]) next.add(new Pair(a, b-1));
                if(b < n-1 && mat[a][b] < mat[a][b+1]) next.add(new Pair(a, b+1));
            }
            q = next;
            count++;
        } while(!q.isEmpty());
        return count;
    }
}
