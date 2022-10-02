import java.util.*;

public class WordLadderII {

    // Need to redo with backtracking - had idea with keeping track of count length but gave up
    // because was busy with other matters and used deep copy instead.
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // Build list to be returned
        List<List<String>> res = new ArrayList<>();

        // Check trivial start cases
        if(beginWord.equals(endWord)) return res;

        Set<String> check = new HashSet<>();
        check.addAll(wordList);
        if(!check.contains(endWord)) return res;

        // Convert wordList into directed graph (adj list rep)
        Map<String, List<String>> g = constructGraph(wordList, beginWord);

        // BFS setup
        List<String> start = new ArrayList<>();
        start.add(beginWord);
        res.add(start);

        Set<String> visited = new HashSet<>();
        Set<String> curr = new HashSet<>();
        curr.add(beginWord);

        // BFS
        while(!curr.isEmpty() && !curr.contains(endWord)){
            visited.addAll(curr);
            List<List<String>> tmp = new ArrayList<>();
            Set<String> n = new HashSet<>();
            for(List<String> lst : res){
                int size = lst.size();
                List<String> next = g.get(lst.get(size-1));
                for(String w : next){
                    if(visited.contains(w)) continue;
                    n.add(w);
                    List<String> c = deepCopy(lst);
                    c.add(w);
                    tmp.add(c);
                }
            }
            res = tmp;
            curr = n;
        }

        // Remove list that do not end with end word
        List<List<String>> tmp = new ArrayList<>();
        for(List<String> lst : res){
            int size = lst.size();
            if(lst.get(size-1).equals(endWord)) tmp.add(lst);
        }
        res = tmp;

        return res;
    }

    private boolean checkAdj(String a, String b){
        // Do not need to check if have same length b/c constraints, and want to
        // reject self-adjacency so do not get caught in self-referential loop
        if(a.equals(b)) return false;

        // Then check that only off by one letter
        boolean firstDiff = true;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                if(firstDiff) firstDiff = false;
                else return false;
            }
        }
        return true;
    }

    private Map<String, List<String>> constructGraph(List<String> words, String word){
        // Adjacency list builder, where iterate through words and add all that are adjacent
        Map<String, List<String>> m = new HashMap<>();
        // Add beginWord so have adj list for it, but screen so that only start of seq
        words.add(word);
        for(String w1 : words){
            m.put(w1, new ArrayList<String>());
            for(String w2 : words){
                if(!w2.equals(word) && checkAdj(w1, w2)) m.get(w1).add(w2);
            }
        }
        return m;
    }

    private List<String> deepCopy(List<String> original){
        List<String> copy = new ArrayList<>();
        for(String w : original) copy.add(w);
        return copy;
    }
}
