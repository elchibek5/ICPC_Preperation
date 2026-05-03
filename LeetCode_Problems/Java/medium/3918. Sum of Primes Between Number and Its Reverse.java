class Solution {
    public int sumOfPrimesInRange(int n) {
        int reversed = reverse(n);
        int result = 0;

        for (int i = Math.min(reversed, n); i <= Math.max(reversed, n); i++) {
            if (isPrime(i)) {
                result += i;
            }
        }

        return result;
    }

    private int reverse(int num) {
        int reversed = 0;

        while (num != 0) {
            int lastDigit = num % 10;
            reversed = reversed * 10 + lastDigit;
            num /= 10;
        }
        return reversed;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;

        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6){
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}
