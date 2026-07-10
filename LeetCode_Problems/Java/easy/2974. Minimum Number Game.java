class Solution {
    public int[] numberGame(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i : nums) {
            pq.offer(i);
        }

        for (int i = 0; i < nums.length - 1; i += 2) {
            nums[i + 1] = pq.poll();
            nums[i] = pq.poll();
        }

        return nums;
    }
}
