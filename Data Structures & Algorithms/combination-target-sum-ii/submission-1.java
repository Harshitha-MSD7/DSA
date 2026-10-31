class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        dfs(candidates, 0, res, combination, target);
        return res;  
    }
    private void dfs(int[] candidates, int i, List<List<Integer>> res, List<Integer> combination, int rem){
        if (rem == 0) {                       // ✅ exact hit → save a copy
            res.add(new ArrayList<>(combination));
            return;
        }

        for(int j = i; j < candidates.length; j++){
            if(j > i && candidates[j] == candidates[j-1]) continue;
            if(rem - candidates[j] < 0) break;

            combination.add(candidates[j]);
            dfs(candidates, j+1, res, combination, rem-candidates[j]);
            combination.remove(combination.size() - 1);   
        }
    }
}
