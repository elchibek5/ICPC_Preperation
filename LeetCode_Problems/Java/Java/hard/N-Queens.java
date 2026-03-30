public class Solution {
    private boolean[] cols;
    private boolean[] diag1;
    private boolean[] diag2;
    private char[][] board;
    private int n;
    private List<List<String>> answers;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        cols = new boolean[n];
        diag1 = new boolean[2*n];
        diag2 = new boolean[2*n];
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        answers = new ArrayList<>();
        backtrack(0);
        return answers;
    }

    private void backtrack(int row) {
        if (row == n) {
            List<String> sol = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                sol.add(new String(board[i]));
            }
            answers.add(sol);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols[col] || diag1[row + col] || diag2[row - col + n - 1]) {
                continue;
            }

            board[row][col] = 'Q';
            cols[col] = diag1[row + col] = diag2[row - col + n - 1] = true;

            backtrack(row + 1);

            board[row][col] = '.';
            cols[col] = diag1[row + col] = diag2[row - col + n - 1] = false;
        }
    }
}
