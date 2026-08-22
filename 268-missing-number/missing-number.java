class Solution {
    public int missingNumber(int[] nums) {
        // indices and elements have to be like a HashMap
        // Indices: [0,n-1] and elements[0-n]
        int n = nums.length;
        int expected_sum = n * (n+1) / 2;
        int sum = 0;
        for(int i : nums){
            sum += i;
        }

        return expected_sum - sum;
    }
}