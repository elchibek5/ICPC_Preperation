class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> lastSeenSoFar = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int b = nums[i];
            int a = target - b;
            if (lastSeenSoFar.containsKey(a)) {
                return new int[]{lastSeenSoFar.get(a), i};
            }
            lastSeenSoFar.put(b, i);
        }
        return new int[]{};
    }
}
