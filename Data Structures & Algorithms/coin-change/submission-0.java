class Solution {
    public int coinChange(int[] coins, int amount) {

        // memo[i] -> if the amount is i the min coins required to fulfil that
        int[] memo = new int[amount+1];
        Arrays.fill(memo, -1);
        int res = helper(coins, amount, memo);
        if(res == Integer.MAX_VALUE) return -1;
        return res;
    }
    private int helper(int[] coins, int amount, int[] memo) {
        if (amount == 0) return 0;
        
        if(memo[amount] == -1){
            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (amount - coin >= 0) {
                    int subRes = helper(coins, amount - coin, memo);
                    
                    // Only add 1 if the sub-problem actually found a valid solution
                    if (subRes != Integer.MAX_VALUE) {
                        res = Math.min(res, 1 + subRes);
                    }
                }
            }

            memo[amount] = res;
        }
        
        return memo[amount];
    }
}
