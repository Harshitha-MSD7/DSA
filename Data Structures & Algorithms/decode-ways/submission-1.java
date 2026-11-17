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
        // dp[i] -> from 0-i how many ways to decode the string
        if(s.length() == 0) return 0;
        int[] dp = new int[s.length()+1];
        
        dp[s.length()] = 1;

        for(int i = s.length()-1; i>=0; i--){
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } 
            else {
                dp[i] = dp[i+1];
                if (i + 1 < s.length() && Integer.parseInt(s.substring(i, i + 2)) < 27) {
                    dp[i] += dp[i + 2];
                }
            }
            
        }

        return dp[0];
    }
}
