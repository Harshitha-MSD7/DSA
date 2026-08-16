class Solution {
    private static final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}}; 
    public void islandsAndTreasure(int[][] grid) {
        // Multisource bfs -> 0 is starting point
        // queue -> {row, col, distance}

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i, j, 0});
                }
            }
        }        

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int row = cell[0];
            int col =  cell[1];

            for(int[] dir : directions){
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 2147483647){
                    q.offer(new int[]{nr, nc, cell[2] +1});
                    grid[nr][nc] = cell[2]+1;
                }
            }

        }

    }
}
