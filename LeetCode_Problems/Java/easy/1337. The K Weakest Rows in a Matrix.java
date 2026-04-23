class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // soldier count
            return a[1] - b[1];                   // indx count
        });

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) count++;
                else break;
            }
            pq.offer(new int[]{count, i});
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            int[] curr = pq.poll();
            result[i] = curr[1];
        }
        return result;
    }
}
