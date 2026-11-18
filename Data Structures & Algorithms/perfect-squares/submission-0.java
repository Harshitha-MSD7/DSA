class Solution {
    public int numSquares(int n) {
        // 1. Get your list of squares (e.g., [1, 4, 9, 16...])
        List<Integer> perfectSquare = perfectSquares(n);
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n); // n acts as infinity
        dp[0] = 0;
        
        // 2. Build up from 1 to n
        for (int target = 1; target <= n; target++) {
            // 3. Loop through your list of squares instead of doing s * s math
            for (int square : perfectSquare) {
                if (target >= square) {
                    dp[target] = Math.min(dp[target], dp[target - square] + 1);
                } else {
                    break; // Since the list is sorted, we can break early if the square is too big
                }
            }
        }
        return dp[n];
    }
    
    private List<Integer> perfectSquares(int n) {
        List<Integer> res = new ArrayList<>();
        int num = 1;
        while (num * num <= n) {
            res.add(num * num);
            num++;
        }
        return res;
    }
}