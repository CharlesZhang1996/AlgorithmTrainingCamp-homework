class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // 设opt[i][j]为三角形顶部到第i层第j个点的最小路径和
        int[][] opt = new int[n][n];
        // 边界
        opt[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            // 递推方程
            // 最左侧节点，只能从上一层的最左侧节点过来
            opt[i][0] = opt[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                opt[i][j] = Math.min(opt[i - 1][j], opt[i - 1][j - 1]) + triangle.get(i).get(j);
            }
            // 最右侧节点，只能从上一层最右侧节点过来
            opt[i][i] = opt[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int ans = 2147483647;
        for (int i = 0; i < n; i++) {
            ans = Math.min(opt[n - 1][i], ans);
        }
        return ans;
    }
}