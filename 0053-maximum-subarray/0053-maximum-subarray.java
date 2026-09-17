class Solution {
    public int maxSubArray(int[] nums) {
        // [-2,1,-3,4,-1,2,1,-5,4]
        int max = nums[0];
        int sum = nums[0];

        int j = 1;

        while(j<nums.length){
            sum = Math.max(nums[j], sum + nums[j]);
            max = Math.max(max, sum);
            j++;
        }

        return max;
    }
}