class Solution {
    private static List<List<Integer>> ans;
    private static LinkedList<Integer> chosen;
    private boolean[] used;
    private int n;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<List<Integer>>();
        chosen = new LinkedList<Integer>();
        n = nums.length;
        used = new boolean[n];
        Arrays.sort(nums);
        recur(nums, 0);
        return ans;
    }

    private void recur(int[] nums, int pos) {
        if(pos == n) {
            ans.add(new ArrayList<Integer>(chosen));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i] && !(i > 0 && nums[i] == nums[i-1] && !used[i-1])) {
                used[i] = true;
                chosen.push(nums[i]);
                recur(nums, pos + 1);
                used[i] = false;
                chosen.pop();
            }
        }
    }
}