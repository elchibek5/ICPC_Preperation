class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Deque <Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < 2 * n; i++) {
            int idx = i % n;
            while (!stack.isEmpty() && nums[idx] > nums[stack.peek()]) {
                int prev = stack.pop();
                ans[prev] = nums[idx];
            }

            if (i < n) {
                stack.push(idx);
            }
        }

        return ans;
    }
}
