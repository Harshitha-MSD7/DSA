class Solution {
    public int splitArray(int[] nums, int k) {
        // finding the bounds of BS 
        int left = 0;
        int right = 0;

        for (int i : nums) {
            left = Math.max(left, i);
            right += i;
        }
        // in this BS we have to find the lowest possible value
        /*
        if mid is true -> this could be the ans but there could be a better ans to the left right = mid
        if mid is false -> increase teh sum value left = mid + 1
        
        this process continues until we reach the end to a point where left and right are the same and we return left in the end
        
        */
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isValid(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        return left;
    }

    private static boolean isValid(int[] arr, int k, int max_sum) {
        int req_split = 1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] <= max_sum)
                sum += arr[i];
            else {
                sum = 0;
                req_split++;
                sum += arr[i];
            }
        }
        if (req_split <= k)
            return true;
        return false;
    }
}