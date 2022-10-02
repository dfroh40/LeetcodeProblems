import java.math.BigInteger;
import java.util.*;
import javafx.util.Pair;

class MaxPerformanceOfTeam {

    private final long MOD = 1000000007;

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        // Make sorted list of efficiencies, with pair being used to keep track of indices into speed array
        // Starting from most efficient to least grab that value
        // Add it's speed to minheap/running total and when hits size k+1 remove min val from heap and subtract from sum
        // Multiply sum times efficiency of current one, and update if greater than running max
        List<Pair<Integer, Integer>> indEff = new ArrayList<>();
        for(int i = 0; i < n; i++) indEff.add(new Pair<Integer, Integer>(i, efficiency[i]));
        Collections.sort(indEff, Collections.reverseOrder(new PairComparator()));

        long max = 0;
        long sum = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(k);

        for(Pair<Integer, Integer> p : indEff) {
            int ind = p.getKey();
            int eff = p.getValue();

            if(q.size() >= k) sum -= q.poll();
            sum += speed[ind];
            q.add(speed[ind]);
            max = Math.max(max, sum * eff);
        }

        return (int) (max % MOD);
    }

    private class PairComparator implements Comparator<Pair<Integer, Integer>> {

        @Override
        public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
            return Integer.compare(o1.getValue(), o2.getValue());
        }
    }
}