class Solution {
    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int buyPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {

            // Better buying opportunity
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            }

            // Sell if profit after fee is positive
            else if (prices[i] > buyPrice + fee) {
                profit += prices[i] - buyPrice - fee;

                // Important:
                // We sold, so now this price becomes our new effective buy price
                buyPrice = prices[i] - fee;
            }
        }

        return profit;
    }
}