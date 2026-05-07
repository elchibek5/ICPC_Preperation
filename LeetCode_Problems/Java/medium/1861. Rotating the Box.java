class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {

        int rows = boxGrid.length;
        int cols = boxGrid[0].length;

        for (int i = 0; i < rows; i++) {
            int emptySlot = cols - 1;

            for (int j = cols - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '#') {
                    boxGrid[i][j] = '.';
                    boxGrid[i][emptySlot] = '#';
                    emptySlot--;
                } else if (boxGrid[i][j] == '*') {
                    emptySlot = j - 1;
                }
            }
        }

        char[][] rotated = new char[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotated[j][rows - 1 - i] = boxGrid[i][j];
            }
        }

        return rotated;
    }
}
