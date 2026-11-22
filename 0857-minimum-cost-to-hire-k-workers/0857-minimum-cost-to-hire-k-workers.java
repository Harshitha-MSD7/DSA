class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = wage.length;
        double[][] workers = new double[n][2];
        for (int i = 0; i < n; i++) {
            workers[i][0] = (double) wage[i] / quality[i];  // ratio
            workers[i][1] = quality[i];                      // quality
        }
        // sort the rows based on ratio
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        // Max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        double minCost = Double.MAX_VALUE;

        for (double[] current : workers) {
            int q = (int) current[1];
            pq.offer(q);
            sum += q;

            if (pq.size() > k) {
                sum -= pq.poll(); // drop the largest quality
            }
            if (pq.size() == k) {
                minCost = Math.min(minCost, current[0] * sum);
            }
        }
        return minCost;

    }
}