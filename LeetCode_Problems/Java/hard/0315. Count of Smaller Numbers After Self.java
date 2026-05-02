class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < n; i++) results.add(0);
        
        mergeSort(arr, 0, nums.length - 1, results);
        return results;
    }

    public static void mergeSort(int[][] arr, int left, int right, List<Integer> results) {
        if (left == right) return;

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid, results);
        mergeSort(arr, mid + 1, right, results);
        mergeSortedArray(arr, left, right, results); 
    }

    public static void mergeSortedArray(int[][] arr, int left, int right, List<Integer> results) {
        int len = right - left + 1;

        int[][] tmp = new int[len][2];
        int[] updates = new int[len];

        int mid = (left + right) / 2;

        for (int k = 0, i = left, j = mid + 1; k < len; k++) {
            if (i > mid) {
                tmp[k] = arr[j++];
            } else if (j > right) {
                tmp[k] = arr[i++];
            } else if (arr[i][0] <= arr[j][0]) {
                tmp[k] = arr[i++];
            } else {
                tmp[k] = arr[j++];
                updates[i - left] += 1;
            }
        }

        int cumulative_updates = 0;
        for (int k = 0, i = left; i <= mid; k++, i++) {
            cumulative_updates += updates[k];

            results.set(arr[i][1], results.get(arr[i][1]) + cumulative_updates);
        }

        for (int k = 0, i = left; k < len; k++, i++) {
            arr[i] = tmp[k];
        }
    }
}
