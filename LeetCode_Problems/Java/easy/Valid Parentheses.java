class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();
                if ((c == ']' && top == '[') || (c == ')' && top == '(') || (c == '}' && top == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

// class Solution {
//     public boolean isValid(String s) {
//         Stack<Character> stack = new Stack<>();

//         for (char c : s.toCharArray()) {
//             if (c == '(') stack.push(')');
//             else if (c == '[') stack.push(']');
//             else if (c == '{') stack.push('}');
//             else if (stack.isEmpty() || stack.pop() != c) return false;
//         }
//         return stack.isEmpty();
//     }
// }

// class Solution {
//     public boolean isValid(String s) {
//         Stack<Character> stringStack = new Stack<>();

//         for (int i = 0; i < s.length(); i++) {
//             char ch = s.charAt(i);

//             if (ch == '(' || ch == '{' || ch == '[') {
//                 stringStack.push(ch);
//             }
            
//             else if (ch == '}' || ch == ')' || ch == ']') {
//                 if (stringStack.isEmpty()) {
//                     return false;
//                 }
//                 char top = stringStack.pop();
//                 if ((ch == ')' && top != '(') ||
//                     (ch == '}' && top != '{') ||
//                     (ch == ']' && top != '[')) {
//                         return false;
//                     }
//             }
//         }
//         return stringStack.isEmpty();
//     }
// }
