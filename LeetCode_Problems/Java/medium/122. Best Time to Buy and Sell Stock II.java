class Solution {
    public int maxProfit(int[] prices) {
        // Greedy Approach
        int days = prices.length;
        int profit = 0;
        int buy_day = 0;
        int sell_day = 0;

        while (buy_day < days && sell_day < days) {
            while (buy_day < days - 1 && prices[buy_day] >= prices[buy_day + 1]) {
                buy_day++;
            }

            sell_day = buy_day + 1;
            while (sell_day < days - 1 && prices[sell_day] <= prices[sell_day + 1]) {
                sell_day++;
            }

            profit += prices[sell_day] - prices[buy_day];
            buy_day = sell_day + 1;
        }

        return profit;
    }
}
