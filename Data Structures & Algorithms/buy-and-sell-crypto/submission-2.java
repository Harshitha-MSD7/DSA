class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0; // the max profit at each point
        int bought = prices[0]; // the minimum until where we are

        for(int i = 1; i<prices.length; i++){
            bought = Math.min(bought, prices[i]);
            profit = Math.max(profit, prices[i] - bought);
        }

        return profit;
    }
}
