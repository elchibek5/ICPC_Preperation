class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Integer> stack = new Stack<>();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = num.charAt(i) - '0';
        }

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > arr[i]) {
                stack.pop();
                k--;
            }
            stack.push(arr[i]);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
