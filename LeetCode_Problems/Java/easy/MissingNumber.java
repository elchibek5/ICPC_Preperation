class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum1 = n * (n + 1) / 2;
        int sum2 = 0;
        for (int i : nums){
            sum2 += i;
        }
        return sum1 - sum2;
    }
}

// class Solution {
//     public int missingNumber(int[] nums) {
//         int nums_length = nums.length;
//         Arrays.sort(nums);
//         if (nums[0] != 0) return 0;

//         for (int i = 0; i < nums_length - 1; i++) {
//             if (nums[i + 1] != nums[i] + 1) {
//                 return nums[i] + 1;
//             } 
//         }
//         return nums_length;
//     }
// }
