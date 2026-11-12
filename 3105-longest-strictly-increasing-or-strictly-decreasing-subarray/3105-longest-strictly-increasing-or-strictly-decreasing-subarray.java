class Solution {
    // 3 2 1
    public int longestMonotonicSubarray(int[] nums) {

        // Edge Case

        if(nums.length == 0 || nums == null){
            return 0;
        }

        // Variable initializations
        int inc = 1;
        int dec = 1;
        int max = 1;

        for(int i = 0; i < (nums.length-1); i++){
            // increasing
            if(nums[i] < nums[i+1]){
                // increment the increasing streak
                inc++;
                // Max check
                max = Math.max(inc, max);
                // // reset if there was an decreasing streak prior
                dec = 1;
            }
            // decreasing
            else if(nums[i] > nums[i+1]){
                // increment the decreasing streak
                dec++;
                // Max check
                max = Math.max(dec, max);
                // reset if there was an increasing streak prior
                inc = 1;
            }
            else{
                inc = 1;
                dec = 1;
            }
        }
        // returning max
        return max;
    }
}