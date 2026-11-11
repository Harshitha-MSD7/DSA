class KthLargest {

    PriorityQueue<Integer> q;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.q = new PriorityQueue<>();

        for(int num : nums){
            q.offer(num);
        }
        while(q.size() > k){
            q.poll();
        }
    }
    
    public int add(int val) {
       if(((!q.isEmpty()) && val <= q.peek()) && q.size() == k){
            return q.peek();
        } 

        q.offer(val);
        if(q.size() > k)
            q.poll();
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */