class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int streak = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 1) {
                streak++;
            } else {
                if (streak > max) {
                    max = streak;
                }
                streak = 0;
            }
        }
        if (streak > max) {
            max = streak;
        }
        return max;
    }
}
