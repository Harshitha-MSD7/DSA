class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // Brute force DFS solution

        // Turn the edge list into adjacency matrix
        if (n == 1) return Collections.singletonList(0);
        List<List<Integer>> adj = new ArrayList<>();

        for(int j = 0; j<n; j++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            // u -> v
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] degree = new int[n];
        Deque<Integer> q = new ArrayDeque<>(); 

        for(int i = 0; i<n; i++){
            degree[i] = adj.get(i).size();
            // if it is a leaf node -> add it to the queue
            if(degree[i] == 1){
                q.add(i);
            }
        }


        List<Integer> res = new ArrayList<>();
        int minHeight = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            if(n <= 2) return new ArrayList<>(q);
            int size = q.size();
            // processing each node in the queue at current level
            for(int i = 0; i<size; i++){
                int node = q.poll();
                n--;
                // decrement the degree of the parent node
                // if the degree of the parent node = 1 -> LEAF NODE!
                // add it to the q
                for(int parent : adj.get(node)){
                    degree[parent]--;
                    if(degree[parent] == 1){
                        q.offer(parent);
                    }
                }
            }
        }

        return new ArrayList<>();
    }

   
}