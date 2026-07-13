import java.util.*;

class Solution {
    public int minimumTime(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if (m > 1 && n > 1 && grid[0][1] > 1 && grid[1][0] > 1)
            return -1;

        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            int time = cur[0];
            int r = cur[1];
            int c = cur[2];

            if (r == m - 1 && c == n - 1)
                return time;

            if (time > dist[r][c])
                continue;

            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                int nextTime = time + 1;

                if (nextTime < grid[nr][nc]) {
                    nextTime = grid[nr][nc];

                    if ((nextTime - time) % 2 == 0)
                        nextTime++;
                }

                if (nextTime < dist[nr][nc]) {
                    dist[nr][nc] = nextTime;
                    pq.offer(new int[]{nextTime, nr, nc});
                }
            }
        }

        return -1;
    }
}