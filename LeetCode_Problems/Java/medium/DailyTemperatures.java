// class Solution {
//     public int[] dailyTemperatures(int[] temp) {
//         int n = temp.length;
//         int[] ans = new int[n];

//         Deque<Integer> stack = new ArrayDeque<>();

//         for (int i = 0; i < n; i++) {
//             while (!stack.isEmpty() && temp[i] > temp[stack.peek()]) {
//                 int prev = stack.pop();
//                 ans[prev] = i - prev;
//             }

//             stack.push(i);
//         }

//         return ans;
//     }
// }

class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] nge = new int[n];

        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && temp[st.peek()] <= temp[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                nge[i] = st.peek() - i;
            }

            st.push(i);
        }
        return nge;
    }
}
