class Solution {
    public int[][] merge(int[][] intervals) {
        /*
        Write like a custom comparator function 
        to sort the intervals based on the index 0
        
        */

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int end = intervals[0][1];
        res.add(intervals[0]);

        for(int i = 1; i<intervals.length; i++){
            // Overlap -> merge
            if(end >= intervals[i][0]){
                res.get(res.size()-1)[1] = intervals[i][1];
            }
            // no overlap -> just put this in the res and update the end
            else{
                res.add(intervals[i]);
            }
            end = intervals[i][1];
            
        }

        // convert res list to int[][] then return
        return res.toArray(new int[res.size()][]);
    }
}
