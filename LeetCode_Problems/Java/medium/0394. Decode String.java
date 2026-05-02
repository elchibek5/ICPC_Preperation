class Solution {
    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringBuilder = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c))  {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(k);
                stringBuilder.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                StringBuilder decodedString = stringBuilder.pop();
                int a = countStack.pop();

                for (int i = 0; i < a; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(c);
            }
        }

        return currentString.toString();
    }
}
