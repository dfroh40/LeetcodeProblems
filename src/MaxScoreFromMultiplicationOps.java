public class MaxScoreFromMultiplicationOps {

    private static int[][][] memo;
    private static boolean[][][] vis;
    private static int[] nums, mult;
    private static int n, m;

    public int maximumScore(int[] nums, int[] multipliers) {
        this.nums = nums;
        this.mult = multipliers;
        n = nums.length;
        m = multipliers.length;
        memo = new int[m][n][n];
        vis = new boolean[m][n][n];
        return helper(0, n-1, 0);
    }

    private int helper(int head, int tail, int curr){
        if(vis[curr][head][tail]) return memo[curr][head][tail];
        int val;
        if(curr == m-1) val = Math.max(nums[head] * mult[curr], nums[tail] * mult[curr]);
        else val = Math.max(nums[head] * mult[curr] + helper(head+1, tail, curr+1),
                nums[tail] * mult[curr] + helper(head, tail-1, curr+1));
        memo[curr][head][tail] = val;
        vis[curr][head][tail] = true;
        return memo[curr][head][tail];
    }
}
