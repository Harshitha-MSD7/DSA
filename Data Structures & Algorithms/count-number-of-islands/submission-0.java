class Solution {
    public int numIslands(char[][] grid) {
        // bfs
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        int islands = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && (grid[i][j] == '1')) {
                    islands++;
                    bfs(i, j, vis, grid, n, m);
                }
            }
        }
        return islands;
    }

    public void bfs(int i, int j, boolean[][] vis, char[][] grid, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        vis[i][j] = true;
        q.add(new int[] {i, j});

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];

            if (row >= 0 && row < n && col - 1 >= 0 && col - 1 < m && !vis[row][col - 1]
                && grid[row][col - 1] == '1') {
                vis[row][col - 1] = true;
                q.add(new int[] {row, col - 1});
            }
            if (row >= 0 && row < n && col + 1 >= 0 && col + 1 < m && !vis[row][col + 1]
                && grid[row][col + 1] == '1') {
                vis[row][col + 1] = true;
                q.add(new int[] {row, col + 1});
            }
            if (row - 1 >= 0 && row - 1 < n && col >= 0 && col < m && !vis[row - 1][col]
                && grid[row - 1][col] == '1') {
                vis[row - 1][col] = true;
                q.add(new int[] {row - 1, col});
            }
            if (row + 1 >= 0 && row + 1 < n && col >= 0 && col < m && !vis[row + 1][col]
                && grid[row + 1][col] == '1') {
                vis[row + 1][col] = true;
                q.add(new int[] {row + 1, col});
            }
        }
    }
}
