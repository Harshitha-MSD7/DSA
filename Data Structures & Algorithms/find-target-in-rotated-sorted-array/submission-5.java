class Solution {
    public int search(int[] nums, int target) {
        //  return the index of target
        int left = 0;
        int right = nums.length-1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            // We are in the sorted half 
            // if the target is in this range 
            // then we just have to perform a BS to find it
            if(nums[mid] == target) return mid;
            else if(nums[left] <= nums[mid]){
                if((nums[left] <= target) && (target < nums[mid])){
                    right = mid-1;
                }
                else {
                    left = mid+1;
                }
            }
            // right half is sorted 
            else{
                if((nums[mid] < target) && (target <= nums[right])){
                    left = mid+1;
                }
                else {
                    right = mid-1;
                }
            }

        }

        return -1;
    }
}
