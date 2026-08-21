class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // days - fixed and give
        // trail and error - capacity (minimum) - lower bound binary search on this
        int low = 0;
        int high = 0;
        for(int i : weights){
            low = Math.max(low, i);
            high +=  i;
        }
        // BS on Capacity 
        while(low < high){
            int mid = low + (high - low) / 2;

            // if false - increase the capacity 
            if(!ship(weights, days, mid)){
                low = mid + 1;
            }
            // if posiible - this could be the answer but there could also be a better answer to theleft so eliminate 
            else{
                high = mid;
            }
        }

        return low;
    }

    // Given the capacity is it possible to ship packages in # of days

    private boolean ship(int[] weights, int days, int capacity){
        int sum = 0;
        int d = 1;
        for(int i = 0; i<weights.length; i++){
            if(sum + weights[i] <= capacity) 
                sum += weights[i];
            else {
                sum = weights[i];
                d++;
            }
        }
        
        return d <= days;
    }
}