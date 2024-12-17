class Solution {
    private List<List<Integer>> result; // Store critical connections
    private List<Integer>[] graph; // Adjacency list representation of the graph
    private int[] discovery; // Discovery time of each node
    private int[] low; // Lowest discovery time reachable from a node
    private int time; // Timer for discovery
    private boolean[] visited; // Visited array to track visited nodes
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
       result = new ArrayList<>();
        graph = new ArrayList[n];
        discovery = new int[n];
        low = new int[n];
        visited = new boolean[n];
        time = 0;
        
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }
        dfs(0, -1);

        return result;
    }
    private void dfs(int u, int parent) {
        visited[u] = true;
        discovery[u] = low[u] = ++time;

        for (int v : graph[u]) {
            if (v == parent) continue;

            if (!visited[v]) {
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > discovery[u]) {
                    result.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], discovery[v]);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int n1 = 4;
        List<List<Integer>> connections1 = Arrays.asList(
            Arrays.asList(0, 1),
            Arrays.asList(1, 2),
            Arrays.asList(2, 0),
            Arrays.asList(1, 3)
        );
        System.out.println(solution.criticalConnections(n1, connections1));

        // Test Case 2
        int n2 = 2;
        List<List<Integer>> connections2 = Arrays.asList(
            Arrays.asList(0, 1)
        );
        System.out.println(solution.criticalConnections(n2, connections2));
    }
}