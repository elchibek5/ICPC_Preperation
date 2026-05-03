class Solution {
    public int minOperations(int[] nums, int k) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) answer++;
        }
        return answer;
    }
}
