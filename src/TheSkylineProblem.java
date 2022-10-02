import java.util.*;

public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int[] layout = new int[Integer.MAX_VALUE];
        for(int[] building : buildings){
            int l = building[0];
            int r = building[1];
            int h = building[2];
            for(int i = l; i < r-1; i++) layout[i] = Math.max(layout[i], h);
        }
        List<List<Integer>> res = new ArrayList<>();
        int curr = 0;
        for(int i = 0; i < layout.length; i++){
            if(layout[i] != curr){
                List<Integer> coord = new ArrayList<>(2);
                coord.add(i);
                coord.add(layout[i]);
                res.add(coord);
                curr = layout[i];
            }
        }
        return res;
    }
}
