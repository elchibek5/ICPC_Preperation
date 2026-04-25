class Solution {
    public int hIndex(int[] citations) {
        int[] bucket = new int[citations.length + 1];

        for (int c : citations) {
            if (c >= citations.length) {
                bucket[citations.length]++;
            } else {
                bucket[c]++;
            }
        }

        int paperFound = 0;
        for (int i = citations.length; i >= 0; i--) {
            paperFound += bucket[i];
            if (paperFound >= i) {
                return i;
            }
        }

        return 0;
    }
}
