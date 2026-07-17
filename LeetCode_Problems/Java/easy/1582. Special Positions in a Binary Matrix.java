class Solution {
    public int numSpecial(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[] rowsCount = new int[rows];
        int[] colsCount = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    rowsCount[i]++;
                    colsCount[j]++;
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1 && rowsCount[i] == 1 && colsCount[j] == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
