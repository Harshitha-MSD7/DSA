class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
        Naive solution -> O(n logn) time complexity
        Not using the fact that we have have been given a sorted array
        int j = 0;
        for(int i = m; i<nums1.length; i++){
            nums1[i] = nums2[j];
            j++;
        }
        Arrays.sort(nums1);
        */

        /*
        nums1 = [1,2,3,0,0,0]
        nums2 = [2,5,6]
        */

        int len = nums1.length-1;
        int n1 = m-1;
        int n2 = n-1;
        while(n2 >= 0){
            if(n1 >=0 && nums1[n1] > nums2[n2]){
                nums1[len] = nums1[n1];
                n1--;
            }
            else{
                nums1[len] = nums2[n2];
                n2--;
            }
            len--;
        }


    }
}