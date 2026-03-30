class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 0) {
                swap(nums, pointer++, i);
            }
        }
        return nums;
    }

    private void swap(int[] a, int x, int y) {
        int t = a[x]; a[x] = a[y]; a[y] = t;
    }
}
