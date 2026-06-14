class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                count++;
            }
        }

        int write = n + count - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (write < n) {
                arr[write] = arr[i];
            } 
            write--;

            if (arr[i] == 0) {
                if (write < n) {
                    arr[write] = 0;
                }
                write--;
            }
        }


    }
}
