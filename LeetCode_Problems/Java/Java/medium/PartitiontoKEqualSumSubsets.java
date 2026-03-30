class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false;
        }

        int target = sum / k;
        Arrays.sort(nums);
        reverse(nums);

        int[] bucketSum = new int[k];

        return backtrack(0, nums, target, bucketSum);
    }

    private boolean backtrack(int numIndex, int[] nums, int target, int[] bucketSums) {
        if (numIndex == nums.length) {
            return true;
        }

        int currentNum = nums[numIndex];

        for (int i = 0; i < bucketSums.length; i++) {
            if (bucketSums[i] + currentNum <= target) {
                bucketSums[i] += currentNum;

                if (backtrack(numIndex + 1, nums, target, bucketSums)) {
                    return true;
                }
                bucketSums[i] -= currentNum;
            }

            if (bucketSums[i] == 0) break;
        }
        return false;
    }

    private void reverse(int[] nums) {
        int left = 0; int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
