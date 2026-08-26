class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //u -> {v, wei} 
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i<=n; i++) adj.add(new ArrayList<>());
        for(int[] time : times){
            //times[i] = (ui, vi, ti)
            adj.get(time[0]).add(new int[]{time[1], time[2]});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        // {time, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0])); 
        pq.offer(new int[]{0,k});

        // Traversal

        while(!pq.isEmpty()){
            int time = pq.peek()[0];
            int node = pq.peek()[1];
            pq.poll();
            for(int[] it : adj.get(node)){
                if(time + it[1] < dist[it[0]]){
                    dist[it[0]] = time + it[1];
                    pq.offer(new int[]{time + it[1], it[0]});
                }
            }

        }
        int min = 0;
        for(int m = 1; m<dist.length; m++){
            if(dist[m] == Integer.MAX_VALUE) return -1;
            min = Math.max(min, dist[m]);
        }
        return min;
    }
}
