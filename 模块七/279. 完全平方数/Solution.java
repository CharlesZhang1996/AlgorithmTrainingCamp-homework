class Solution {
    public int numSquares(int n) {
        /**
         类似完全背包问题，一共n个数，体积为i * i，价值1，可以取无限次，容积为n，求min
         状态：设f[i, j] 为前i个数中，和为 j 的完全平方数的最少数量
         决策：f[i, j] = min   f[i - 1, j], f[i, j - i * i] + 1 (if j >= i * i)
         初值 f[0][0] = 0 其余为正无穷
         目标f[n][n]
         简化掉第一层循环
         */
        int[] f = new int[n + 1];
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            f[i] = 2147483647;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                f[j] = Math.min(f[j], f[j - i * i] + 1);
            }
        }
        return f[n];
    }
}