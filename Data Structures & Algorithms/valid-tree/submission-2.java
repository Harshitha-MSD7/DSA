class Solution {
    // Connected and no cycles 
    public boolean validTree(int n, int[][] edges) {

        if(edges.length != n-1){
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited.add(0);
        while(! q.isEmpty()){
            int node = q.poll();

            for(int nei : adj.get(node)){
                if(!visited.contains(nei)){
                    visited.add(nei);
                    q.add(nei);
                }
            }
        }

        if(visited.size() != n){
            return false;
        }

        return true;
    }
}
