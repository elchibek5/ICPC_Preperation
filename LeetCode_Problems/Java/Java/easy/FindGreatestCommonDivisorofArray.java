class Solution {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n < min) min = n;
            if (n > max) max = n;
        }
        
        while (min != 0) {
            int t = max % min;
            max = min;
            min = t;
        }
        return max;
    }
}
