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
