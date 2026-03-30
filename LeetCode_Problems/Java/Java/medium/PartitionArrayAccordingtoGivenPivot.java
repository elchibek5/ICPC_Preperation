class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        int[] result = new int[nums.length];
        int insertPosition = 0;

        int pivotFreq = 0;
        for (int num : nums) {
            if (num < pivot) {
                result[insertPosition++] = num;
            } else if (num == pivot) {
                pivotFreq++;
            }
        }

        while (pivotFreq > 0) {
            result[insertPosition++] = pivot;
            pivotFreq--;
        }
        for (int num : nums) {
            if (num > pivot){
                result[insertPosition++] = num;
            }
        }
        return result;
    }
}
