class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Given -> directed edge graph
        // numCouses -> number of vertices

        // Create an incoming arr
        int[] order = new int[numCourses];
        int res = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        // Populate the adj
        for (int[] lol : prerequisites) {
            adj.get(lol[1]).add(lol[0]);
        }

        int[] arr = new int[numCourses];
        for (int[] it : prerequisites) {
            arr[it[0]] = arr[it[0]] + 1;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (arr[i] == 0) {
                q.offer(i);
            }
        }
        int index = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            order[index] = node;
            index++;
            res--;
            for (int j : adj.get(node)) {
                arr[j] = arr[j] - 1;
                if (arr[j] == 0) {
                    q.offer(j);
                }
            }
        }

        if (res == 0)
            return order;
        return new int[0];
    }
}
