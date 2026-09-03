class Solution {
    public int missingNumber(int[] nums) {

        for(int i = 0; i<=nums.length; i++){
            boolean contains = false; 
            for(int num : nums){
                if(i == num){
                    contains = true;
                }
            }
            if(!contains){
                return i;
            }
        }

        return -1;
    }
}