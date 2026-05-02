class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) return nums[0];

        quickSort(nums, 0, nums.length - 1);
        
        int ans = nums.length - k;
        return nums[ans];
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
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

        int l = storeIndex - 2;
        while (l >= left && nums[l] == pivot) l--;
        quickSort(nums, left, l);

        int r = storeIndex;
        while (r <= right && nums[r] == pivot) r++;
        quickSort(nums, r, right);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
