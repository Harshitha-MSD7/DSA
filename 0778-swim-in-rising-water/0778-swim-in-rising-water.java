class Solution {
    private final int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}}; 
    public int swimInWater(int[][] grid) {

        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        return dijkstra(grid, visited, n);
    }
    /*
        Your min-heap should be ordered by the maximum elevation required so far to reach the current cell.
    */
    private int dijkstra(int[][] grid, boolean[][] visited, int n){
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        // [row, col, max]
        q.offer(new int[]{0,0,grid[0][0]});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            visited[r][c] = true;
            // cur[2] -> max elevation seen so far
            int max_elevation = cur[2];
            if(r == (n-1) && c == (n-1)){
                return max_elevation;
            }

            for(int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]){
                    int new_elevation = Math.max(max_elevation, grid[nr][nc]);
                    q.offer(new int[]{nr, nc, new_elevation});
                }
            }
        }

        return -1;

    }
}