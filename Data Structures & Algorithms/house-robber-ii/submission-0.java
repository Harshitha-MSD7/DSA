/*

    RECURSIVE SOLUTION

class Solution {
    public int rob(int[] nums) {
        return Math.max(helper(nums, 0, nums.length-2), helper(nums, 1, nums.length-1));
    }
    private int helper(int[] nums, int i, int end){
        // if(start > end) return 0;
        if(i > end) return 0;
        

        // 2 choices -> either rob this house or not rob

        // rob 
        int rob = nums[i] + helper(nums, i+2, end);
        // Not rob
        int notRob = helper(nums, i+1, end);

        return Math.max(rob, notRob);

    }
}

        MEMOIZATION SOLUTION
    
*/

class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int res1 = helper(nums, 0, nums.length-2, memo);
        Arrays.fill(memo, -1);
        int res2 =  helper(nums, 1, nums.length-1, memo);
        return Math.max(res1, res2);
    }
    private int helper(int[] nums, int i, int end, int[] memo){
        // if(start > end) return 0;
        if(i > end) return 0;
        
        if(memo[i] == -1){
            // 2 choices -> either rob this house or not rob

            // rob 
            int rob = nums[i] + helper(nums, i+2, end, memo);
            // Not rob
            int notRob = helper(nums, i+1, end, memo);

            memo[i] = Math.max(rob, notRob);
        }

        return memo[i];

    }
}

