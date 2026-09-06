class Solution {
    public boolean canJump(int[] nums) {
        // increment i until it is less that the reach if not return false
        //  if(i + nums[i] > reach) reach = i + nums[i];
        // if nay point in time we reached the last index then return true;
        int reach = 0;

        /*
        nums=[1,2,1,0,1]
        i = 3
        reach = 3 
        */

        for(int i = 0; i<nums.length; i++){
            // Updating maximum reach
            if(i + nums[i] > reach) reach = i + nums[i];
            // if we reached the last index
            if(i == nums.length - 1) return true;
            // if we are unable to move from the current position
            if(reach <= i) return false;

        }
        return true;
    }
}
