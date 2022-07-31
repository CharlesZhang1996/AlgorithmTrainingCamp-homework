class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(sum[0], 1);
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (map.containsKey(sum[i] - k)) {
                ans += map.get(sum[i] - k);
            }
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        return ans;
    }
}