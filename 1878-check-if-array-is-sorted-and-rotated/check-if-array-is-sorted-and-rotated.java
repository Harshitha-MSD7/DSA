class Solution {
    public boolean check(int[] nums) {
        int life = 1;
        for(int i =0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                life--;    
            }
        }
        if(nums[nums.length-1] > nums[0]) life --;

        return (life >= 0);
    }
}