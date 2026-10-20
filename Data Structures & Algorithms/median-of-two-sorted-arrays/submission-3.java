class Solution {
    /*
    Input: nums1 = [1,3], nums2 = [2,4]

    Output: 2.5

len = 4 count = 3
    _ _ _ _

len = 3 count = 2
    _ _ _
    
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length; 
        int len2 = nums2.length;
        int i = 0; // nums1
        int j = 0; // nums2
        int median1 = 0;
        int median2 = 0;

        for(int count = 0; count <= (len1 + len2)/2; count++){

            median2 = median1;

            if(i<len1 && j<len2){
                // 2 conditions
                if(nums1[i] <= nums2[j]){
                    median1 = nums1[i];
                    i++;
                }
                else{
                    median1 = nums2[j];
                    j++;
                }
            }
            else if(i<len1 && j >= len2){
                median1 = nums1[i];
                i++;
            }
            else{
                median1 = nums2[j];
                j++;
            }

        }

        if((len1 + len2) % 2 == 1){
            return (double) median1;
        }
        else{
            return (double) (median1+median2)/2.0;
        }

        

    }
}
