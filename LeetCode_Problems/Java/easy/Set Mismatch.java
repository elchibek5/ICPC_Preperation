class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int duplicate = -1;
        int missing = -1;
        int expected = 1;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];

            if (current == expected) {
                expected++;
            } else if (i > 0 && current == nums[i - 1]) {
                duplicate = current;
            } else if (current > expected) {
                missing = expected;
                expected = current + 1;
            }
        }
        if (missing == -1) {
            missing = nums.length;
        }
        return new int[] {duplicate, missing};
    }
}
