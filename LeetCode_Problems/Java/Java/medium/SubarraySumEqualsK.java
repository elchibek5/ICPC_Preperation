class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int prefix = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        for (int x : nums) {
            prefix += x;
            ans += freq.getOrDefault(prefix - k, 0);

            freq.put(prefix, freq.getOrDefault(prefix, 0) + 1);
        }
        return ans;
    }
}
