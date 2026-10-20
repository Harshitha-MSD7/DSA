class Solution {
    // 0 -> water
    // 1 -> land
    private static final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int max_area = 0;

        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(grid[i][j] == 1){
                    max_area = Math.max(max_area, bfs(grid, i, j));
                }
            }
        }

        return max_area;
    }

    private int bfs(int[][] grid, int r, int c){
        int area = 0;
        // inside the queue [row, col]
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        area++;
        grid[r][c] = 0;

        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];

            for(int[] dir : directions){
                int nr = dir[0] + row;
                int nc = dir[1] + col;
                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1){
                    // visited
                    grid[nr][nc] = 0;
                    area++;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return area;
    }
}
