class Solution {
    public int majorityElement(int[] nums) {
        /*
        3-> 2
        2 -> 1

        O(nlogn) 
        O(1)       
        
        1 -> 3 
        [1,1,1,2,2,2,2]
        Arrays.sort(nums);
        int count = 0;
        Math.max(map.values(), max);

        count # of times last seen appears
        */
        
        int last_seen = nums[0];
        int count = 1;

        for(int i = 1; i<nums.length; i++){
            if(last_seen != nums[i]){
                if(count > 0) count--;
                else{
                    last_seen = nums[i];
                    count++;
                }
            }
            else {
                count++;
            }
        }


        return last_seen;
    }
}