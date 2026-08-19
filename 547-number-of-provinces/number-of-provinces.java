class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int num = 0;
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {

            if (!vis[i]) {
                num++;
                bfs(isConnected, i, vis);
            }

        }

        return num;

    }

    private void bfs(int[][] isConnected, int i, boolean[] vis) {

        Queue<Integer> q = new ArrayDeque<>();
        vis[i] = true;
        q.offer(i);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int j = 0; j < isConnected[node].length; j++) {
                if (!vis[j] && isConnected[node][j] == 1) {
                    vis[j] = true;
                    q.offer(j);
                }

            }
        }
    }
}