class Solution {
    /*          RECURSION SOLUTION
    public int change(int amount, int[] coins) {
        return helper(0, coins, amount);
    }
    private int helper(int index, int[] coins, int amount){
        // Base case
        if(amount < 0) return 0; // cannot go further down this path
        if(amount == 0) return 1; // we found 1 valid path
        // cannot go further down this path (we still have amount left to pay)
        if(index >= coins.length) return 0; 

        // we have amount to pay and choices to make

        // iterating coins array
        int ways = 0;
        for(int i = index; i< coins.length; i++){
            ways += helper(i, coins, amount - coins[i]);
        }

        return ways;
    */
    public int change(int amount, int[] coins) {
        // rows -> coins and col -> amount
        int[][] dp = new int[coins.length][amount+1];

        // Base Case
        for(int row = 0; row < coins.length; row++){
            dp[row][amount] = 1;
        }


        for(int i = coins.length-1; i >= 0; i--){
            for(int j = amount-1; j >= 0; j--){
                // yet to fill in with code
                int pick = 0;
                if(j+coins[i] <= amount){
                    pick = dp[i][j+coins[i]];
                }
                if(i == coins.length-1){
                    dp[i][j] = pick; 
                }
                else{
                    dp[i][j] = dp[i+1][j] + pick;
                }
            }
        }

        return dp[0][0]; 
    }
}