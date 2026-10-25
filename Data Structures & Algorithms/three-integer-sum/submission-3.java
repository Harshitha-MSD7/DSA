class Solution {
    /*
    nums = [-1,0,1,2,-1,-4]
         = [-4,-1,-1,0,1,2]
    */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // O(n logn)
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i<nums.length; i++){
            if (nums[i] > 0) break;
            // if we are not at the first element and if this is not the same number we saw the last time
            if(i>0 && nums[i-1] == nums[i]){
                continue;
            }
            int l = i+1;
            int r = nums.length-1;
            // *CAN NOT USE SAME L MORE THAN ONCE*
            while(l<r){
                //int sum = nums[i] + nums[l] + nums[r];
                // checking i != l and l is not the same as prev l
                /*if(nums[i] == nums[l] && (l>i+1 && nums[l-1] == nums[l])) {
                    l++;
                    continue;
                }*/
                // core logic
                int sum = nums[i] + nums[l] + nums[r];
                if(sum > 0){
                    r--;
                }
                else if (sum < 0){
                    l++;
                }
                // if =
                else{
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    // Duplicate Check
                    while(l<r && nums[l] == nums[l-1]){
                        l++;
                    }
                }            
            }
        }
        return res;
    }
}
