class Solution {
    public int findLHS(int[] nums) {
        // [1,3,2,2,5,2,3,7]
        // [1,2,2,2,3,3,5,7]

        Arrays.sort(nums);
        int left = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > 1) {
                left++;
            }

            if (nums[right] - nums[left] == 1) {
                ans = Math.max(ans, right - left + 1);
            }
        }

        return ans;
    }
}
