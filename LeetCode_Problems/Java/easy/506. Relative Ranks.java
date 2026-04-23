class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int s : score) {
            q.offer(s);
        }

        Map<Integer, String> map = new HashMap<>();

        int rank = 1;

        while (!q.isEmpty()) {
            int s = q.poll();

            if (rank == 1) map.put(s, "Gold Medal");
            else if (rank == 2) map.put(s, "Silver Medal");
            else if (rank == 3) map.put(s, "Bronze Medal");
            else map.put(s, String.valueOf(rank));
            
            rank++;
        }

        String[] res = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            res[i] = map.get(score[i]);
        }

        return res;
    }
}
