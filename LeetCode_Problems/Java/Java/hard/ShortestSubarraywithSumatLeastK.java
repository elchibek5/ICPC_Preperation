class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;

        long[] P = new long[n + 1];
        for (int i = 0; i < n; i++) {
            P[i + 1] = P[i] + nums[i];
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int ans = n + 1;

        for (int j = 0; j <= n; j++) {
            while (!deque.isEmpty() && P[j] - P[deque.peekFirst()] >= k) {
                ans = Math.min(ans, j - deque.pollFirst());
            }

            while (!deque.isEmpty() && P[j] <= P[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(j);
        }

        return ans <= n ? ans : -1;
    }
}
