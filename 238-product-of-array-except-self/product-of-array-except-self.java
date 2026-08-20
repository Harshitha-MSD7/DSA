class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        for(int i = 0; i<nums.length; i++){
            if(i == 0)prefix[i] = nums[i];
            
            else prefix[i] = prefix[i-1] * nums[i];
        }
        for(int j = nums.length-1; j>=0; j--){
            if(j == nums.length-1) suffix[j] = nums[j];
            else suffix[j] = suffix[j+1] * nums[j];
        }

        for(int k = 0; k < nums.length; k++){
            if(k==0){
                res[k] = suffix[k+1];
            }
            else if(k==nums.length-1){

                res[k] = prefix[k-1];

            }
            else res[k] = prefix[k-1]*suffix[k+1];
        }

        return res;


    }
}