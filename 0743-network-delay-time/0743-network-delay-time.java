class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int node = curr[0];
            int time = curr[1];

            if (time > dist[node]) continue;

            for (int[] nei : graph.get(node)) {
                int next = nei[0];
                int wt = nei[1];

                if (dist[node] + wt < dist[next]) {
                    dist[next] = dist[node] + wt;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}