/*      RECURSIVE SOLUTION
class Solution {
    public int lengthOfLIS(int[] nums) {
        return helper(nums, 0, -1);
    }
    private int helper(int[] nums, int i, int prev){
        // Base case
        if(i >= nums.length) return 0;  

        int include = 0;

        if(prev == -1 || nums[i] > nums[prev]){ // cannot include this 
            include = 1 + helper(nums, i+1, i);
        }
        
        // This runs anyways, even if nums[i] <= nums[prev] or prev == -1
        int exclude = helper(nums, i+1, prev);
        
        return Math.max(include, exclude);

    }
}
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        // MEMOIZATION - BOTTOM UP
        int[][] memo = new int[nums.length+1][nums.length+1];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        } 
        // memo[i][j] - from i with j as prev till the end what is the longest subsequence 
        return helper(nums, 0, -1, memo);
    }
    private int helper(int[] nums, int i, int prev, int[][] memo){
        // Base case
        int prevIdx = prev + 1;
        if(i >= nums.length) return 0;  

        if(memo[i][prevIdx] == -1){
            int include = 0;
        
            if(prev == -1 || nums[i] > nums[prev]){ // cannot include this 
                include = 1 + helper(nums, i+1, i, memo);
            }
            
            // This runs anyways, even if nums[i] <= nums[prev] or prev == -1
            int exclude = helper(nums, i+1, prev, memo);
            
            memo[i][prevIdx] = Math.max(include, exclude);
            }
        return memo[i][prevIdx];

    }
}