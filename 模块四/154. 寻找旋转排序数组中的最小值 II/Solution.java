class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            // 因为后面出现与右边界重复的点的时候，会往左挪动右边界，
            // 所以不是跟nums[length - 1]去比较，而是和每一次迭代的右边界进行比较
            // 每一次更新是能够保证新的范围内一定含有最小值点的
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] == nums[right]) {
                // 这里如果出现重复元素，并不能确定最小值是出现在mid的左边区间或右边区间
                // 只能说明目前备选范围内，无论是不是最小值右边界的点都是多余的，将右边界减一
                right--;
            }
        }
        return nums[left];
    }
}