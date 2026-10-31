
import java.util.*;

class Solution {

    int[][][] memo;
    int[][] grid;
    int m, n;

    // dir = 0 means moving right
    // dir = 1 means moving down
    int getDestination(int r, int c, int dir) {

        if (r >= m || c >= n) {
            return -1;
        }

        if (memo[r][c][dir] != -2) {
            return memo[r][c][dir];
        }

        // Empty cell: robot stops reflecting
        if (grid[r][c] == 0) {
            return memo[r][c][dir] = r * n + c;
        }

        // Mirror: change direction
        if (dir == 0) {
            // Moving right -> turn down
            return memo[r][c][dir] =
                getDestination(r + 1, c, 1);
        } else {
            // Moving down -> turn right
            return memo[r][c][dir] =
                getDestination(r, c + 1, 0);
        }
    }

    public int uniquePaths(int[][] grid) {

        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        int MOD = 1_000_000_007;

        memo = new int[m][n][2];

        for (int[][] row : memo) {
            for (int[] cell : row) {
                Arrays.fill(cell, -2);
            }
        }

        int[][] dp = new int[m][n];

        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dp[i][j] == 0) continue;

                // Try moving right
                int right = getDestination(i, j + 1, 0);

                if (right != -1) {
                    int r = right / n;
                    int c = right % n;

                    dp[r][c] = (dp[r][c] + dp[i][j]) % MOD;
                }

                // Try moving down
                int down = getDestination(i + 1, j, 1);

                if (down != -1) {
                    int r = down / n;
                    int c = down % n;

                    dp[r][c] = (dp[r][c] + dp[i][j]) % MOD;
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
