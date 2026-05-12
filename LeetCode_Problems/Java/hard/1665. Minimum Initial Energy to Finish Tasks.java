class Solution {
    public int minimumEffort(int[][] tasks) {

        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        int energy = 0;

        for (int i = tasks.length - 1; i >= 0; i--) {
            int actual = tasks[i][0];
            int minimum = tasks[i][1];

            energy = Math.max(energy + actual, minimum);
        }

        return energy;
    }
}
