class Solution {
    // 1 2 3 1
    // rob1 -> best upto the house before that, basically dp[i-2] 
    // rob2 -> best until the previous house, basically dp[i-1]

    /*
    For each house:

    Either skip it → keep previous best (rob2)
    Or rob it → current money + best from two steps back (rob1)

    Pick the maximum!
    
    */
    public int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        for(int num : nums){
            int temp = Math.max(num + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }
}
