public class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[n];
        int[] maxTime = Arrays.copyOf(time, n);

        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] relation : relations){
            // [prevCourse, nextCourse]
            int src = relation[0] - 1;
            int dst = relation[1] - 1;

            adj.get(src).add(dst);
            inDegree[dst]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while(! q.isEmpty()){
            int node = q.poll();
            for(int nei : adj.get(node)){
                maxTime[nei] = Math.max(maxTime[nei], maxTime[node] + time[nei]);
                if (--inDegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }
        int max = 0;
        for(int i = 0; i<n; i++){
            max = Math.max(maxTime[i], max);
        }
        return max;
    }
}