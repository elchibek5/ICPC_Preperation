class Solution {
    public int hammingWeight(int n) {
        int answer = 0;
        for (int i = 0; i < 31; i++) {
            int bitmask = 1 << i;

            if ((n & bitmask) > 0) {
                answer++;
            }
        }
        return answer;
    }
}
