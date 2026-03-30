class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);

        for (int i = n - 1; i > 0; i--) {
            int a = 0;
            int b = i - 1;
            // 2, 3, 4, 5, 6
            while (a < b) {
                if (nums[a] + nums[b] > nums[i]) {
                    ans += b - a;
                    b--;
                } else {
                    a++;
                }
            }
        }
        return ans;
    }
}
