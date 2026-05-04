class Solution {
    public int rotatedDigits(int n) {
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            int num = i;
            boolean valid = false;
            boolean invalid = false;

            while (num > 0) {
                int digit = num % 10;

                if (digit == 3 || digit == 4 || digit == 7) {
                    invalid = true;
                    break;
                }

                if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                    valid = true;
                }

                num /= 10;
            }

            if (valid && !invalid) {
                ans++;
            }

        }

        return ans;
    }
}
