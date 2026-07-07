class Solution {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int n : amount) {
            if (n > 0) {
                pq.offer(n);
            }
        }

        int time = 0;

        while (pq.size() > 1) {

            int first = pq.poll();
            int second = pq.poll();

            first--;
            second--;

            if (first > 0) {
                pq.offer(first);
            }

            if (second > 0) {
                pq.offer(second);
            }

            time++;
        }

        if (!pq.isEmpty()) {
            time += pq.poll();
        }
        
        return time;
    }
}
