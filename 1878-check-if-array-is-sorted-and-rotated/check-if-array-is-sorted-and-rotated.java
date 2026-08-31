class Solution {
    public boolean check(int[] nums) {
        int life = 1;
        for(int i =0; i<nums.length; i++){
            if(nums[i] > nums[(i+1) % nums.length]){
                life--;    
            }
        }
    
        return (life >= 0);
    }
}