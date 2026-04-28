class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) return nums;
        quickSort(nums, 0, nums.length - 1);
        return nums;

    }

    public void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }

        Random rand = new Random();
        int randIndex = rand.nextInt(left, right + 1);
        swap(nums, left, randIndex);
        
        int pivot = nums[left];
        int storeIndex = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, storeIndex);
                storeIndex++;
            }
        }

        swap(nums, left, storeIndex - 1);
        quickSort(nums, left, storeIndex - 2);
        quickSort(nums, storeIndex, right);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
