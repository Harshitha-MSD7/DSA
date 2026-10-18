class Solution {
    // Sort it based on start time of interval
    // merge -> end of interval >= start of next interval
    // [[0,4], [2,3]] 
    public int[][] merge(int[][] intervals) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int endTime = intervals[0][1];
        List<Integer> start = new ArrayList<>();
        start.add(intervals[0][0]);
        start.add(intervals[0][1]);
        res.add(new ArrayList<>(start));
        for(int i = 1; i<intervals.length; i++){
            // There is an overlap -> MERGE!
            if(endTime >= intervals[i][0]){
                endTime = Math.max(res.get(res.size()-1).get(1), intervals[i][1]);
                res.get(res.size()-1).set(1, endTime);
            }
            // No overlap
            else{
                List<Integer> Newinterval = new ArrayList<>();
                Newinterval.add(intervals[i][0]);
                Newinterval.add(intervals[i][1]);
                res.add(new ArrayList<>(Newinterval));
                endTime = intervals[i][1];
            }
        }

        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i][0] = res.get(i).get(0);
            result[i][1] = res.get(i).get(1);
        }
        return result;

    }
}