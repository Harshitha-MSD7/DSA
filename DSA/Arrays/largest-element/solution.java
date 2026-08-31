class Solution {
    public int largestElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            max = Math.max(max, i);
        }
        return max;
    }
}