class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i < nums[0]; i++) {
            ans.add(i);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }

            int dif = nums[i + 1] - nums[i];

            if (dif > 1) {
                for (int j = nums[i] + 1; j < nums[i + 1]; j++) {
                    ans.add(j);
                }
            }
        }

        for (int i = nums[nums.length - 1] + 1; i <= nums.length; i++) {
            ans.add(i);
        }
        return ans;
    }
}
