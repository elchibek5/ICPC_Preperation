class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < sortedNums.length; i++) {
            if (!map.containsKey(sortedNums[i])) {
                map.put(sortedNums[i], i);
            }
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = map.get(nums[i]);
        }

        return result;
    }
}
