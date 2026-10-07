public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int i = 0, j = 0;
        int median1 = 0, median2 = 0;

        for (int count = 0; count < (len1 + len2) / 2 + 1; count++) {
            median2 = median1;
            // both pointers within range
            if (i < len1 && j < len2) {
                // if j is min
                if (nums1[i] > nums2[j]) {
                    median1 = nums2[j];
                    j++;
                }
                // if i is min 
                else {
                    median1 = nums1[i];
                    i++;
                }
            } 
            // j out of bound and i within bounds
            else if (i < len1) {
                median1 = nums1[i];
                i++;
            }
            //  i out of bound and j within bounds
            else {
                median1 = nums2[j];
                j++;
            }
        }
        // if we have odd number of elements
        if ((len1 + len2) % 2 == 1) {
            return (double) median1;
        } else {
            return (median1 + median2) / 2.0;
        }
    }
}