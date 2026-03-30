class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int sum = nums.length;
        int odd = 0;
        int even = 1;
        
        while(odd < sum && even < sum) {
            while (odd < sum && nums[odd] % 2 == 0) {
                odd += 2;
            } 
            
            while (even < sum && nums[even] % 2 == 1) {
                even += 2;
            } 
            
            if (odd < sum && even < sum) {
                swap(nums, odd, even);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int odd, int even) {
        int temp = nums[odd];
        nums[odd] = nums[even];
        nums[even] = temp;
    }
}
