public class ConstructTargetArrayWithMultipleSums {
    public boolean isPossible(int[] target) {

        while(true){
            int max = 0;
            int maxInd = -1;
            int total = 0;
            for(int i = 0; i < target.length; i++){
                total += target[i];
                if(target[i] != 1 && target[i] == max) return false;
                if(target[i] > max){
                    total += max;
                    max = target[i];
                    total -= max;
                    maxInd = i;
                }
            }
            if(max <= 1) break;
            target[maxInd] = max - total;
        }
        for(int i = 0; i < target.length; i++) if(target[i] != 1) return false;
        return true;
    }
}
