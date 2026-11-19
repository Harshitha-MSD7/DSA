class Solution {
    /*
    Graphs traaversal on Grid pattern

    0 - land
    1 - water

    island - conected component of 0s
    closed island - connected 0s not touching grid edges

    return : # of closed islands
    */
    private final int[][] directions = {{1,0},{-1,0},{0,-1},{0,1}};
    public int closedIsland(int[][] grid) {
        int closedIslands = 0;

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 0){ 
                    boolean isClosedIsland = bfs(grid, i, j);
                    if(isClosedIsland) closedIslands++;
                }
            }
        }

        return closedIslands;
    }

    private boolean bfs(int[][] grid, int row, int col){
        // int[]  -> {row, col}
        boolean isClosed = true;
        Queue<int[]> q = new LinkedList<>();
        grid[row][col] = 1;
        q.offer(new int[]{row,col});

        while(! q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            // boundary check
            if(r == 0 || r == grid.length-1 || c == 0 || c == grid[0].length-1) isClosed = false;

            for(int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 0){
                    grid[nr][nc] = 1;
                    q.offer(new int[]{nr, nc});
                }
            }

        }

        return isClosed;
    }
}