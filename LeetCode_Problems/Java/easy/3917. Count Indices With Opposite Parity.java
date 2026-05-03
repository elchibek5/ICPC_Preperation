class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int value = 0;
            int odd = 0;
            for (int j = i ; j < n; j++) {
                if (nums[i] % 2 == 0 && nums[j] % 2 == 1) {
                    value++;
                } else if (nums[i] % 2 == 1 && nums[j] % 2 == 0){
                    odd++;
                }
            }
            if (nums[i] % 2 == 0) {
                arr[i] = value;
            } else {
                arr[i] = odd;
            }
        }

        return arr;
    }
}
