public class MinimumNumberRefuelingStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int N = stations.length;
        long[] memo = new long[N + 1];
        memo[0] = startFuel;
        for (int i = 0; i < N; ++i)
            for (int t = i; t >= 0; --t)
                if (memo[t] >= stations[i][0])
                    memo[t+1] = Math.max(memo[t+1], memo[t] + (long) stations[i][1]);

        for (int i = 0; i <= N; ++i)
            if (memo[i] >= target) return i;
        return -1;
    }
}
