class Solution {
    public int maxPower(String s) {
        if (s.length() == 0) return 0;
        
        int max = 1;
        int currentCount = 1;
        
        for (int i = 1; i < s.length(); i++) {
            // If it matches the previous character, increase our running count
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentCount++;
                max = Math.max(max, currentCount);
            } else {
                // Otherwise, the streak is broken; reset the count to 1
                currentCount = 1;
            }
        }
        
        return max;
    }
}