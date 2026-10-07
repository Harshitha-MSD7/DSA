class Solution {
    /*
    1. sort the array stones in decending order
    2. 
    
    */
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 0) return 0;
        if(stones.length == 1) return stones[0];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones){
            pq.offer(i);
        }
        // pq can have even number of elements and also odd number of elements
        while(pq.size() > 1){
            int y = pq.poll();
            int x = pq.poll();

            if(x != y){
                y = y-x;
                pq.offer(y);
            }
        }
        
        if(pq.size() == 0){
            return 0;
        }
        return pq.poll();

    }
}