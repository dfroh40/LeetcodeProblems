public class NumberOfSubmatricesThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[][] mat = new int[m][n];
        mat[0][0] = matrix[0][0];
        for(int i = 1; i < m; i++) mat[i][0] = mat[i-1][0] + matrix[i][0];
        for(int j = 1; j < n; j++) mat[0][j] = mat[0][j-1] + matrix[0][j];
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                mat[i][j] = mat[i-1][j] + mat[i][j-1] - mat[i-1][j-1] + matrix[i][j];
            }
        }
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k <= i; k++){
                    for(int l = 0; l <= j; l++){
                        int left = (k-1 < 0) ? 0 : mat[k-1][l];
                        int up = (l-1 < 0) ? 0 : mat[k][l-1];
                        int back = (k-1 < 0 || l-1 < 0) ? 0 : mat[k-1][l-1];
                        int val = mat[i][j] - left - up + back;
                        if(val == target) count++;
                    }
                }
            }
        }
        return count;
    }
}
