class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> next = new HashMap<>();
        Deque<Integer> st = new ArrayDeque<>();

        for (int x : nums2) {
            while (!st.isEmpty() && x > st.peek()) {
                int smaller = st.pop();
                next.put(smaller, x);
            }
            st.push(x);
        }

        while (!st.isEmpty()) {
            next.put(st.pop(), -1);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = next.get(nums1[i]);
        }
        return ans;
    }
}
