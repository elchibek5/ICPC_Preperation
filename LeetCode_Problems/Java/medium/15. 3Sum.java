class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;
            int anchor = nums[i];

            while (left < right) {
                int sum = anchor + nums[left] + nums[right];
                
                if (sum == 0) {
                    list.add(Arrays.asList(anchor, nums[left], nums[right]));

                    // skipping dublicates
                    while (left < right && nums[left] == nums[left + 1]) left++;

                    // also skipping dublicates
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return list;
    }
}
