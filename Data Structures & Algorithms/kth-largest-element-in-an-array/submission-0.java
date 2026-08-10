class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 1 2 3 4 [5] 6 7
        // 3rd largest element would be 5
        // 7 - 3 pop operations and then return peek
        for(int num : nums){
            minHeap.offer(num);
        }
        int size = minHeap.size();
        for(int i = 0; i< size-k; i++) minHeap.poll();

        return minHeap.peek();

    }
}
