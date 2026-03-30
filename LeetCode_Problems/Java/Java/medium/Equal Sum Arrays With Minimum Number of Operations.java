import java.util.*;

class Solution {
    public int minOperations(int[] nums1, int[] nums2) {

        // Feasibility check: max possible sum of one < min possible sum of other
        if (6 * nums1.length < nums2.length || 6 * nums2.length < nums1.length) {
            return -1;
        }

        int sum1 = 0, sum2 = 0;
        for (int x : nums1) sum1 += x;
        for (int x : nums2) sum2 += x;

        if (sum1 == sum2) return 0;

        // Ensure nums1 is the bigger-sum side (so diff is positive)
        if (sum1 < sum2) {
            int[] tmpArr = nums1; nums1 = nums2; nums2 = tmpArr;
            int tmpSum = sum1; sum1 = sum2; sum2 = tmpSum;
        }

        int diff = sum1 - sum2;

        // Max-heap of possible improvements (0..5)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        // Decrease big side: n -> 1 gives gain = n - 1
        for (int n : nums1) {
            int gain = n - 1;
            if (gain > 0) pq.offer(gain);
        }

        // Increase small side: n -> 6 gives gain = 6 - n
        for (int n : nums2) {
            int gain = 6 - n;
            if (gain > 0) pq.offer(gain);
        }

        int ops = 0;
        while (diff > 0 && !pq.isEmpty()) {
            diff -= pq.poll();
            ops++;
        }

        return diff <= 0 ? ops : -1;
    }
}
