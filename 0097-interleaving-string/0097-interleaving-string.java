class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];

        return solve(0, 0, s1, s2, s3, memo);
    }

    private boolean solve(int i, int j,
                          String s1, String s2, String s3,
                          Boolean[][] memo) {

        // Both strings completely used
        if (i == s1.length() && j == s2.length()) {
            return true;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int k = i + j;

        boolean takeS1 = false;
        boolean takeS2 = false;

        // Take character from s1
        if (i < s1.length() &&
            s1.charAt(i) == s3.charAt(k)) {

            takeS1 = solve(i + 1, j, s1, s2, s3, memo);
        }

        // Take character from s2
        if (j < s2.length() &&
            s2.charAt(j) == s3.charAt(k)) {

            takeS2 = solve(i, j + 1, s1, s2, s3, memo);
        }

        memo[i][j] = takeS1 || takeS2;

        return memo[i][j];
    }
}