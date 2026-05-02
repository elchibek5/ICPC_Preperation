// class Solution {
//     public int largestRectangleArea(int[] heights) {

//         Deque<Integer> stack = new ArrayDeque<>();
//         int max = 0;
//         for (int i = 0; i < heights.length; i++) {
//             while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
//                 int mid = stack.pop();
//                 int left = stack.isEmpty() ? -1 : stack.peek();
//                 int right = i;
//                 int width = right - left - 1;
//                 int area = heights[mid] * width;
//                 max = Math.max(max, area);
//             }
//             stack.push(i);
//         }
        
//         int right = heights.length;
//         while (!stack.isEmpty()) {
//             int mid = stack.pop();
//             int left = stack.isEmpty() ? -1 : stack.peek();
//             int width = right - left - 1;
//             int area = heights[mid] * width;
//             max = Math.max(max, area);
//         }

//         return max;
//     }
// }


class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) return 0;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = -1;
        right[n - 1] = n;

        for (int i = 1; i < n; i++) {
            int prev = i - 1;
            while (prev >= 0 && heights[prev] >= heights[i]) {
                prev = left[prev];
            }
            left[i] = prev;
        }

        for (int i = n - 2; i >= 0; i--) {
            int prev = i + 1;
            while (prev < n && heights[prev] >= heights[i]) {
                prev = right[prev];
            }
            right[i] = prev;
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }

        return maxArea;
    }
}
