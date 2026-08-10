class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
    maxHeap.offer(stone);
}
        
        while(maxHeap.size() > 1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            if(y < x){
                maxHeap.offer(x-y);
            }

        }

        if(maxHeap.size() == 0) return 0;
        return maxHeap.poll();
    }
}
