class Solution {
    public int[] unionArray(int[] nums1, int[] nums2) {
        Set<Integer> set = new TreeSet<>();
        for(int ptr1 : nums1){
            set.add(ptr1);
        }

        for(int ptr2 : nums2){
            set.add(ptr2);
        }

        int[] output = new int[set.size()];
        int j = 0;
        for(int i : set){
            output[j] = i;
            j++;
        }
        return output;
    }
}