class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        if (n == 1) return 1;
        int[] dx = new int[] {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = new int[] {0, 1, 1, 1, 0, -1, -1, -1};

        Deque<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[] {0, 0, 1});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int depth = now[2];
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || grid[nx][ny] == 1) continue;
                if (nx == n-1 && ny == n-1) return depth + 1;
                queue.offer(new int[] {nx, ny, depth + 1});
                visited[nx][ny] = true;
            }
        }
        return -1;
    }
}