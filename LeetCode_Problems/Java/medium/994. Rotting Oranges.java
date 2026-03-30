class Solution {
    public int orangesRotting(int[][] grid) {
        
        // directions
        int[][] dirs = {
            {0, 1},  // right
            {0, -1}, //left
            {1, 0},  // down
            {-1, 0} // up
        };

        // counting the fresh ones
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        int minutes = 0;
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                for (int[] d : dirs) {
                    int nextR = curr[0] + d[0];
                    int nextC = curr[1] + d[1];

                if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols && grid[nextR][nextC] == 1) {
                    grid[nextR][nextC] = 2; //infect
                    freshCount--;
                    queue.offer(new int[]{nextR, nextC});
                    }
                }
            }
            minutes++;
        }

        if (freshCount == 0) {
            return minutes;
        } else {
            return -1;
        }
    }
}
