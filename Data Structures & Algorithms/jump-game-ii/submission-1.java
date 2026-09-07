class Solution {
    // [3,4, 1, 3, _, _, _ ]
    public int jump(int[] nums) {
        int i = 0;        
        int jump = 0;
        while(i<nums.length-1){
            int max = 0;
            int best = 0;
            for(int j = i+1; j <= i+nums[i]; j++){
                if(j+nums[j] > max && j < nums.length){
                    max = Math.max(max, j+nums[j]);
                    best = j;
                }
            }
            jump++;
            i = i + best;
        }

        return jump;
    }
}
