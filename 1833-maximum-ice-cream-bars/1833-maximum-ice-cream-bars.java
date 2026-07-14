class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxCost = 0;
        for (int cost : costs) {
            maxCost = Math.max(maxCost, cost);
        }

        int[] count = new int[maxCost + 1];
        for (int cost : costs) {
            count[cost]++;
        }

        int ans = 0;

        for (int cost = 1; cost <= maxCost && coins >= cost; cost++) {
            if (count[cost] == 0) continue;

            int canBuy = Math.min(count[cost], coins / cost);
            ans += canBuy;
            coins -= canBuy * cost;
        }

        return ans;
    }
}