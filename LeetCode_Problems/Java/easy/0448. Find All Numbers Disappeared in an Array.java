class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int n : nums) {
            int index = Math.abs(n) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}

// class Solution {
//     public List<Integer> findDisappearedNumbers(int[] nums) {
//         Set<Integer> seen = new HashSet<>();
//         for (int n : nums) {
//             seen.add(n);
//         }

//         List<Integer> result = new ArrayList<>();
//         for (int i = 1; i <= nums.length; i++) {
//             if (!seen.contains(i)) {
//                 result.add(i);
//             }
//         }
//         return result;
//     }
// }
