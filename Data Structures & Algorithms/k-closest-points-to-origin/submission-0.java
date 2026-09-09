class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // k-closes means k smallest
        // Store the diatance in a min Heap 
        int[][] res = new int[k][2];
        // A Max-Heap that stores the int[] points directly, comparing them by distance
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (p1, p2) -> (p2[0]*p2[0] + p2[1]*p2[1]) - (p1[0]*p1[0] + p1[1]*p1[1])
        );

        for(int i = 0; i<points.length; i++){
            maxHeap.add(points[i]);

            // Top min k will be maintained
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        // Traverse the heap and return int
        int j = 0;
        while(maxHeap.size() > 0){
            int[] ans = new int[2];
            ans = maxHeap.poll();
            res[j] = ans; 
            j++;
        }

        return res;
    }
}
