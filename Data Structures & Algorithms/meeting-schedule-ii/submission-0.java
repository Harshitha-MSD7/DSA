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

/*
    Return - at given particular time what is the maximum number of meetings that is taking place
    (0,40) (5,10) (15,20)
    [0,5,15]
    [10,20,40]

*/


class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        for(int i = 0; i<intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int count = 0;
        int max = 0;
        int i = 0;
        int j = 0;
        while(i < start.length && j < end.length){
            // a new meeting is starting before current meeting ended
            // need extra room
            if(start[i] < end[j]){
                count++;
                max = Math.max(max, count);
                i++;
            }
            else{
                count--;
                j++;
            }
        }

        return max;

    }
}
