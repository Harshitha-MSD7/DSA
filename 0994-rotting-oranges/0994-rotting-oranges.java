class Solution {

    private final int[][] directions = {{0,1}, {0,-1}, {-1,0}, {1,0}};

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // [row, col, time]
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j,0});
                }
            }
        }

        int time = 0;

        // Basically max time gets returned
        time = bfs(grid, time, q);

        // Traversal
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return time;
    }
    private int bfs(int[][] grid, int time, Queue<int[]> q){

        int maxTime = time;

        while(! q.isEmpty()){
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            int curTime = node[2];

            for(int[] dir : directions){
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr >= 0 && nc >=0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1){
                    maxTime = curTime + 1;
                    grid[nr][nc] = 2;
                    q.offer(new int[]{nr, nc, curTime + 1});
                }
            }
        }

        return maxTime;
    } 
}