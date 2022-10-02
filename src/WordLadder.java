import java.util.*;

public class WordLadder {
    private char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> valid = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Set<String> curr = new HashSet<>();
        curr.add(beginWord);
        int count = 1;
        while(!curr.isEmpty()){
            Set<String> next = new HashSet<>();
            for(String s : curr){
                if(s.equals(endWord)) return count;
                visited.add(s);
                for(int i = 0; i < s.length(); i++){
                    char[] c = s.toCharArray();
                    for(int j = 0; j < 26; j++){
                        c[i] = alphabet[j];
                        String newS = new String(c);
                        if(!visited.contains(newS) && valid.contains(newS))
                            next.add(newS);
                    }
                }
            }
            count++;
            curr = next;
        }
        return 0;
    }
}
