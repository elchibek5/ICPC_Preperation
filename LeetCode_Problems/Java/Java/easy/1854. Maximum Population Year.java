class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] yearChanges = new int[101];
        int offset = 1950;

        for (int[] log : logs) {
            int birth = log[0];
            int death = log[1];

            yearChanges[birth - offset] += 1;
            yearChanges[death - offset] -= 1;
        }
        
        int maxPop = 0;
        int currentPop = 0;
        int earliestYear = 1950;

        for (int i = 0; i < yearChanges.length; i++) {
            currentPop += yearChanges[i];

            if (currentPop > maxPop) {
                maxPop = currentPop;
                earliestYear = i + offset;
            }
        }
        return earliestYear;
    }
}
