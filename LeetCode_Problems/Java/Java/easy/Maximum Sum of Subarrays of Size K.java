public class Solution {
    public Integer maxSum(int[] nums, Integer k) {
        // Your code goes here
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;
        int start = 0;
        
        for (int i = 0; i < nums.length; i++) {
            windowSum += nums[i];

            if (i - start + 1 == k) {
                maxSum = Math.max(windowSum, maxSum);
                windowSum -= nums[start];
                start++;
            }
        }

        return maxSum;        
    }
}
