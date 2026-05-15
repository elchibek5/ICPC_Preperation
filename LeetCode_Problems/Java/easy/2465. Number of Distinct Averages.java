class Solution {
    public int distinctAverages(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        Arrays.sort(nums);

        int l = 0; int r = nums.length - 1;

        while (l < r) {
            int sum = nums[l] + nums[r];

            set.add(sum);
            l++;
            r--;
        }

        return set.size();
    }
}
