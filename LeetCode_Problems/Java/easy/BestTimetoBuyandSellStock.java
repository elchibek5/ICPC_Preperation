class Solution {
    public int maxProfit(int[] prices) {
        int lowest_price = prices[0];
        int highest_profit = 0;
        
        for (int current_price : prices) {
            highest_profit = Math.max(highest_profit, current_price - lowest_price);
            lowest_price = Math.min(lowest_price, current_price);
        }
        return highest_profit;
    }
}

/*
lowest_price = 7;
highest_profit = 0;

highest_profit = Max(0, 7 - 7) -> 0;
                     0, 1 - 7  -> 0;

lowest_price = Min(7, 7);
                   7, 1 -> 1
*/
