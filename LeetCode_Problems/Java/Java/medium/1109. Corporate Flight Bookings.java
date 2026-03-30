class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        
        int[] changes = new int[n + 2];

        for (int[] b : bookings) {
            int first = b[0];
            int last = b[1];
            int seats = b[2];

            changes[first] += seats;
            changes[last + 1] -= seats;
        }

        int[] result = new int[n];
        int runningTotal = 0;

        for (int i = 1; i <= n; i++) {
            runningTotal += changes[i];
            result[i - 1] = runningTotal;
        }

        return result;
    }
}
