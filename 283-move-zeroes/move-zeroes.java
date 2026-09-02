class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;

        // Gives us a valid j to use
        for(int j = 0; j<nums.length; j++){
            // Gives us a valid j to use
            if(nums[j] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }      

    }
}