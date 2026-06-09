class Solution {
    public int hammingDistance(int x, int y) {
        int current = x ^ y;
        return Integer.bitCount(current);
    }
}
