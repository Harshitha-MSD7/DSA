class Solution {
    public int trap(int[] height) {
        // better solution -> O(n) time and O(n) space

        int[] prefix_max = new int[height.length];
        int[] suffix_max = new int[height.length];
        prefix_max[0] = height[0];
        for(int i = 1; i < height.length; i++){
            prefix_max[i] = Math.max(prefix_max[i-1], height[i]);
        }
        suffix_max[height.length - 1] = height[height.length - 1];
        for(int i = height.length-2; i >= 0; i--){
            suffix_max[i] = Math.max(suffix_max[i+1], height[i]);
        }

        int total = 0;

        for(int i = 0; i<height.length; i++){
            if(Math.min(prefix_max[i], suffix_max[i]) - height[i] > 0){
                total += Math.min(prefix_max[i], suffix_max[i]) - height[i];
            }
        }

        return total;
    }
}
