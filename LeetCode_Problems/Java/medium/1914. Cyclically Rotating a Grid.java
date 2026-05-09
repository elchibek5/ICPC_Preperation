class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int numLayers = Math.min(m, n) / 2;

        for (int layer = 0; layer < numLayers; layer++) {
            int top = layer;
            int left = layer;
            int bottom = m - 1 - layer;
            int right = n - 1 - layer;
            
            // 1. Peel
            List<Integer> flatLayer = getElements(grid, top, left, bottom, right);
            // 2. Rotate
            int perimeter = flatLayer.size();
            int realK = k % perimeter;
            List<Integer> rotatedLayer = rotateFlatList(flatLayer, realK);
            // 3. Paste
            putElements(grid, rotatedLayer, top, left, bottom, right);
        }

        return grid;
    }

    private List<Integer> getElements(int[][]grid, int top, int left, int bottom, int right) {
        List<Integer> flatLayer = new ArrayList<>();

        for (int i = top; i <= bottom; i++) {
            flatLayer.add(grid[i][left]);
        }

        for (int i = left + 1; i <= right; i++) {
            flatLayer.add(grid[bottom][i]);
        }

        for (int i = bottom - 1; i >= top; i--) {
            flatLayer.add(grid[i][right]);
        }

        for (int i = right - 1; i > left; i--) {
            flatLayer.add(grid[top][i]);
        }

        return flatLayer;
    }

    private List<Integer> rotateFlatList(List<Integer> flatLayer, int realK) {
        List<Integer> rotated = new ArrayList<>();
        int size = flatLayer.size();
        for (int i = 0; i < size; i++) {
            rotated.add(flatLayer.get((i - realK + size) % size));
        }

        return rotated;
    }

    private void putElements(int[][] grid, List<Integer> rotatedLayer, int top, int left, int bottom, int right) {
        int index = 0;

        for (int i = top; i <= bottom; i++) {
            grid[i][left] = rotatedLayer.get(index++);
        }

        for (int i = left + 1; i <= right; i++) {
            grid[bottom][i] = rotatedLayer.get(index++);
        }

        for (int i = bottom - 1; i >= top; i--) {
            grid[i][right] = rotatedLayer.get(index++);
        }

        for (int i = right - 1; i > left; i--) {
            grid[top][i] = rotatedLayer.get(index++);
        }
    }
}
