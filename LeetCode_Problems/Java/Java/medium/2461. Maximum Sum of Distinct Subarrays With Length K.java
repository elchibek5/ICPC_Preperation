class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        long maxSum = 0;
        long currentSum = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            while (set.contains(nums[i])) {
                currentSum -= nums[left];
                set.remove(nums[left]);
                left++;
            }

            currentSum += nums[i];
            set.add(nums[i]);

            if (i - left + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
        }
        return maxSum;
    }
}
