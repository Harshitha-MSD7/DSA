/*
            MEMOIZATION APPROACH
class Solution {
    private int step = 0;
    public int numDecodings(String s) {
        // memo[i] - valid decoding combinations we can do from index i all the way to the end of the string
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        int steps = 0;
        return helper(s, 0, memo);
    }
    private int helper(String s, int i, int[] memo){
        if(i >= s.length()){
            return 1; // 1 meaning we have successfully found out one way to decode
        }
        if(s.charAt(i) == '0') return 0; // invalid
        // if i is within the range we can either take one digit (always possible) or two digits (have to check validity and range)
        if(memo[i] == -1){
            int res = 0;
            res += helper(s, i + 1, memo);
            

            if((i + 1 < s.length()) && (Integer.parseInt(s.substring(i, i+2)) < 27)){
                res += helper(s, i + 2, memo);
            }

            memo[i] = res;
        }
        
        return memo[i];
    }
}
*/
class Solution {
    public int numDecodings(String s) {
        // Edge case: if the string is null or empty, there are 0 ways to decode it
        if (s == null || s.length() == 0) return 0;
        
        int n = s.length();
        // dp[i] represents the number of valid decodings from index i to the end of the string
        int[] dp = new int[n + 1];
        
        // Base case: 1 way to decode an empty suffix at the very end of the string
        dp[n] = 1;
        
        // Iterate from right to left (bottom-up approach)
        for (int i = n - 1; i >= 0; i--) {
            // If the current character is '0', it cannot be decoded on its own or start a valid pair
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                // Option 1: Take 1 digit, carrying forward the result from the next index
                dp[i] = dp[i + 1];
                
                // Option 2: Take 2 digits, if within bounds and the resulting number is <= 26
                if (i + 1 < n && Integer.parseInt(s.substring(i, i + 2)) < 27) {
                    dp[i] += dp[i + 2];
                }
            }
            
        }
        
        // The final answer for the entire string starts at index 0
        return dp[0];
    }
}
