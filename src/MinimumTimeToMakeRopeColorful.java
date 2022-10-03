public class MinimumTimeToMakeRopeColorful {
    public int minCost(String colors, int[] neededTime) {
        int total = 0;
        int start = 0, end = 0;
        while(start < colors.length() && end < colors.length()){
            int max = neededTime[start];
            while(end < colors.length() && colors.charAt(start) == colors.charAt(end)){
                total += neededTime[end];
                max = Math.max(max, neededTime[end]);
                end++;
            }
            total -= max;
            start = end;
        }
        return total;
    }
}
