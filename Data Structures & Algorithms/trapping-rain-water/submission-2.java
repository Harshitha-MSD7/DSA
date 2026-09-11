class Solution {
    public int trap(int[] height) {
        // Optimal Solution
        int leftMax = 0;
        int rightMax = 0;

        int l = 0;
        int r = height.length-1;

        int water = 0;

        // not '=' because -> the center water content should not be calulated twice 
        while(l < r){
            // we have to process the left pointer
            if(height[l] <= height[r]){
                if(leftMax > height[l]){
                    water += leftMax - height[l];
                }
                else{
                    leftMax = height[l];
                }
                l++;
            }

            else {
                if(rightMax > height[r]){
                    water += rightMax - height[r];
                }
                else{
                    rightMax = height[r];
                }
                r--;
            }
        }

        return water;
    }
}
