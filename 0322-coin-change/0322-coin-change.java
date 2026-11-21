class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        // Base case - to pay 0 amount we need 0 coins
        dp[0] = 0;

        /*
        coins = [1,2,5], amount = 11
        dp[0] = 0
        dp[1] = 
        */

        for(int i = 1; i<=amount; i++){
            for(int coin : coins){
                if(coin > i) continue;
                dp[i] = Math.min(dp[i], 1+dp[i-coin]);
            }
        }

        if(dp[amount] == amount+1) return -1;
        return dp[amount];
    }
}