class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, res);
        return res;
    }
    private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> res){
        // Base Case
        if(i >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        // Include
        subset.add(nums[i]);
        dfs(nums, i+1, subset, res);
        // Skip all duplicates
        while(i < nums.length-1 && nums[i] == nums[i+1]){
            i++;
        }
        // Exclude
        subset.remove(subset.size()-1);
        dfs(nums, i+1, subset, res);

    }
}
