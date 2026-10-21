class Solution {
    // Directed graph traversal 
    // count number of nodes we travesed -> if != num courses return emty int[]
    // else keep track of the order then return it.
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
     
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }   
        int count = 0; 
        int[] inDegree = new int[numCourses];
        for(int[] pre : prerequisites){
            // u -> v
            int u = pre[1];
            int v = pre[0];
            inDegree[v]++;
            adj.get(u).add(v);
        }
        
        int[] res = new int[numCourses];
        Queue<Integer> q= new LinkedList<>();

        for(int j = 0; j<numCourses; j++){
            if(inDegree[j] == 0){
                q.add(j);
            }
        }

        // bfs 

        while(! q.isEmpty()){
            int node = q.poll();
            res[count] = node;
            count++;
            for(int nei : adj.get(node)){
                inDegree[nei]--;
                if(inDegree[nei] == 0){
                    q.offer(nei);
                }
            }
        }

        if(count != numCourses){
            return new int[0];
        }
        return res;
    }
}
