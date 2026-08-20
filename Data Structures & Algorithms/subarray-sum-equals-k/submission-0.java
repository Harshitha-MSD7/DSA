class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int prefixSum = 0;
        for(int i = 0; i<nums.length; i++){
            prefixSum += nums[i];
            int complement = prefixSum - k;
            if(map.containsKey(complement)){
                count += map.get(complement);
            }
            
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
            

        }

        return count;
    }
}