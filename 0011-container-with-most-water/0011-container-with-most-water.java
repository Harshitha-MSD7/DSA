class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;

        while(l < r){
            maxArea = Math.max(maxArea, ((r-l)* Math.min(height[l], height[r])));
            if(height[l] <= height[r]) l++;
            else if(height[l] > height[r]) r--;
        } 
        return maxArea;
    }
}