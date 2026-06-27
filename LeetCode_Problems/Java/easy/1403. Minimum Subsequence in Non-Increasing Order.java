class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);

        int totalSum = 0;

        for (int n : nums) {
            totalSum += n;
        }

        int numbers = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            result.add(nums[i]);
            numbers += nums[i];
            totalSum -= nums[i];

            if (numbers > totalSum) break;
        }
        
        return result;
    }
}
