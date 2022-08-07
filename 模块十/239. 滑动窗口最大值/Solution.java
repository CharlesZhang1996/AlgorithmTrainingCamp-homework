class Solution {
    PriorityQueue<int[]> queue;
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                // 这里是大根堆的条件，除了比较元素大小以外，还要有元素下标的比较
                return pair1[0] == pair2[0] ? pair2[1] - pair1[1] : pair2[0] - pair1[0];
            }
        });

        for (int i = 0; i < nums.length; i++){
            queue.offer(new int[] {nums[i], i});
            // 这里注意处理数组下标，不要超界
            if (i >= k - 1) {
                // 只要元素的下标已经超出当前的有效范围，说明堆顶元素已经失效，直接删除
                while (!queue.isEmpty() && queue.peek()[1] <= i - k) {
                    queue.poll();
                }
                int[] pair = queue.peek();
                ans[i-k+1] = pair[0];
            }

        }
        return ans;
    }
}