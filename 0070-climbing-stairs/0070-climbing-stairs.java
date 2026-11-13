/*
    1. BACKTRACKIG APPROACH

class Solution {
    int steps = 0;
    public int climbStairs(int n) {
        steps = 0;
        helper(n);
        return steps;
    }

    private void helper(int stepsLeft){
        if(stepsLeft < 0){
            return;
        }
        if(stepsLeft == 0){
            steps++;
            return;
        }

        // either choose to take 1 steps or 2 steps

        // take 1 step 
        helper(stepsLeft - 1);

        // take 2 steps
        helper(stepsLeft - 2);
        

    }
}

    2. BACKTRACKING FOR MEMOIZATION CONTINUATION

class Solution {
    public int climbStairs(int n) {
        return ways(n);
    }

    private int ways(int k) {
        if (k < 0) return 0;     // overshot → not a valid way
        if (k == 0) return 1;    // reached the top → 1 complete way

        int oneStep = ways(k - 1);   // first move: 1 step
        int twoStep = ways(k - 2);   // first move: 2 steps
        return oneStep + twoStep;
    }
}
*/

/*        3. Memoization        
class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return ways(n, memo);
    }

    private int ways(int k, int[] memo) {
        if (k < 0) return 0;     // overshot → not a valid way
        if (k == 0) return 1;    // reached the top → 1 complete way

        if (memo[k] != -1) return memo[k];

        int oneStep = ways(k-1, memo);
        int twoSteps = ways(k-2, memo);
        memo[k] = oneStep + twoSteps;
        return memo[k];
    }
}
*/

/*
        4. DP solution - O(n) space 
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1; // There are zero ways to climb zero steps
        dp[1] = 1; // there is 1 way to step 1 stair
        for(int i = 2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
*/
//      DP SPACE OPTIMIZED
class Solution {
    public int climbStairs(int n) {
        int prev1 = 1; // dp[i-1]
        int prev2 = 1; // dp[i-2]
        int cur = 0;

        for(int i = 2; i<=n; i++){
            cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur; 
        }
        return prev1;
    }
}

