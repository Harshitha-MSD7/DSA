class Solution {
    /*
     nums = [1,1,1,0,0,0,1,1,1,1,0] k = 2
    
    */
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int i = 0;
        
        for(int j = 0; j<nums.length; j++){
            if(nums[j] == 0){
                // we lose life
                k--;
            }

            while(k < 0){
                if(nums[i] == 0) k++;
                i++;
            }

            max = Math.max(max, j-i+1);

        }



        return max;
    }
}