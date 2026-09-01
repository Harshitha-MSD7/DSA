class Solution {
    public void rotate(int[] nums, int k) {
        /* Brute force
        int n = nums.length;

        int[] copyk = new int[k];
        int j = 0;
        for(int i = n-k; i<n; i++){
            copyk[j] = nums[i];
            j++;
        } 
        int[] copy2 = new int[n-k];
        int l = 0;
        for(int m = 0; m<n-k; m++){
            copy2[l] = nums[m];
            l++;
        }
        int f = 0;
        for(int int2: copyk){
            nums[f] = int2;
            f++;
        }
        for(int int1: copy2){
            nums[f] = int1;
            f++;
        }
        */

        int rotations = k % nums.length;
        
        rotate(0, nums.length-1, nums);
        rotate(0,rotations-1, nums);
        rotate(rotations, nums.length-1,nums);

    }

    private void rotate(int l, int r, int[] arr){
        int tmp = 0;
        while(l<r){
            tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }
}