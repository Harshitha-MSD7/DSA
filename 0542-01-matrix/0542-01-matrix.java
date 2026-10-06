/*
4 directional
*/
class Solution {
    private final int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] res = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        // To start off everything is going to be filled with 0
        /*
        Multisource BFS on all 0 and everytime we see a 1 we go ahead and put the distance in that place
        Inside the BFS queue int[]{row, col dist}
        */

        Deque<int[]> q = new ArrayDeque<>();

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i, j, 0});
                    vis[i][j] = true;
                }
            }
        }

        bfs(mat, vis, res, q, n, m);

        return res;
    }

    public void bfs(int[][] mat, boolean[][] vis, int[][] res, Deque<int[]> q, int n, int m){

        while(! q.isEmpty()){
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            int dis = node[2];
            res[row][col] = dis;

            for(int[] dir : directions){
                int nr = dir[0] + row; 
                int nc = dir[1] + col;
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc, dis+1});
                }
            }
        }

    }
}