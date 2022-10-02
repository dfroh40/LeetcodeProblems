import java.util.*;

public class SubstringWithConcatOfAllWords {
    private String[] words;

    public List<Integer> findSubstring(String s, String[] words) {
        this.words = words;
        Set<String> w = choose(new HashSet<Integer>());
        List<Integer> z = new ArrayList<>();

        int m = s.length();
        int n = 0;
        for(int i = 0; i < words.length; i++){
            n += words[i].length();
        }

        if(m == 0 || w.isEmpty()) return z;
        for(int i = 0; i < m-n+1; i++){
            for(String x : w){
                if(s.substring(i, i+n).equals(x)) z.add(i);
            }
        }
        return z;
    }

    private Set<String> choose(Set<Integer> chosen){
        Set<String> s = new HashSet<>();
        if(chosen.size() == words.length) {
            s.add("");
            return s;
        }
        for(int i = 0; i < words.length; i++){
            if(chosen.contains(i)) continue;
            chosen.add(i);
            Set<String> curr = choose(chosen);
            for(String c : curr) s.add(c+words[i]);
            chosen.remove(i);
        }
        return s;
    }
}
