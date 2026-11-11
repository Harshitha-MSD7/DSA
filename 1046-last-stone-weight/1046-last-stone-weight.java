class Solution {
    /*
    1. sort the array stones in decending order
    2. 
    
    */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone : stones){
            q.offer(stone);
        }

        while(q.size() >= 2){
            int y = q.poll();
            int x = q.poll();

            if(x == y) continue;

            q.offer(y-x);

        }

        if(q.size() == 1){
            return q.poll();
        }

        return 0;

    }
}