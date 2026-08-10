class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // store the number of occurances in a HashMap 
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length/3;
        // frequency HashMap
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for(int num : nums){
            if(map.get(num) > len){ 
                if(!res.contains(num)) res.add(num);
            }
        }

        return res;
    }
}