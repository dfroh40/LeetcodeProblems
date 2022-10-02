import java.util.*;

public class CriticalConnectionsInNetwork {

    private static int n;
    private static int timer;
    private static ArrayList[] adj;
    private static int[] disc, low;
    private static boolean[] inStack;
    private static List<List<Integer>> bridges;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        this.n = n;
        adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        for(List<Integer> edge : connections){
            int v1 = edge.get(0);
            int v2 = edge.get(1);
            adj[v1].add(v2);
            adj[v2].add(v1);
        }

        disc = new int[n];
        low = new int[n];
        inStack = new boolean[n];
        bridges = new ArrayList<>();
        timer = 0;

        dfs(-1, 0);

        return bridges;
    }

    private static void dfs(int parent, int curr){
        inStack[curr] = true;
        disc[curr] = low[curr] = timer++;
        List<Integer> edges = adj[curr];
        for(int node : edges){
            if(node == parent) continue;
            if(!inStack[node]){
                dfs(curr, node);
                low[curr] = Math.min(low[curr], low[node]);
                if(disc[curr] < low[node]) bridges.add(Arrays.asList(curr, node));

            } else {
                low[curr] = Math.min(low[curr], disc[node]);
            }
        }
    }
}
