class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {

        double[][] workers = new double[quality.length][2];
        for (int i = 0; i < quality.length; i++) {
            workers[i][0] = (double) wage[i] / quality[i];
            workers[i][1] = (double) quality[i];
        }

        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        double qSum = 0;
        double minCost = Double.MAX_VALUE;
        
        for (double[] worker : workers) {
            double ratio = worker[0];
            int q = (int) worker[1];
            qSum += q;
            pq.offer(q);

            if (pq.size() > k) {
                qSum -= pq.poll();
            }
            if (pq.size() == k) {
                minCost = Math.min(minCost, qSum * ratio);
            }
        }

        return minCost;
    }
}
