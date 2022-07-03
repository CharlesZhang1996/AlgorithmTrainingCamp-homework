class Solution {
    int m;
    int n;
    char[][] board;
    int[] dx;
    int[] dy;
    public void solve(char[][] board) {
        this.board = board;
        dx = new int[] {-1, 0, 1, 0};
        dy = new int[] {0, 1, 0, -1};
        n = board.length;
        if (n == 0) {
            return;
        }
        // 从边界开搜，遇到'O'就先改为'A'
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(i, 0);
            dfs(i, m - 1);
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(0, i);
            dfs(n - 1, i);
        }
        // 把'O'改为'X', 同时把之前改成'A'的点改回来
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    void dfs(int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= m || board[row][col] != 'O'){
            return;
        }
        board[row][col] = 'A';
        for (int i = 0; i < 4; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            dfs(nextRow, nextCol);

        }
    }
}
