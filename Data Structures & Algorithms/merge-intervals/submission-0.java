class Solution {
    public int[][] merge(int[][] intervals) {
         /*
         [1,5] [2,6] [7,10] -> [1,6] [7,10]
         */   

        // Sort it based on the first index
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for(int i = 1; i<intervals.length; i++){
            // iterate the staring
            // if there is an overlap -> merge and push it to the List
            if(merged.get(merged.size() - 1)[1]>=intervals[i][0])
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], intervals[i][1]);
            // no overlap -> push it to the list
            else {
            merged.add( new int[]{intervals[i][0],intervals[i][1]}); }

        }

        return merged.toArray(new int[merged.size()][]);
    }
}
