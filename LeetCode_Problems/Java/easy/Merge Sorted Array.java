class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int tail1 = m - 1;
        int tail2 = n - 1;
        int insertPosition = m + n - 1;

        while (tail2 >= 0) {
            if (tail1 >= 0 && nums1[tail1] > nums2[tail2]) {
                nums1[insertPosition--] = nums1[tail1--];
            } else {
                nums1[insertPosition--] = nums2[tail2--];
            }
        }

        // int p1 = m - 1;
        // int p2 = n - 1;
        // int p = m + n - 1;

        // while (p1 >= 0 && p2 >= 0) {
        //     if (nums1[p1] > nums2[p2]) {
        //         nums1[p] = nums1[p1];
        //         p1--;
        //     } else {
        //         nums1[p] = nums2[p2];
        //         p2--;
        //     }
        //     p--;
        // }
        // while (p2 >= 0) {
        //     nums1[p] = nums2[p2];
        //     p2--;
        //     p--;
        // }
    }
}
