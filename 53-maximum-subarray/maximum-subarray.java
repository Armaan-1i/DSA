class Solution {
    int ans = Integer.MIN_VALUE;
    int fun(int i, int[] nums) {
        if (i == nums.length) {
            return 0;
        }
        int take = nums[i] + fun(i + 1, nums);
        int startNew = nums[i];
        int cur = Math.max(take, startNew);
        ans = Math.max(ans, cur);
        return cur;
    }
    public int maxSubArray(int[] nums) {
        fun(0, nums);
        return ans;
    }
}