
class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = findmax(piles);
        int ans = right;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            long hour = totalhour(piles, mid);

            if (hour <= h) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public int findmax(int[] piles) {
        int max = Integer.MIN_VALUE;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        return max;
    }

    public long totalhour(int[] piles, int k) {
        long hours = 0;

        for (int pile : piles) {
            hours += (pile + (long) k - 1) / k;
        }

        return hours;
    }
}
