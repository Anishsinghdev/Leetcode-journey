class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int maxDiff = 0;
        long k = (long) k1 + k2;

        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        long total = 0;

        for (int d : diff) {
            total += d;
        }

        if (total <= k) {
            return 0;
        }

        int[] freq = new int[maxDiff + 1];

        for (int d : diff) {
            freq[d]++;
        }

        for (int d = maxDiff; d > 0 && k > 0; d--) {
            if (freq[d] == 0) {
                continue;
            }

            int next = d - 1;
            long count = freq[d];
            long need = count;

            if (k >= need) {
                freq[next] += freq[d];
                freq[d] = 0;
                k -= need;
            } else {
                long full = k;
                freq[d] -= (int) full;
                freq[next] += (int) full;
                k = 0;
            }
        }

        long ans = 0;

        for (int d = 1; d < freq.length; d++) {
            ans += (long) d * d * freq[d];
        }

        return ans;
    }
}