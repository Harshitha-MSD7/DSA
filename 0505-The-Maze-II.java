public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: the shortest distance for the ball to stop at the destination
     */
     // BFS Dijkstra's on Grid where each cell wwight is 1
      
    private final int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int row = maze.length;
        int col = maze[0].length;
        int[][] visited = new int[row][col];
        for(int i = 0; i< row; i++){
            for(int j = 0; j < col; j++){
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        return dijkstra(maze, visited, start, destination, row, col);
    }
    private int dijkstra(int[][] maze, int[][] visited, int[] start, int[] destination, int row, int col){
        // [row, col, weight] -> sort the heap by weight
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        q.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], dist = cur[2];
            // we do not need to explore this path further
            if (dist > visited[r][c]) continue;
            if (r == destination[0] && c == destination[1]) {
                return dist;
            }
            for(int[] dir : directions){
                int nr = r;
                int nc = c;
                int count = 0;
                // until we did not hit the wall/boundary keep rolling in hte same direction
                while(nr + dir[0] >= 0 && nr + dir[0] < row && nc + dir[1] >= 0 && nc + dir[1] < col && maze[nr + dir[0]][nc + dir[1]] == 0){
                    // update the co-ordinates
                    nr += dir[0];
                    nc += dir[1];
                    // distance travelled tracking
                    count++;
                }
                // after we hit a wall (node in graph terms)
                if(dist + count < visited[nr][nc]){
                    visited[nr][nc] = dist + count;
                    q.offer(new int[]{nr, nc, visited[nr][nc]});
                }
            }

        }
        // Unable to reach the destination
        return -1;

    }
}
