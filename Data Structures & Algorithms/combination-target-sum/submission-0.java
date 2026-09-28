class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, target, new ArrayList<>(), 0, nums, res);

        return res;
    }

    public void dfs(int i, int target, List<Integer> cur, int total, int nums[], List<List<Integer>> res){
        // if we found a solution
        if(total == target){
            res.add(new ArrayList<>(cur));
            return;
        }
        // base case
        if(total > target || i >= nums.length){
            return;
        }
        /*
            1. Include the int at index i 
            2. Exclude the int at index i
        */
        cur.add(nums[i]);
        dfs(i, target, cur, total+nums[i], nums, res);
        cur.remove(cur.size() - 1);
        dfs(i+1, target, cur, total, nums, res);
    }
}
