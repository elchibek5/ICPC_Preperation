class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        char[] stack = new char[n];
        int top = 0;

        for (int i = 0; i < n; i++) {
            char currentDigit = num.charAt(i);

            while (k > 0 && top > 0 && stack[top - 1] > currentDigit) {
                top--;
                k--;
            }

            stack[top++] = currentDigit;
        }

        String ans = new String(stack, 0, top - k);
        ans = ans.replaceFirst("^0+", "");

        return ans.isEmpty() ? "0" : ans;
    }
}
