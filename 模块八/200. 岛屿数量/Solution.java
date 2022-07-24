class Solution {
    int[] fa;
    int count;
    int n;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        n = grid[0].length;
        fa = new int[n * m];
        count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    fa[num(i,j)] = num(i,j);
                    count++;
                }
            }
        }

        int[] dx = new int[] {-1, 0, 0, 1};
        int[] dy = new int[] {0, -1, 1, 0};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                for (int k = 0; k < 4; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    if (ni < 0 || nj < 0 || ni >= m || nj >= n) continue;
                    else if (grid[ni][nj] == '1') {
                        unionSet(num(i, j), num(ni, nj));
                    }
                }
            }
        }
        return count;
    }

    private void unionSet(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            fa[x] = y;
            count--;
        }
    }

    private int find(int x) {
        if (fa[x] == x) return x;
        return fa[x] = find(fa[x]);
    }

    private int num(int x, int y) {
        return x * n + y;
    }
}