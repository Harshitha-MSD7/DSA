class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
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
        bfs(adj, vis, n, 0);
        // # of connected component
        for (int j = 0; j < n; j++) {
            if (!vis[j]) {
                return false;
            }
        }

        return true;
    }

    // bfs
    private void bfs(List<List<Integer>> adj, boolean[] vis, int n, int start) {
        Queue<Integer> q = new LinkedList<>();
        vis[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int it : adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.offer(it);
                }
            }
        }
    }
}
