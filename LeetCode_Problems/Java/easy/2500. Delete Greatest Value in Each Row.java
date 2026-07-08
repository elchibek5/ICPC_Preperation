class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }

        for (int i = grid[0].length - 1; i >= 0; i--) {
            int local_max = 0;

            for (int j = 0; j < grid.length; j++) {
                local_max = Math.max(grid[j][i], local_max);
            }
            result += local_max;
        }

        return result;
    }
}
