class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0) return false;

        int original = x;
        StringBuilder sb = new StringBuilder();

        while (x > 0) {
            int lastDigit = x % 10;
            sb.append(lastDigit);
            x = x / 10;
        }
        String reversed = sb.toString();
        String originalStr = Integer.toString(original);

        return reversed.equals(originalStr);
    }
}
