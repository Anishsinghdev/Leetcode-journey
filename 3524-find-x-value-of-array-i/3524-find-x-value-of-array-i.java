class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {

            int mod = num % k;
            long[] newDp = new long[k];

            // Start a new subarray
            newDp[mod]++;

            // Extend previous subarrays
            for (int r = 0; r < k; r++) {
                int newRemainder = (r * mod) % k;
                newDp[newRemainder] += dp[r];
            }

            dp = newDp;

            // Add subarrays ending at current index
            for (int r = 0; r < k; r++) {
                ans[r] += dp[r];
            }
        }

        return ans;
    }
}