class Solution {
    int[][] dp;
    int fun(int left, int right, int[] nums) {
        if (left > right) {
            return 0;
        }
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        int ans = 0;
        for (int k = left; k <= right; k++) {
            int coins = nums[left - 1] * nums[k] * nums[right + 1];
            int leftPart = fun(left, k - 1, nums);
            int rightPart = fun(k + 1, right, nums);
            int total = coins + leftPart + rightPart;
            ans = Math.max(ans, total);
        }
        return dp[left][right] = ans;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        dp = new int[n + 2][n + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return fun(1, n, arr);
    }
}