class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> palindrome = new ArrayList<>();
        dfs(s, 0, 0, res, palindrome);
        return res;
    }

    private void dfs(String s, int i, int j, List<List<String>> res, List<String> palindrome){
        if(i >= s.length()){
            if(i==j){
                res.add(new ArrayList<>(palindrome));
            }
            return;
        }
        if (j >= s.length()) {
            return;
        }
        // if the current string is palindrome cut it here!
        if(isPalindrome(s, i, j)){
            palindrome.add(s.substring(i, j+1));
            dfs(s, j+1, j+1, res, palindrome);
            palindrome.remove(palindrome.size()-1);
        }

        dfs(s, i, j+1, res, palindrome);

    }

    // O(N)
    private boolean isPalindrome(String s, int l, int r){
        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
