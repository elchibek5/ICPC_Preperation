class Solution {
    public int maxProductDifference(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[] count = new int[10001];
        
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }

        int index = 0;
        for (int val = 0; val <= 10000; val++) {
            while (count[val] > 0) {
                nums[index] = val;
                index++;
                count[val]--;
            }
        }

        return (nums[n - 1] * nums[n - 2]) - (nums[0] * nums[1]);
    }
}
