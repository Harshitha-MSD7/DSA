/*          RECURSIVE APPROACH
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return helper(triangle, 0, 0, 0);
    }

    private int helper(List<List<Integer>> triangle, int index, int row, int sum){
        // Base case
        if(row >= triangle.size()){
            return sum;
        }

        // if not the base case we have 2 options to make
        sum += triangle.get(row).get(index);
        int i = helper(triangle, index, row+1, sum);
        int iPlusOne = helper(triangle, index+1, row+1, sum);

        return Math.min(i, iPlusOne);
    }
}
*/
/*     MEMOIZATION - NOT FINISHED YET 
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> memo = new ArrayList<>();
        for(List<Integer> lis : triangle){
            List<Integer> tmp = new ArrayList<>(lis.size());
            Collections.fill(tmp, -1);
            memo.add(tmp);
        }
        return helper(triangle, 0, 0, 0, memo);
    }

    private int helper(List<List<Integer>> triangle, int index, int row, int sum, List<List<Integer>> memo){
        // Base case
        if(row >= triangle.size()){
            return sum;
        }

        // if not the base case we have 2 options to make
        if(memo.get(row).get(index) == -1){
            sum += triangle.get(row).get(index);
            int i = helper(triangle, index, row+1, sum);
            int iPlusOne = helper(triangle, index+1, row+1, sum);

            memo.get(row).put(index) = Math.min(i, iPlusOne);
        }
        return memo.get(row).get(index)
    }
}
*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        // Base Case intialize the bottom row
        int j = 0;
        for(int i : triangle.get(n-1)){
            dp[n-1][j] = i;
            j++;
        }
        // min(row + 1 , i   or    row + 1, i + 1) + tiangle[row][col]
        for(int row = n-2; row >= 0; row--){
            for(int col = 0; col < triangle.get(row).size(); col++){
                dp[row][col] = Math.min(dp[row + 1][col], dp[row + 1][col + 1]) + triangle.get(row).get(col);
            }
        }

        return dp[0][0];
    }
}