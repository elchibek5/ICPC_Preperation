class Solution {
    public boolean checkGoodInteger(int n) {
        long squareSum = 0;
        long digitSum = 0;

        int s = n;

        while (s > 0) {
            int digit = s % 10;
            s = s / 10;
            digitSum += digit;
        }

        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            squareSum += (digit * digit);
        }

        return squareSum - digitSum >= 50;
    }
}
