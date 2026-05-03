class Solution {
    public int maxProductDifference(int[] nums) {
        int ans = 0;
        int n = nums.length;

        int mn1 = 10000, mn2 = 10000;
        int mx1 = -1, mx2 = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] >= mx1) {
                mx2 = mx1;
                mx1 = nums[i];
            } else if (nums[i] >= mx2) {
                mx2 = nums[i];
            }

            if (nums[i] <= mn1) {
                mn2 = mn1;
                mn1 = nums[i];
            } else if (nums[i] <= mn2) {
                mn2 = nums[i];
            }
        }
        return (mx1 * mx2) - (mn1 * mn2);
    }
}
