class Solution {
    public void rotate(int[] nums, int k) {
        int size = nums.length;
        
        k %= size;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
// class Solution {
//     public void rotate(int[] nums, int k) {
//         int size = nums.length;
//         int[] answer = new int[size];
//         int aim_pointer = (size - (k % size)) % size;

//         for (int i = 0; i < size; i++) {
//             answer[i] = nums[aim_pointer++];
//             if (aim_pointer == size) {
//                 aim_pointer = 0;
//             }
//         }

//         for (int i = 0; i < size; i++) {
//             nums[i] = answer[i];
//         }
//     }
// }
