class Solution {
    public void sortColors(int[] nums) {
        int low = 0, cur = 0, high = nums.length - 1;
        
        while (cur <= high) {
            if (nums[cur] == 0) {
                swap(nums, low++, cur++);
            } else if (nums[cur] == 1) {
                cur++;
            } else {
                swap(nums, cur, high--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// class Solution {
//     public void sortColors(int[] nums) {
//         int position = 0;
        
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == 0) swap(nums, i, position++);
//         }

//         for (int i = position; i < nums.length; i++) {
//             if (nums[i] == 1) swap(nums, i, position++);
//         }
//     }

//     private void swap(int[] nums, int i, int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
// }

// class Solution {
//     public void sortColors(int[] nums) {
//         boolean swapped = true;
        
//         while (swapped) {
//             swapped = false;
//             for (int i = 1; i < nums.length; i++) {
//                 if (nums[i] < nums[i - 1]) {
//                     int answer = 0;
//                     answer = nums[i];
//                     nums[i] = nums[i - 1];
//                     nums[i - 1] = answer;
//                     swapped = true;
//                 } 
//             }
//         }
//     }
// }
