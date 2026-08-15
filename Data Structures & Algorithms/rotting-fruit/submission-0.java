class Solution {
    private static final int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
    // int[] -> {row, col, time}
        Queue<int[]> q = new LinkedList<>();
        int num_fruits = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j,0});

                }
                if(grid[i][j] == 1) num_fruits++;
            }

        }
        int time = 0;
        // bfs
        int rotten = 0;
        while(! q.isEmpty()){
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            time = Math.max(time, node[2]);

            for(int[] dir : direction){
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1){
                   q.offer(new int[]{nr,nc,(node[2] + 1)});
                   grid[nr][nc] = 2; 
                   rotten++;
                }
            }

        }


        if(num_fruits != rotten) return -1;
        return time;

    }
}
