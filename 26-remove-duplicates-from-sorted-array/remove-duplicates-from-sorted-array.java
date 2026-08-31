class Solution {
    public int removeDuplicates(int[] nums) {
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

    }
}