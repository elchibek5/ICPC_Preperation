class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int overlap = 0;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (lastEnd > intervals[i][0]) {
                overlap++;
            } else {
                lastEnd = intervals[i][1];
            }
        }

        return overlap;
    }

    // run: O(n log n)
    // space: O(1);
}
