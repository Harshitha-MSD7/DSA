class Solution {
    public int countComponents(int n, int[][] edges) {
        /*
                Complexity
                Time:  O(E + V)
                Space: O(E + V)
        */

        int component = 0;
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
        for (int j = 0; j < n; j++) {
            if (!vis[j]) {
                component++;
                dfs(adj, vis, j);
            }
        }

        return component;
    }

    // dfs
    private void dfs(List<List<Integer>> adj, boolean[] vis, int start) {
        vis[start] = true;
        for (int it : adj.get(start)) {
            if (!vis[it]) {
                //vis[it] = true;
                dfs(adj, vis, it);
            }
        }
    }
}
