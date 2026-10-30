
import java.util.*;

class Solution {

    static class State {
        int node;
        int count;
        long cost;

        State(int node, int count, long cost) {
            this.node = node;
            this.count = count;
            this.cost = cost;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {

        // Step 1: Build adjacency list
        List<int[]>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
        }

        // Step 2: Distance array
        // dist[node][consecutive count]
        long[][] dist = new long[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        // Step 3: Min Heap
        PriorityQueue<State> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a.cost, b.cost)
        );

        // Starting node's label has count 1
        dist[0][1] = 0;
        pq.offer(new State(0, 1, 0));

        // Step 4: Dijkstra
        while (!pq.isEmpty()) {

            State curr = pq.poll();

            int u = curr.node;
            int count = curr.count;
            long cost = curr.cost;

            // Skip outdated states
            if (cost != dist[u][count]) {
                continue;
            }

            // Destination reached
            if (u == n - 1) {
                return (int) cost;
            }

            // Explore neighbours
            for (int[] edge : adj[u]) {

                int v = edge[0];
                int weight = edge[1];

                int newCount;

                if (labels.charAt(u) == labels.charAt(v)) {
                    newCount = count + 1;
                } else {
                    newCount = 1;
                }

                // Invalid consecutive characters
                if (newCount > k) {
                    continue;
                }

                long newCost = cost + weight;

                if (newCost < dist[v][newCount]) {

                    dist[v][newCount] = newCost;

                    pq.offer(
                        new State(v, newCount, newCost)
                    );
                }
            }
        }

        return -1;
    }
}
