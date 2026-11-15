/*      RECURSION
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(0, s, wordDict);
    }
    private boolean helper(int i, String s, List<String> wordDict) {
        // Base Case
        if (i == s.length()) {
            return true;
        }

        for (String word : wordDict) {
            if(i + word.length() <= s.length()){
                String substring = s.substring(i, i + word.length());
                if (substring.equals(word) ) {
                    if(helper(i + word.length(), s, wordDict)) return true;
                }
            }
        }
        return false;
    }
}
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // memo[i] -> Starting from index i to the end of string s, are we able to segment it successfully using the dictionary? - BOTTOM UP APPROACH MEMOIZATION
        boolean[] memo = new boolean[s.length()];
        return helper(0, s, wordDict, memo);
    }
    private boolean helper(int i, String s, List<String> wordDict, boolean[] memo) {
        // Base Case
        if (i == s.length()) {
            return true;
        }
        if(!memo[i]){
            for (String word : wordDict) {
                if(i + word.length() <= s.length()){
                    String substring = s.substring(i, i + word.length());
                    if (substring.equals(word) ) {
                        if(helper(i + word.length(), s, wordDict, memo)) 
                            return memo[i] = true;
                    }
                }
            }
        }
        return memo[i] == false;
    }
}