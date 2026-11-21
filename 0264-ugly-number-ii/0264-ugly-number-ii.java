class Solution {
    public int nthUglyNumber(int n) {
        /*
        BRUTE FORCE
        in a while loop -> is x % 2 = 0? -> x/2
        in a while loop -> is x % 3 = 0? -> x/3
        in a while loop -> is x % 5 = 0? -> x/5
        is x == 1? if true -> ugly number if false skip and do not incerement the count
        */
        // Priority Queue Approach

        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();

        // Start with the first ugly number: 1
        pq.offer(1L);
        set.add(1L);

        int count = 0;
        long current = 0L;

        while (count < n) {
            current = pq.poll();
            count++;

            long next2 = current * 2L;
            long next3 = current * 3L;
            long next5 = current * 5L;

            if (!set.contains(next2)) {
                pq.offer(next2);
                set.add(next2);
            }
            if (!set.contains(next3)) {
                pq.offer(next3);
                set.add(next3);
            }
            if (!set.contains(next5)) {
                pq.offer(next5);
                set.add(next5);
            }
        }

        return (int) current;
    }
}