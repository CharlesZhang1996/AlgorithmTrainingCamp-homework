class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int xorSum = 0;
        for (int i = 0; i < n; i++) {
            xorSum ^= nums[i];
        }
        int[] ans = new int[n];
        int max = (1 << maximumBit) - 1;
        for (int i = 0; i < n; i++) {
            ans[i] = max ^ xorSum;
            xorSum ^= nums[n - i - 1];
        }
        return ans;
    }
}