class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        dfs(nums, 0, combination, res, target);
        return res;
    }
    private void dfs(int[] nums, int i, List<Integer> combination, List<List<Integer>> res, int rem){
        /*
            2 cases for backtracking
                -> if i goes beyond the length of nums
                -> if rem < 0
        */

        if(i >= nums.length){
            return;
        }
        if(rem < 0){
            return;
        }
        else if(rem == 0){
            res.add(new ArrayList<>(combination));
            return;
        }

        // rem > 0 (scope to add elements)
        /* 1. keep adding the same element again and again (no i increment)
           2. if case 1 is fails, increment i and add hte next element 
        */
        combination.add(nums[i]);
        rem -= nums[i];
        dfs(nums, i, combination, res, rem);
        // undoing
        combination.remove(combination.size()-1);
        rem += nums[i];
        dfs(nums, i+1, combination, res, rem);

    }
}
