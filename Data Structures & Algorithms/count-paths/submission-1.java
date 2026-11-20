/*      RECURSIVE APPROACH - TLE
class Solution {
    int res = 0;
    public int uniquePaths(int m, int n) {
        res = 0;
        helper(0,0,m,n);
        return res;
    }
    private void helper(int i, int j, int m, int n){
        // base case - if we reached the destination
        if(i == m-1 && j == n-1){
            res++;
            return;
        }

        //Boundary check
        if(i >= m || j >= n){
            return;
        }

        // if not at des -> we have 2 choices to make

        // go down
        
        helper(i+1, j, m, n);

        // go right
        helper(i, j+1, m, n);
    }
}
*/
class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] memo = new int[m][n];
        // where memo[i][j] stores the number of paths avaiable to get from here to destination
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        return helper(0,0,m,n, memo);
    }
    private int helper(int i, int j, int m, int n, int[][] memo){
        // base case - if we reached the destination
        if(i == m-1 && j == n-1){
            return 1;
        }

        //Boundary check
        if(i >= m || j >= n){
            return 0;
        }

        // if not at des -> we have 2 choices to make

        
        if(memo[i][j] == -1){
            
            memo[i][j] = helper(i+1, j, m, n, memo) + helper(i, j+1, m, n, memo);
        }
        return memo[i][j];
    }
}

