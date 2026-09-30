class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> v = new ArrayList<>();
        
        // Convert the array to a list for easier manipulation
        for (int num : candidates) {
            v.add(num);
        }
        
        // Start the recursive process
        func(v, 0, target, new ArrayList<>(), ans);
        
        return ans;
    }

    // Recursive function to find all subsequences with the given target sum
    public void func(List<Integer> v, int i, int sum, List<Integer> v2, List<List<Integer>> ans) {
        // Base case: if the sum is zero, add the current subsequence to the result
        if (sum == 0) {
            ans.add(new ArrayList<>(v2));
            return;
        }
        
        // Base case: if the sum becomes negative or no elements are left
        if (sum < 0 || i > v.size()-1) {
            return;
        }

        v2.add(v.get(i));
        
        func(v, i, sum - v.get(i), v2, ans);
        
        
        v2.remove(v2.size() - 1);
        
        
        func(v, i+1, sum, v2, ans);
        
        
        
    }

}