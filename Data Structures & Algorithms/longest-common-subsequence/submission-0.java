class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // if match -> 1 + diagonal
        // if not match max(right, down)
        // return dp[0][0]
        // base case all n (text1) row cells = 0 and all m (text2) col cells = 0

        int n = text1.length(); // row
        int m = text2.length(); // col

        int[][] dp = new int[n+1][m+1];

        for(int i = n; i >= 0; i--){
            dp[i][m] = 0;
        }

        for(int j = m; j>=0; j--){
            dp[n][j] = 0;
        }
        // text1 - n
        for(int i = n-1; i >= 0; i--){
            // text2 - m
            for(int j = m-1; j >=0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }
                else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return dp[0][0];
    }
}
