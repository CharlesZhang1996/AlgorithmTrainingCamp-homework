class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // 状态：设f[i][j]为从i到j的最长回文子序列的长度，字符串长度为n，0 <= i <= j < n，才会有f[i][j] > 0，否则等于0
        // 决策：当s[i] == s[j] 时，f[i][j] = f[i+1][j-1] + 2
        //      否则，f[i][j] = max(f[i+1][j],f[i][j-1])
        // 初始条件：f[i][i] = 1，单个字符可以是回文子序列
        // 目标 f[0][n-1]
        /**
           int n = s.length();
           int[][] f = new int[n][n];
           for (int i = 0; i < n; i++) {
               f[i][i] = 1;
           }
           for (int i = n - 1; i >= 0; i--) {
               char c1 = s.charAt(i);
               for (int j = i + 1; j < n; j++) {
                   if (s.charAt(j) == c1) {
                       f[i][j] = f[i + 1][j - 1] + 2;
                   } else {
                       f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                   }
               }
            }
            return f[0][n-1];
         */
        /**
         * 考虑到每个状态在计算时，只会从二维数组的左侧，下侧，左下侧进入，且左下角的元素会在上一次遍历被更新，直接开个变量记一下
         */
        int[] f = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            f[i] = 1;
            int old = 0;
            int temp = 0;
            char c1 = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                // 更新前，把f[i + 1][j]先存一下，作为下一次遍历的左下角元素
                temp = f[j];
                if (s.charAt(j) == c1) {
                    f[j] = old + 2;
                } else {
                    // 这里是从f[i+1][j], f[i][j-1]取max
                    f[j] = Math.max(f[j], f[j - 1]);
                }
                old = temp;
            }
        }
        // 内层循环最后走到的是n-1
        return f[n - 1];
    }
}