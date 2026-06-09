class Solution {
    public int hammingDistance(int x, int y) {
        int current = x ^ y;
        int count = 0;

        while (current > 0) {
            if ((current & 1) == 1) count++;
            current = current >> 1;  
        }

        return count;
    }
}
