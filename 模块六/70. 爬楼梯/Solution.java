class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] f = new int[n + 1];
        // 边界
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            // 递推方程
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}