class Solution {
    public int minMoves(int[] nums, int limit) {

        int[] diff = new int[2 * limit + 2];
        int n = nums.length;
        
        for (int i = 0; i < n / 2; i++) {
            int A = nums[i];
            int B = nums[n - 1 - i];
            
            if (A > B) {
                int temp = A;
                A = B;
                B = temp;
            }
            
            diff[2] += 2;
            diff[2 * limit + 1] -= 2;
            
            diff[A + 1] -= 1;
            diff[B + limit + 1] += 1;
            
            diff[A + B] -= 1;
            diff[A + B + 1] += 1;
        }
        
        int minMoves = Integer.MAX_VALUE;
        int currentMoves = 0;
        
        for (int x = 2; x <= 2 * limit; x++) {
            currentMoves += diff[x];
            if (currentMoves < minMoves) {
                minMoves = currentMoves;
            }
        }
        
        return minMoves;
    }
}
