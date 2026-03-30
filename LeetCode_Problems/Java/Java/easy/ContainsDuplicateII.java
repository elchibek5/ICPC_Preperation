class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int a = nums.length;
        Map<Integer, Integer> lastIndex = new HashMap<>();

        for (int i = 0; i < a; i++) {
            Integer prev = lastIndex.get(nums[i]);
            if (prev != null && i - prev <= k) return true;
            lastIndex.put(nums[i], i);
        }
        return false;

    }
}
