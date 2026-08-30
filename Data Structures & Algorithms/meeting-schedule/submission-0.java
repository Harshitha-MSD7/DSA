/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Sort it based on the first index
        // if the ending of current interval is greater than the starting of another interval return false else return true
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        for(int i = 0; i<intervals.size()-1; i++){
            if(intervals.get(i).end > intervals.get(i+1).start) return false;
        }

        return true;

    }
}
