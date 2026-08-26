class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // adj List
        List<List<int[]>> adj = new ArrayList<>();
        for(int m = 0; m<=n; m++) adj.add(new ArrayList<>());

        for(int l = 0; l<times.length; l++){
            // [u , v, t]
            //  u -> v with a weight t 
            adj.get(times[l][0]).add(new int[]{times[l][1], times[l][2]});

        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // [time, node]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
	      Comparator.comparingInt(a -> a[0])
	  );

        pq.offer(new int[]{0,k});
        dist[k] = 0;

        while(!pq.isEmpty()){
            int node = pq.peek()[1];
            int time = pq.peek()[0];
            pq.poll();
            for(int[] it : adj.get(node)){
                int adjNode = it[0];
                int adjTime = it[1];
                if(time + adjTime < dist[adjNode]){
                    dist[adjNode] = time + adjTime;
                    pq.offer(new int[]{time + adjTime, adjNode});
                }
            }
        }
        int min = 0;
        for(int j = 1; j<n+1; j++){
            if(dist[j] == Integer.MAX_VALUE){
                return -1;
            }
            min = Math.max(min, dist[j]);
        }
        return min;
    }
}
