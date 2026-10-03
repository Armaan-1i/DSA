class Solution {
    int[] dp;
    int fun(int i, int[] nums) {
        if (i == nums.length - 1) {
            return nums[i];
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int take = nums[i] + fun(i + 1, nums);
        int startNew = nums[i];
        return dp[i] = Math.max(take, startNew);
    }
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, fun(i, nums));
        }
        return ans;
    }
}