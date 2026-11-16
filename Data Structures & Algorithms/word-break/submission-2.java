/*
          RECURSION

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

            MEMOIZATION

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // memo[i] -> Starting from index i to the end of string s, are we able to segment it successfully using the dictionary? - BOTTOM UP APPROACH MEMOIZATION
        Boolean[] memo = new Boolean[s.length()];
        return helper(0, s, wordDict, memo);
    }
    private boolean helper(int i, String s, List<String> wordDict, Boolean[] memo) {
        // Base Case
        if (i == s.length()) {
            return true;
        }
        if(memo[i] == null){
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
        return memo[i] = false;
    }
}
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] -> Can we segment the substring starting from the beginning up to index i?
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i = 0; i<=s.length(); i++){
            for(String word : wordDict){
                int start = i - word.length();
                if (start >= 0 && dp[start]) {
                   if (s.substring(start, i).equals(word)) {
                        dp[i] = true;
                        break; // Found a valid way to make dp[i], no need to check other words
                    } 
                }
                
            }
        }

        return dp[s.length()];
    }
}