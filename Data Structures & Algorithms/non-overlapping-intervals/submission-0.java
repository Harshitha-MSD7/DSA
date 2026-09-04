class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        /*
        
        *----------------*
                    *-------------*
        
        */
        int remove = 0;

        // sorting them based on the starting index
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        // Noe I have to hceck if there are any overlap
        int end = intervals[0][1];

        for(int i = 1; i<intervals.length; i++){
            // checking for overlaps
            if(end > intervals[i][0]){
                // if there is an overalap
                // pick which one to delete and increment the revome Integer
                // we pick the one to delete that has the smallest end value
                if(end > intervals[i][1]){
                    end = intervals[i][1];
                }

                remove++;
            }
            // of no overlap exists
            // then there is nothing to delete here we can just look at the further stuff 
            else{
                end = intervals[i][1];

            }
        }

        return remove;
    }
}
