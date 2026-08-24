class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            // If our running sum is negative, it's hurting our total, 
            // so we throw it away and start a new window.
            if (sum < 0) {
                sum = 0;
            }
            
            // Add the current number to the running sum
            sum += nums[i];
            
            // Update the maximum sum found so far
            max = Math.max(max, sum);
        }
        
        return max;
    }
}