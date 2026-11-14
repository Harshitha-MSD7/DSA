/*
    1. RECURSION

    class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(helper(cost,0), helper(cost,1));
    }
    // i - index
    public int helper(int[] cost, int i){
        if(i >= cost.length){
            return 0;
        }

        // 2 choices to make and have to return the min of those two choices
        // At each step you pay the current step's cost and add the minimum of two possible future paths 

        return cost[i] + Math.min(helper(cost, i+1), helper(cost, i+2));

    }
}

    2. MEMOIZATION

    class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(helper(cost,0, memo), helper(cost,1, memo));
    }
   
    public int helper(int[] cost, int i, int[] memo){
        if(i >= cost.length){
            return 0;
        }

        if(memo[i] == -1)
            memo[i] = cost[i] + Math.min(helper(cost, i+1, memo), helper(cost, i+2, memo));
        
        return memo[i];

    }
}

    3. TABULATION - O(n) Space

        class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[cost.length] = 0;
        dp[cost.length-1] = cost[cost.length-1];

        for(int i = cost.length -2; i>= 0; i--){
            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        }

        return Math.min(dp[0], dp[1]);

    }
}

*/
//      2. SPACE OPTIMIZED TABULATION
class Solution {
    public int minCostClimbingStairs(int[] cost) {

        for(int i = cost.length-3; i>= 0; i--){
            cost[i] = cost[i] + Math.min(cost[i+1], cost[i+2]);
        }

        return Math.min(cost[0], cost[1]);

    }
}
