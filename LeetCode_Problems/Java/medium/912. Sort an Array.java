class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] += 50000;
        }

        int k = 100000;
        int[] b = new int[n];
        int[] c = new int[k + 1];

        for (int i = 0; i <= k; i++) {
            c[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            c[nums[i]]++;
        }

        for (int i = 1; i <= k; i++) {
            c[i] += c[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            b[c[nums[i]] - 1] = nums[i];
            c[nums[i]]--;
        }

        for (int i = 0; i < n; i++) {
            b[i] -= 50000;
        }

        return b;
    }
}
