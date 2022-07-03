class Solution {
    int ans;
    int lower;
    int upper;
    public int countRangeSum(int[] nums, int lower, int upper) {
        ans = 0;
        this.lower = lower;
        this.upper = upper;
        long[] sum = new long[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            System.out.println(sum[i]);
        }
        mergeSort(sum, 0, sum.length - 1);
        return ans;
    }

    private void mergeSort(long[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        // 统计两边的区间和
        calculate(nums, l, mid, r);
        merge(nums, l, mid, r);
    }

    private void calculate(long[] nums, int l, int mid, int r) {
        int right = mid + 1;
        int left = mid + 1;
        // 双指针来分别维护满足上下界的条件
        //因为两边的区间数组都已经各自排序，当i往右移时，右区间符合条件的左右边界的指针也只会往右移动
        for (int i = l; i <= mid; i++) {
            // 右边界，小于上界的话就往右移，直到下一个数大于上界则停止在最后一个满足区间上界的下标处
            while (right <= r && nums[right] <= upper + nums[i]) {
                right++;
            }
            // 左边界，小于下界的话就往右移，直到第一个满足下界的下标处停止
            while (left <= r && nums[left] < lower + nums[i]) {
                left++;
            }
            ans += right - left;
        }
    }

    private void merge(long[] nums, int l, int mid, int r) {
        int length = r - l + 1;
        long[] temp = new long[length];
        int first = l;
        int second = mid + 1;
        for (int i = 0; i < length; i++) {
            if (second > r || (first <= mid && nums[first] <= nums[second])) {
                temp[i] = nums[first];
                first++;
            } else {
                temp[i] = nums[second];
                second++;
            }
        }
        for (int i = l; i <= r; i++) {
            nums[i] = temp[i - l];
        }
    }
}