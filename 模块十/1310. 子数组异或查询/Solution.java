class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] xorSum = new int[n + 1];
        xorSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            xorSum[i] = xorSum[i - 1] ^ arr[i - 1];
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            // 之前算前缀的时候，前缀的下标+1了
            ans[i] = xorSum[r + 1] ^ xorSum[l];
        }
        return ans;
    }
}