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

        // if not at des - we have 2 choices to make

        // go down
        
        helper(i+1, j, m, n);

        // go right
        helper(i, j+1, m, n);
    }
}
