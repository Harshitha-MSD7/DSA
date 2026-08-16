class Solution {
    private static final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
            // 1. Iterate over the first and last columns (Left and Right edges)
        for (int r = 0; r < n; r++) {
            // Left edge: board[r][0]
            if (board[r][0] == 'O') {
                bfs1(r, 0, board, vis);
            }
            // Right edge: board[r][cols - 1]
            if (board[r][m - 1] == 'O') {
                bfs1(r, m-1, board, vis);
            }
        }

        // 2. Iterate over the first and last rows (Top and Bottom edges)
        for (int c = 0; c < m; c++) {
            // Top edge: board[0][c]
            if (board[0][c] == 'O') {
                bfs1(0, c, board, vis);
            }
            // Bottom edge: board[rows - 1][c]
            if (board[n - 1][c] == 'O') {
                bfs1(n - 1, c, board, vis);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    bfs2(i, j, board, vis);
                }
            }
        }
    }

    private void bfs2(int row, int col, char[][] board, boolean[][] vis) {
        int n = board.length;
        int m = board[0].length;
        vis[row][col] = true;
        board[row][col] = 'X';
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row,col});
        while (!q.isEmpty()) {
            int[] node = q.poll();
            for (int[] dir : directions) {
                int nr = node[0] + dir[0];
                int nc = node[1] + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == false && board[nr][nc] == 'O') {
                    q.offer(new int[]{nr, nc});
                    vis[nr][nc] = true;
                    board[nr][nc] = 'X';
                }
            }
        }
    }

    private void bfs1(int row, int col, char[][] board, boolean[][] vis) {
        int n = board.length;
        int m = board[0].length;
        vis[row][col] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row,col});
        while (!q.isEmpty()) {
            int[] node = q.poll();
            for (int[] dir : directions) {
                int nr = node[0] + dir[0];
                int nc = node[1] + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == false && board[nr][nc] == 'O') {
                    q.offer(new int[]{nr, nc});
                    vis[nr][nc] = true;
                    
                }
            }
        }
    }
}
