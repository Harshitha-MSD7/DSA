/*
class Solution {
    // Recursive Solution
    public int minDistance(String word1, String word2) {
        return helper(word1, word2, 0, 0);
    }
    private int helper(String word1, String word2, int i, int j){
        // loop until i and j are equal 
        while((j < word2.length() && i < word1.length()) && word1.charAt(i) == word2.charAt(j)){
            i++;
            j++;
        }

        // Base Cases

        // if both are out of bounds we are done!
        if(i >= word1.length() && j >= word2.length()){
            return 0;
        }

        // i out of bounds and j in range -> Insert
        else if(i >= word1.length() && j < word2.length()){
            return word2.length()-j;
        }

        // j out of bounds and i in range -> Delete
        else if(i < word1.length() && j >= word2.length()){
            return word1.length()-i;
        }

        // variable declarations
        int min = Integer.MAX_VALUE;
        int insert = 0;
        int delete = 0;
        int replace = 0;

        // both i and j are withing bounds and are unequal -> 3 options
        insert = 1 + helper(word1, word2, i, j+1);
        delete = 1 + helper(word1, word2, i+1, j);
        replace = 1 + helper(word1, word2, i+1, j+1);
        

        min = Math.min(insert, Math.min(delete, replace));

        return min;
    }
}

class Solution {
    // Memoization
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for(int[] tmp : memo){
            Arrays.fill(tmp, -1);
        }
        return helper(word1, word2, 0, 0, memo);
    }
    private int helper(String word1, String word2, int i, int j, int[][] memo){
        // loop until i and j are equal 
        while((j < word2.length() && i < word1.length()) && word1.charAt(i) == word2.charAt(j)){
            i++;
            j++;
        }

        // Base Cases

        // if both are out of bounds we are done!
        if(i >= word1.length() && j >= word2.length()){
            return 0;
        }

        // i out of bounds and j in range -> Insert
        else if(i >= word1.length() && j < word2.length()){
            return word2.length()-j;
        }

        // j out of bounds and i in range -> Delete
        else if(i < word1.length() && j >= word2.length()){
            return word1.length()-i;
        }

        // variable declarations
        int insert = 0;
        int delete = 0;
        int replace = 0;

        // both i and j are withing bounds and are unequal -> 3 options
        if(memo[i][j] == -1){
            insert = 1 + helper(word1, word2, i, j+1, memo);
            delete = 1 + helper(word1, word2, i+1, j, memo);
            replace = 1 + helper(word1, word2, i+1, j+1, memo);
            
            memo[i][j] = Math.min(insert, Math.min(delete, replace));
        }

        return memo[i][j];
    }
}
*/
class Solution {
    // Tabulation - Bottom Up
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        // rows - word1 characters
        // cols - word2 characters
        // dp[i][j] -> the minimum operations to convert word1 from i to the end into word2 from j to the end.

        // last row: word1 is done -> insert the rest of word2
        for (int j = 0; j <= n; j++) {
            dp[m][j] = n - j; 
        }

        // last column: word2 is done -> delete the rest of word1
        for (int i = 0; i <= m; i++) {
            dp[i][n] = m - i;
        }

        // TODO: fill the rest of the table
        // 1. which direction do i and j need to run?
        // 2. chars equal -> dp[j][i] = ?
        // 3. chars unequal -> dp[j][i] = ?

        for(int i = m-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                // if chars are equal
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }
                // if chars unequal
                else{
                    // 3 choices 
                    dp[i][j] = 1 + Math.min(dp[i+1][j+1], Math.min(dp[i][j+1], dp[i+1][j]));
                }
            }
        }

        return dp[0][0];
    }
}