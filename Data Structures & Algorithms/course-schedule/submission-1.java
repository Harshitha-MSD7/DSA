class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses]; 
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            //[a,b] means b -> a means pre[1] -> pre[0]
            // go to b index and add a 
            inDegree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int j = 0; j< numCourses; j++){
            if(inDegree[j] == 0){
                q.offer(j);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            numCourses--;
            for(int nei : adj.get(node)){
                inDegree[nei]--;
                if(inDegree[nei] == 0){
                    q.add(nei);
                }
            }
        }

        return numCourses == 0;
    }
}
