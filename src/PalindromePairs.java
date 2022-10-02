import java.util.*;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words.length; j++){
                if(j == i) continue;
                if(isPalindrome(words[i] + words[j])){
                    List<Integer> p = new ArrayList<>();
                    p.add(i); p.add(j);
                    res.add(p);
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        for(int i = 0; i < (n-1-i); i++)
            if(c[i] != c[n-1-i]) return false;
        return true;
    }
}
