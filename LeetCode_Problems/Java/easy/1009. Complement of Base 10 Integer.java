class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }

        int ans = 0;
        int power = 1;

        while (n > 0) {
            int digit = n % 2;

            if (digit == 0) {
                digit = 1;
            } else {
                digit = 0;
            }

            ans += digit * power;

            power *= 2;
            n /= 2;
        }

        return ans;
    }
}
