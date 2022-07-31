class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        s = " " + s;
        p = " " + p;
        boolean[][] f = new boolean[n + 1][m + 1];
        // 边界 f[0][0] = true, f[i][0] = false(空模式匹配任何字符串都不成功), 如果前j个字符都是*号 f[0][j] = true
        f[0][0] = true;
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j) == '*') f[0][j] = true;
            else break;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) f[i][j] = f[i - 1][j - 1];
                else if (p.charAt(j) == '*') f[i][j] = f[i][j - 1] || f[i - 1][j];
            }
        }
        return f[n][m];
    }
}