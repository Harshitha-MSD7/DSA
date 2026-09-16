class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long totalCount = 0;
        long currentStreak = 0;
        
        for (int num : nums) {
            if (num == 0) {
                currentStreak++;        // Extend our streak of consecutive zeros
                totalCount += currentStreak; // Add the number of new subarrays ending right here
            } else {
                currentStreak = 0;      // Reset if we hit a non-zero number
            }
        }
        
        return totalCount;
    }
}