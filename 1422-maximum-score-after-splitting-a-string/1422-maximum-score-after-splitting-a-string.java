
class Solution {
    public int maxScore(String s) {
        int zero = 0;
        int one = 0;
        int ans = 0;

        // Count total ones
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                one++;
            }
        }

        // Try every valid split
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zero++;
            } else {
                one--;
            }

            ans = Math.max(ans, zero + one);
        }

        return ans;
    }
}
