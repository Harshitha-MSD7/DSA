class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*

        know: 
        the index I am At
        the current element 
        the req element (target - current element)

        Need:
        Index of the req element


        return the need
        
        */

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int j = 0; j<nums.length; j++){
            int req = target - nums[j];
            if(map.containsKey(req)){
                return new int[]{map.get(req), j};
            }
            map.put(nums[j], j);
        }

        return new int[]{-1,-1};

    }
}
