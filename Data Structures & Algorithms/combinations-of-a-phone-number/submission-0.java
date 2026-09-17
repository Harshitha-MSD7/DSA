class Solution {
    private List<String> res = new ArrayList<>();
    private String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        
        if (digits.isEmpty()) return res;
        dfs(0, "", digits);
        return res;

    }

    private void dfs(int i, String Cur, String digits){
        // Base Case
        if(Cur.length() == digits.length()){
            res.add(Cur);
            return;
        }

        // Recursive case
        // 23
        String get = map[digits.charAt(i) - '0'];
        for(char c : get.toCharArray()){
            dfs(i+1, Cur + c, digits);
        }
    }
}
