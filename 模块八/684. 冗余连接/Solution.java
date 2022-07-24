class Solution {
    int[] fa;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        fa = new int[n + 1];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }

        for (int i = 0; i < n; i++) {
            // 如果这两个点目前不连通，则将这条边连起来不会导致环出现
            if (find(edges[i][0]) != find(edges[i][1])) {
                unionSet(edges[i][0], edges[i][1]);
            } else {
                // 第一次发现两个点已经都在同一个连通集合里时，返回这条多余的边，这条边会导致环的出现
                return edges[i];
            }
        }
        return new int[0];
    }

    private void unionSet(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) fa[x] = y;
    }

    private int find(int x) {
        if (fa[x] == x) return x;
        return fa[x] = find(fa[x]);
    }
}