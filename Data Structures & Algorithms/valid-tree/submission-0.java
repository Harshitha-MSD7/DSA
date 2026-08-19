class Solution {
    public boolean validTree(int n, int[][] edges) {
        // True - No cycles && connected
        // False - Cycle && dis-connected

        /*
                Complexity
                Time:  O(E + V)
                Space: O(E + V)
        */
        if (edges.length != n - 1) return false;
        boolean[] vis = new boolean[n];
        // adj List
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // Populate adj List
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // # of connected component

        int res = bfs(adj, vis, 0);

        return(res == n);
            
    }

    // dfs
    private int bfs(List<List<Integer>> adj, boolean[] vis, int start) {
        int res = 1;
        Queue<int[]> q = new LinkedList<>();
        vis[start] = true;
        q.offer(new int[]{start,-1});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int parent = curr[1];

            for (int neighbor : adj.get(node)) {
                if (!vis[neighbor]) {
                    res++;
                    vis[neighbor] = true;
                    q.offer(new int[] {neighbor, node});
                } else if (neighbor != parent) {
                    return -1;
                }
            }
        }
        return res;
    }
}
