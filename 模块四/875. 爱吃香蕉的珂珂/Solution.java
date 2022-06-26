class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        // 堆数等于小时数，直接返回最大的那堆的数量
        if (piles.length == h) {
            return max;
        }
        // 二分查答案
        int left = 1, right = max;
        while (left < right) {
            int mid = (left + right) / 2;
            // 判断能否吃完
            if (canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    boolean canFinish(int[] piles, int k, int h) {
        int cnt = 0;
        for (int i = 0; i < piles.length; i++) {
            // 这里对k进行整除之后向上取整的操作
            cnt += (piles[i] + k - 1) / k;
        }
        return cnt <= h;
    }
}