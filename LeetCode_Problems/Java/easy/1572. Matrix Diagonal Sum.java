class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;

        int last = mat.length - 1;
        for (int i = 0; i < mat.length; i++) {
            
            int first = mat[i][i];
            int second = mat[i][last];
            
            if (last == i) {
                sum += first;
            } else {
                sum += first;
                sum += second;
            }

            last--;
        }

        return sum;
    }
}
