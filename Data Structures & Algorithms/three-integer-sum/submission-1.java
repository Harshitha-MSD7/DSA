class Solution {
    /*
    nums = [-1,0,1,2,-1,-4]
         = [-4,-1,-1,0,1,2]
    */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // O(n logn)
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i<nums.length; i++){
            // if we are not at the first element and if this is not the same number we saw the last time
            if(i>0 && nums[i-1] == nums[i]){
                continue;
            }
            int l = i+1;
            int r = nums.length-1;
            // *CAN NOT USE SAME L MORE THAN ONCE*
            while(l<r){
                // checking i != l and l is not the same as prev l
                if(nums[i] == nums[l] && (l>i+1 && nums[l-1] == nums[l])) {
                    l++;
                    continue;
                }
                // core logic
                if(nums[i] + nums[l]+ nums[r] > 0){
                    r--;
                    continue;
                }
                else if (nums[i] + nums[l]+ nums[r] < 0){
                    l++;
                    continue;
                }
                // if =
                else{
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[l]);
                    triplet.add(nums[r]);
                    res.add(triplet); 
                    l++;
                }

            }
        }

        return res;
    }
}
