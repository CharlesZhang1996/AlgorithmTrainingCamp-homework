class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        // 设opt[i]为以nums[i]结尾的最长递增子序列的长度
        int[] opt = new int[n];
        // 用来记录以nums[i]结尾的子序列的最优方案数
        int[] cnt = new int[n];
        int maxLength = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 边界
            opt[i] = 1;
            cnt[i] = 1;
            // opt[i] = max(opt[i], opt[j] + 1), 其中j < i 且 nums[j] < nums[i]
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // 比之前的解更优，更新opt数组并重设cnt计数值
                    if (opt[j] + 1 > opt[i]) {
                        opt[i] = opt[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (opt[j] + 1 == opt[i]) {
                        // 如果长度等于最优解，累加以nums[j]为结尾的方案数
                        cnt[i] += cnt[j];
                    }
                }
            }
            // 找最大的项并累加这些项的方案数
            if (opt[i] > maxLength) {
                maxLength = opt[i];
                ans = cnt[i];
            } else if (opt[i] == maxLength) {
                ans += cnt[i];
            }
        }
        return ans;
    }
}