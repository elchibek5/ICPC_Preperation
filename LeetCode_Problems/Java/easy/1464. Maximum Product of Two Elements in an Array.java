class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int n : nums) {
            pq.offer(n);
        }

        int i = pq.poll();
        int j = pq.poll();

        int ans = (i - 1) * (j - 1);
        return ans;
    }
}
