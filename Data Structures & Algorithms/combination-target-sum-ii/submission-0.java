class Solution { 
    /*
        when we choose to skip an element in the recursive step to avoid duplicates we have to skip past every copy of that value -> CORE INTIUTION
        so to skip all hte same elements we have to sort it first

    */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // candidates = [1,2,2,4,5,6,9], target = 8
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        dfs(candidates, 0, res, combination, target);
        return res;
    }
    private void dfs(int[] candidates, int i, List<List<Integer>> res, List<Integer> combination, int rem){
        // Found a combination
        if(rem == 0){
            res.add(new ArrayList<>(combination));
            return;
        }
        //Base case
        if(i >= candidates.length || rem < 0){
            return;
        }
        // Include it
        combination.add(candidates[i]);
        rem -= candidates[i];
        dfs(candidates, i + 1, res, combination, rem);
        combination.remove(combination.size()-1);
        // Exclude it until no duplicates
        while(i + 1 < candidates.length && candidates[i+1] == candidates[i]){
            i++;
        }
        rem += candidates[i];
        dfs(candidates, i + 1, res, combination, rem);

    }
}
