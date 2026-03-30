class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap =
            new PriorityQueue<>((x, y) -> Double.compare(y[0], x[0]));

        for (int[] c : classes) {
            double a = c[0];
            double b = c[1];
            maxHeap.offer(new double[]{gain(a, b), a, b});
        }

        while(extraStudents-- > 0) {
            double[] best = maxHeap.poll();
            best[1]++;
            best[2]++;
            best[0] = gain(best[1], best[2]);
            maxHeap.offer(best);
        }

        double sum = 0.0;
        int n = classes.length;
        while (!maxHeap.isEmpty()) {
            double[] item = maxHeap.poll();
            sum += item[1] / item[2];
        }
        return sum / n;

    }

    private double gain(double a, double b) {
        return (a + 1) / (b + 1) - a / b;
    }
}
