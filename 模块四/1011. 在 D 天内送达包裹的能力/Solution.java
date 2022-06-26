class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            max = Math.max(max, weights[i]);
            sum += weights[i];
        }

        // 二分查答案，初始的左边界要等于最大的货物，右边界是所有货物的重量总和
        int left = max, right = sum;
        while (left < right) {
            int mid = (left + right) / 2;
            // 判断能否运完
            if (canFinish(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    boolean canFinish(int[] weights, int days, int capacity) {
        // 需要几天
        int cnt = 1;
        // 这一趟要运多重的货
        int curr = 0;
        for (int i = 0; i < weights.length; i++) {
            if (curr + weights[i] > capacity) {
                ++cnt;
                curr = 0;
            }
            curr += weights[i];
        }
        return cnt <= days;
    }
}