class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if (n == 1) return;

        int middle = (n + 1) / 2;
        int[] copy = Arrays.copyOf(nums, n);

        int median = quickSelect(copy, 0, copy.length - 1, middle);

        for (int i = 0; i < n; i++) {
            nums[i] = -1;
        }

        int last_even_index = n - 1;
        if (last_even_index % 2 == 1) last_even_index--;

        // Putting nums that are < median at even indicies, starting from last even index
        int j = last_even_index;
        for (int i = middle - 1; i >= 0; i--) {
            if (copy[i] < median) {
                nums[j] = copy[i];
                j -= 2;
            }
        }

        // Putting nums that are > median at odd indicies, starting from first odd index
        j = 1;
        for (int i = n - 1; i >= middle; i--) {
            if (copy[i] > median) {
                nums[j] = copy[i];
                j += 2;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == -1) {
                nums[i] = median;
            }
        }

    }

    private static int quickSelect(int[] arr, int left, int right, int k) {
        Random rand = new Random();
        int randIndex = rand.nextInt(left, right + 1);
        swap(arr, left, randIndex);

        int pivot = arr[left];
        int storeIndex = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }
        swap(arr, left, storeIndex - 1);

        int l = storeIndex - 2;
        int r = storeIndex;
        while (l >= left && arr[l] == pivot) l--;
        while (r <= right && arr[r] == pivot) r++;

        if (l + 1 <= k && k <= r - 1) return arr[k];
        if (k <= l) return quickSelect(arr, left, l, k);
        return quickSelect(arr, r, right, k);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
