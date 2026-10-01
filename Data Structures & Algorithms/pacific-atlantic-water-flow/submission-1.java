class Solution {
    private static final int[][] directions = {{0,1}, {1,0}, {0,-1},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        
        Deque<int[]> qPacific = new LinkedList<>();
        Deque<int[]> qAtlantic = new LinkedList<>();

        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        // Populating both queues for miltisource bfs
        for(int i = 0; i<col; i++){
            pacific[0][i] = true;
            qPacific.offer(new int[]{0,i});
            atlantic[row - 1][i] = true;
            qAtlantic.offer(new int[]{row-1,i});
        }
        for(int j = 0; j< row; j++){
            pacific[j][0] = true;
            qPacific.offer(new int[]{j,0});
            atlantic[j][col-1] = true;
            qAtlantic.offer(new int[]{j,col-1});
        }

        // Call bfs on both the queues seperately and put the necessary positions in the Set
        bfs(heights, pacific, qPacific, row, col);
        bfs(heights, atlantic, qAtlantic, row, col);

        List<List<Integer>> res = new ArrayList<>();
        // Traverse the grid
        for(int k = 0; k<row; k++){
            for(int l = 0; l<col; l++){
                if(pacific[k][l] && atlantic[k][l]){
                    res.add(Arrays.asList(k, l));
                }
            }
        }

        return res;

    }
    private void bfs(int[][] heights, boolean[][] visited, Deque<int[]> queue, int row, int col) {
    while(!queue.isEmpty()){
        int[] cur = queue.poll();
        int r = cur[0];
        int c = cur[1];

        for(int[] dir : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];
            
            // Check boundaries, reverse flow condition, and generic 'visited' array
            if(nr >= 0 && nr < row && nc >= 0 && nc < col && heights[nr][nc] >= heights[r][c] && !visited[nr][nc]){
                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc}); // Add to the generic 'queue'
            }
        }
    } 
}
}
