// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n = nums.length;
//         int sqrt = (int) Math.ceil(Math.sqrt(n));
//         int[] block_max = new int[sqrt];
//         Arrays.fill(block_max, Integer.MIN_VALUE);
//         for (int i = 0; i < n; i++) {
//             int block = i / sqrt;
//             block_max[block] = Math.max(block_max[block], nums[i]);
//         }

//         int[] results = new int[n - k + 1];

//         for (int i = 0; i + k - 1 < n; i++) {
//             int l = i;
//             int r = i + k - 1;

//             int result = Integer.MIN_VALUE;
//             for (int j = l; j <= r; ) {
//                 if (j % sqrt == 0 && j + sqrt - 1 <= r) {
//                     int block = j / sqrt;
//                     result = Math.max(result, block_max[block]);
//                     j += sqrt;
//                 } else {
//                     result = Math.max(result, nums[j]);
//                     j++;
//                 }
//             }
//             results[i] = result;
//         }
//         return results;
//     }
// }

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }   
        int n = nums.length;
        int[] r = new int[n - k + 1];
        int ri = 0;

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && q.peekFirst() < i - k + 1) {
                q.pollFirst();
            }
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.pollLast();
            }

            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = nums[q.peekFirst()];
            }
        }
        return r;
    }
}
