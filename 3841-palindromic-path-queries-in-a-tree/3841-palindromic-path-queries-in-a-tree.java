
import java.util.*;

class Solution {
    private List<Integer>[] adj;
    private int[][] up;
    private int[] depth, tin, tout;
    private int timer, LOG;
    private Fenwick bit;

    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        up = new int[LOG][n];
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];

        // Iterative DFS: avoids stack overflow on a long chain.
        int[] parent = new int[n];
        int[] iter = new int[n];
        int[] stack = new int[n];
        Arrays.fill(parent, -1);

        int top = 0;
        int root = 0;
        stack[0] = root;
        parent[root] = root;
        timer = 0;
        tin[root] = timer++;

        while (top >= 0) {
            int u = stack[top];

            if (iter[u] < adj[u].size()) {
                int v = adj[u].get(iter[u]++);

                if (v == parent[u]) continue;

                parent[v] = u;
                depth[v] = depth[u] + 1;
                tin[v] = timer++;
                stack[++top] = v;
            } else {
                tout[u] = timer - 1;
                top--;
            }
        }

        for (int i = 0; i < n; i++) {
            up[0][i] = parent[i];
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                up[j][i] = up[j - 1][up[j - 1][i]];
            }
        }

        char[] chars = s.toCharArray();
        bit = new Fenwick(n + 1);

        // Each character affects its entire subtree's root-path mask.
        for (int u = 0; u < n; u++) {
            int mask = 1 << (chars[u] - 'a');
            rangeXor(tin[u], tout[u], mask);
        }

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] p = q.split(" ");

            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                char c = p[2].charAt(0);

                int delta = (1 << (chars[u] - 'a'))
                          ^ (1 << (c - 'a'));

                if (delta != 0) {
                    rangeXor(tin[u], tout[u], delta);
                    chars[u] = c;
                }
            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);

                int w = lca(u, v);

                int mask = bit.query(tin[u])
                          ^ bit.query(tin[v])
                          ^ (1 << (chars[w] - 'a'));

                // At most one character may have odd frequency.
                ans.add((mask & (mask - 1)) == 0);
            }
        }

        return ans;
    }

    private void rangeXor(int l, int r, int mask) {
        bit.update(l, mask);
        bit.update(r + 1, mask);
    }

    private int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++) {
            if ((diff & (1 << j)) != 0) {
                u = up[j][u];
            }
        }

        if (u == v) return u;

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        }

        return up[0][u];
    }

    private static class Fenwick {
        private final int[] tree;
        private final int n;

        Fenwick(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void update(int index, int mask) {
            for (int i = index + 1; i <= n; i += i & -i) {
                tree[i] ^= mask;
            }
        }

        int query(int index) {
            int mask = 0;

            for (int i = index + 1; i > 0; i -= i & -i) {
                mask ^= tree[i];
            }

            return mask;
        }
    }
}
