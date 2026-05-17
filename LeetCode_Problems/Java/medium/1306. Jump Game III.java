class Solution {
    public boolean canReach(int[] arr, int start) {
        if (start < 0 || start >= arr.length) {
            return false;
        }

        if (arr[start] < 0) {
            return false;
        }

        if (arr[start] == 0) {
            return true;
        }

        int jumpLength = arr[start];
        arr[start] = -arr[start];

        return canReach(arr, start - jumpLength) || canReach(arr, start + jumpLength);
    }
}
