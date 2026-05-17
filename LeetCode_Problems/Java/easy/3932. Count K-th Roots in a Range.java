class Solution {
    public int countKthRoots(int l, int r, int k) {
        if (k == 1) return r - l + 1;
        int ans = 0;
        long i = 0;

        while (true) {
            long power = (long) Math.pow(i, k);
            if (power > r) break;
            if (power >= l) ans++;
            i++;
        }

        return ans;
    }
}
