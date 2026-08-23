class Solution {
    public void sortColors(int[] nums) {
        // CONSTRAINS:
        // Just one pass
        // No additional data structures
        // Means that we have to leverage pointers

        int l = 0;
        int r = nums.length-1;
        int i = 0;

        while(i<=r){
            
            if(nums[i]==0){
                int tmp = nums[i];
                nums[i] = nums[l];
                nums[l] = tmp;
                l++;
                i++;
            }
            else if(nums[i]==2){
                int tmp = nums[i];
                nums[i] = nums[r];
                nums[r] = tmp; 
                r--;
            }
            else{
                i++;
            }
        }

    }
}