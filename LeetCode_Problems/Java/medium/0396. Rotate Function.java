class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int base = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            base += i * nums[i];
        }

        int max = base;
        int currentF = base;

        for (int i = 1; i < n; i++) {
            // Formula: F(i) = F(i-1) + sum - n * nums[n - i]
            currentF = currentF + sum - (n * nums[n - i]);
            max = Math.max(max, currentF);
        }

        return max;
    }
}
