import java.util.*;
import javafx.util.Pair;

public class TrappingRainWater {
    public int trap(int[] height) {

        int sum = 0;
        int n = height.length;
        if(n == 1) return 0;

        PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>(height.length,
                (Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) -> (o2.getValue() - o1.getValue()));
        for(int i = 0; i < height.length; i++){
            Pair<Integer, Integer> p = new Pair<>(i, height[i]);
            q.add(p);
        }

        Pair<Integer, Integer> p = q.poll();
        int indL = p.getKey();
        int indR = indL;
        while(indL != 0 || indR != n-1){
            p = q.poll();
            int currInd = p.getKey();
            if(currInd > indL && currInd < indR) continue;
            int currMax = p.getValue();
            if(currInd < indL){
                for(int i = currInd+1; i < indL; i++) sum += (currMax - height[i]);
                indL = currInd;
            } else {
                for(int i = currInd-1; i > indR; i--) sum += (currMax - height[i]);
                indR = currInd;
            }
        }

        return sum;
    }
}
