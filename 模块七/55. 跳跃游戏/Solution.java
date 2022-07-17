class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        // 一步一步去看，更新能到的最远距离
        for (int i = 0; i < nums.length; i++) {
            // 发现某个下标比当前能到的最远距离远，说明到不了这个点，返回false
            if (i > farthest) return false;
            farthest = Math.max(i + nums[i], farthest);
        }
        // 遍历完，所有点都能到，返回true
        return true;
    }
}