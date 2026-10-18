// Two Heap solution
// Have half smaller elements in one and then have larger half elements in another heap
// In the smaller half -> when we pop we want to have the max of those -> MAX HEAP
// In the larger half -> when we pop we want to have the min of those -> MIN HEAP
// 

class MedianFinder {

    PriorityQueue<Integer> min_pq;
    PriorityQueue<Integer> max_pq;

    public MedianFinder() {
        min_pq = new PriorityQueue<>(Collections.reverseOrder());
        max_pq = new PriorityQueue<>();
    }
    
    // Adding a new element 
    // How do I know which heap to add this new element 
    // 2 possible cases 
    // 1. Heap size is similar 
    // Simply add it to min_heap -> BEWARE OF REARRANGEMENT! (Meaning if the top of the max heap is larger than the num then pop min heap and add it to max heap and then add num to min heap)
    // 2. Heap size is different (min is always going to be larger than the max)
    // just compare num with min_pq poll -> ....
    public void addNum(int num) {
        // if size equal -> add to min_pq and rearrange!
        if(min_pq.size() == 0 && max_pq.size() == 0){
            min_pq.offer(num);
            return;
        }
        if(min_pq.size() != max_pq.size()){
            // decide which heap num belongs to
        
            if(num >= min_pq.peek()){
                max_pq.offer(num);
            }
            else{
                min_pq.offer(num);
                max_pq.offer(min_pq.poll());
            }
            
        }
        // if the size is equal
        else{
            // See which heap num belongs to 
            // if num belongs to max heap
            if(num > max_pq.peek()){
                max_pq.offer(num);
                min_pq.offer(max_pq.poll());
            }
            // num belongs to min heap 
            else{
                min_pq.offer(num);
            }
        }
    }
    
    public double findMedian() {
        if(min_pq.size() != max_pq.size()) return (double) min_pq.peek();

        return (min_pq.peek() + max_pq.peek()) / 2.0;
    }
}
