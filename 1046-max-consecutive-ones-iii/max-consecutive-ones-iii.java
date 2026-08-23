class Solution {
    public int longestOnes(int[] nums, int k) {
        // Brute Force
        // [1, ,1 , 1, 1, ,1 , 1, , 1]

        /*
        int max = 0;
        for(int i = 0; i<nums.length; i++){
            int life = k;
            int sum = 0;
            for(int j = i; j<nums.length; j++){
                if(nums[j] == 1) {
                    sum++;
                }
                else {
                    if(life == 0) break;
                    life--;
                    sum++;
                }
            }
            max = Math.max(max, sum);
        }

        return max; */


        // [1,1,1,0,0,0,1,1,1,1,0]


        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int life = k;
        while(j<nums.length){
            if(nums[j] == 0 && life > 0){
                life--;
                j++;
            }
            else if(nums[j] == 0 && life == 0){
                if(nums[i] == 0){
                    life++;
                }
                i++;
            }
            else if(nums[j] == 1){
                j++;
            }       
            max = Math.max(max, j-i);
        }
        return max;
    }
}