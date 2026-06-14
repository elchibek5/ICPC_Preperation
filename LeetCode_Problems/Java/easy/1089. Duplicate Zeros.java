class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) count++;
        }

        int[] result = new int[n + count];
        int write = 0;

        for (int i = 0; i < n; i++) {

            if (arr[i] == 0) {
                result[write] = 0;
                result[write + 1] = 0;
                write += 2;
            } else {
                result[write++] = arr[i];
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = result[i];
        }
    }
}
