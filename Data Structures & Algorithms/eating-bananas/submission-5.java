class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // BS to find min rate of eating bananas
        // range - [min of piles, max of piles]

        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            high = Math.max(high, piles[i]);
        }
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (bananas(mid, piles) <= h) {
                // Increase the rate of eating
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
    // Retuns the # of hours it takes to finish eating
    private int bananas(int rate, int[] piles) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil((double) pile / rate);
        }

        return hours;
    }

}


