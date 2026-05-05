class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSurplus = 0;
        int currentTank = 0;
        int startNode = 0;

        for (int i = 0; i < gas.length; i++) {
            int netChange = gas[i] - cost[i];
            totalSurplus += netChange;
            currentTank += netChange;
            
            if (currentTank < 0) {
                startNode = i + 1;
                currentTank = 0;
            }
        }

        return (totalSurplus >= 0) ? startNode : -1;
    }
}
