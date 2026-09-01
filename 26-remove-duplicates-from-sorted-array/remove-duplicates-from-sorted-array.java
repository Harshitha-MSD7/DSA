class Solution {
    public int removeDuplicates(int[] nums) {
        /*
        Brute Force:

        Set<Integer> set = new TreeSet<>();
        for(int num : nums){
            set.add(num);
        }
        int size = set.size();
        int index = 0;
        
        for(int i : set){
            nums[index] = i;
            index++; 
        }

        return size;
        */

        /*

        Optimal solution

        nums = [0,0,1,1,1,2,2,3,3,4]


        */
        int last_seen = 0;

        for(int i = 1; i<nums.length; i++){
            if(nums[last_seen] != nums[i]){
                last_seen++;
                nums[last_seen] = nums[i];
            }
        }
        return last_seen+1; 
    }
}