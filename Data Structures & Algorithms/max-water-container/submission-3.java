class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        // which ever is lower reduce that and have a max tracker for the ArrayDeque
        int max_area = Integer.MIN_VALUE;



        while(left<right){
            int area = Math.min(heights[left],heights[right]) * (right-left);
            max_area = Math.max(max_area, area); 
            if(heights[left]<=heights[right]){
                left++;
            }
            else{
                right--;
            }

        }

        return max_area;
    }
}
