class Solution {
    public int firstStableIndex(int[] nums, int k) {

        // prefix
        int[] max_arr = new int[nums.length];
        // suffix
        int[] min_arr = new int[nums.length];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i< nums.length; i++){
            max = Math.max(max, nums[i]);
            max_arr[i] = max;
        }

        for(int j = nums.length-1; j >= 0; j--){
            min = Math.min(min, nums[j]);
            min_arr[j] = min;
        }

        for(int l = 0; l<nums.length; l++){
            if(max_arr[l] - min_arr[l] <= k) return l;

        }

        return -1;
    }
}