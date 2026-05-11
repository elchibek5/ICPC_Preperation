class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];

            ArrayList<Integer> currentDigits = new ArrayList<>();

            while (temp > 0) {
                int lastDigit = temp % 10;
                currentDigits.add(0, lastDigit);
                temp /= 10;
            }

            list.addAll(currentDigits);
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
