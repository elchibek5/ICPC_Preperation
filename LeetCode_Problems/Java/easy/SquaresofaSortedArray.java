class Solution {
    public int[] sortedSquares(int[] nums) {
        int A = nums.length - 1;
        int[] answer = new int[nums.length];

        int left = 0;
        int right = A;

        for (int i = A; i >= 0; i --) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                answer[i] = nums[left] * nums[left];
                left++;
            } else {
                answer[i] = nums[right] * nums[right];
                right--;
            }
        }
        return answer;
    }
}


// class Solution {
//     public int[] sortedSquares(int[] nums) {
//         int[] answer = new int[nums.length];

//         for (int i = 0; i < nums.length; i++) {
//             answer[i] = nums[i] * nums[i];
//         }
//         Arrays.sort(answer);
//         return answer;

//     }
// }
