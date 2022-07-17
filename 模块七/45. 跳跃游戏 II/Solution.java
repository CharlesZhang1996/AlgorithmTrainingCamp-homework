class Solution {
    /**
     * 动规解法
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int n = nums.length;
        // 设f[i]为到下标为i的位置所需要的跳跃次数
        int[] f = new int[n];
        Arrays.fill(f, 2147483647);
        f[0] = 0;
        // 阶段：从0到n - 1
        for (int i = 0; i < n; i++) {
            // 决策：f[i] = f[j] + 1, j < i 且 j + nums[j] >= i;
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    f[i] = Math.min(f[j] + 1, f[i]);
                }
            }
        }
        return f[n - 1];
    }

    /**
     * 贪心的解法
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int ans = 0;
        int now = 0;
        while (now < nums.length - 1) {
            // 确定这一步能到的最远的范围
            int farthest = now + nums[now];
            if (farthest >= nums.length - 1) return ans + 1;
            // 看[now + 1, farthest]这个范围里，哪个点能到的距离越远
            int nextFarthest = farthest;
            int next = now + 1;
            for (int i = now + 1; i <= farthest; i++) {
                if (i + nums[i] > nextFarthest) {
                    nextFarthest = i + nums[i];
                    next = i;
                }
            }
            // 跳跃到能到达最远距离的那个点，并且步数加一
            now = next;
            ans++;
        }

        return ans;
    }
    /**
     * 总结，动规的想法比较自然朴素，容易想到，但是会遍历完所有的状态空间，考虑比较多冗余的情况，解决这一题时间复杂度比较高，是O(n^2)
     * 贪心算法的时间复杂度是O(n)的，中间的处理相对动规会复杂一些，而且需要证明：
     * 每跳到一个位置，它的下一个能到达的最远位置为下一步的最优解，因为这个决策能包容其他决策的结果（决策包容性）
     */
}