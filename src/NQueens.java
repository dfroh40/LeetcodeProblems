import java.util.*;

public class NQueens {

    private List<Integer[]> perms;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> boards = new ArrayList<>();
        if(n == 1) {
            boards.add(Arrays.asList("Q"));
            return boards;
        } else if(n == 2 || n == 3) return boards;

        perms = new ArrayList<>();
        int[] start = new int[n];

        for(int i = 0; i < n; i++) start[i] = i+1;
        heapPermutation(start, n);

        String[] prefix = new String[n];
        for(int i = 0; i < n; i++){
            String base = "";
            for(int j = 0; j < i; j++) base = base + ".";
            prefix[i] = base;
        }
        String[] suffix = new String[n];
        for(int i = 0; i < n; i++){
            String base = "";
            for(int j = 0; j < (n-i-1); j++) base = base + ".";
            suffix[i] = base;
        }

        for(Integer[] curr : perms){
            List<String> board = new ArrayList<>();
            for(int i = 0; i < n; i++){
                int ind = curr[i];
                boolean escape = false;
                for(int j = 1; i-j >= 0; j++)
                    if(Math.abs(ind - curr[i-j]) == j) escape = true;
                for(int j = 1; i+j < n; j++)
                    if(Math.abs(ind - curr[i+j]) == j) escape = true;
                if(escape) continue;
                board.add(prefix[ind-1] + "Q" + suffix[ind-1]);
            }
            if(board.size() == n) boards.add(board);
        }
        return boards;
    }

    private void heapPermutation(int[] a, int size){
        // if size becomes 1 then prints the obtained
        // permutation
        if (size == 1)
            perms.add(Arrays.stream(a).boxed().toArray( Integer[]::new ));

        for (int i = 0; i < size; i++) {
            heapPermutation(a, size - 1);

            // if size is odd, swap 0th i.e (first) and
            // (size-1)th i.e (last) element
            if (size % 2 == 1) {
                int temp = a[0];
                a[0] = a[size - 1];
                a[size - 1] = temp;
            }

            // If size is even, swap ith
            // and (size-1)th i.e last element
            else {
                int temp = a[i];
                a[i] = a[size - 1];
                a[size - 1] = temp;
            }
        }
    }
}
