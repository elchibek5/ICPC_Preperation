class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];

        // Apply the "difference array" technique
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int value = update[2];

            // Add value at the start index
            result[start] += value;

            // Subtract value just after the end index (if it's within bounds)
            if (end + 1 < length) {
                result[end + 1] -= value;
            }
        }

        // Build the final array using prefix sums
        for (int i = 1; i < length; i++) {
            result[i] += result[i - 1];
        }

        return result;
    }
}
