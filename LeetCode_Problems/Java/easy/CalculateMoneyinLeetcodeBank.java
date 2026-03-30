class Solution {
    public int totalMoney(int n) {
        if (n <= 7) {
            return n * (n + 1) / 2;
        }

        int weeks = n / 7;
        int remainingDays = n % 7;

        if (remainingDays == 0) {
            return totalMoney(n - 7) + 28 + 7 * (weeks - 1);
        }
        
        return totalMoney(n - remainingDays) 
            + (remainingDays * weeks) 
            + remainingDays * (remainingDays + 1) / 2;
    }
}
