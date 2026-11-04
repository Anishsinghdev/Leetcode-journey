
import java.util.*;

class Solution {

    class MedianWindow {
        TreeMap<Integer, Integer> low = new TreeMap<>();
        TreeMap<Integer, Integer> high = new TreeMap<>();

        int lowSize = 0, highSize = 0;
        long lowSum = 0, highSum = 0;

        void addMap(TreeMap<Integer, Integer> map, int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        void removeMap(TreeMap<Integer, Integer> map, int val) {
            int count = map.get(val);

            if (count == 1) map.remove(val);
            else map.put(val, count - 1);
        }

        void add(int val) {
            if (low.isEmpty() || val <= low.lastKey()) {
                addMap(low, val);
                lowSize++;
                lowSum += val;
            } else {
                addMap(high, val);
                highSize++;
                highSum += val;
            }

            balance();
        }

        void remove(int val) {
            if (low.containsKey(val)) {
                removeMap(low, val);
                lowSize--;
                lowSum -= val;
            } else {
                removeMap(high, val);
                highSize--;
                highSum -= val;
            }

            balance();
        }

        void balance() {
            int target = (lowSize + highSize + 1) / 2;

            while (lowSize > target) {
                int val = low.lastKey();

                removeMap(low, val);
                lowSize--;
                lowSum -= val;

                addMap(high, val);
                highSize++;
                highSum += val;
            }

            while (lowSize < target) {
                int val = high.firstKey();

                removeMap(high, val);
                highSize--;
                highSum -= val;

                addMap(low, val);
                lowSize++;
                lowSum += val;
            }
        }

        long getCost() {
            long median = low.lastKey();

            return median * lowSize - lowSum
                   + highSum - median * highSize;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        // Step 1: Calculate cost of every window of size x
        long[] cost = new long[n - x + 1];

        MedianWindow window = new MedianWindow();

        for (int i = 0; i < x; i++) {
            window.add(nums[i]);
        }

        cost[0] = window.getCost();

        for (int i = x; i < n; i++) {
            window.remove(nums[i - x]);
            window.add(nums[i]);

            cost[i - x + 1] = window.getCost();
        }

        // Step 2: DP for selecting k non-overlapping windows
        long INF = Long.MAX_VALUE / 2;

        long[][] dp = new long[k + 1][n + 1];

        for (int j = 0; j <= k; j++) {
            Arrays.fill(dp[j], INF);
        }

        // Zero windows require zero operations
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int j = 1; j <= k; j++) {

            for (int i = 1; i <= n; i++) {

                // Option 1: Skip current element
                dp[j][i] = dp[j][i - 1];

                // Option 2: Take window ending at i - 1
                if (i >= x) {

                    long previous = dp[j - 1][i - x];

                    if (previous != INF) {
                        dp[j][i] = Math.min(
                            dp[j][i],
                            previous + cost[i - x]
                        );
                    }
                }
            }
        }

        return dp[k][n];
    }
}
