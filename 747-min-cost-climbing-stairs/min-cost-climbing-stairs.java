class Solution {
    int[] dp = new int[1005];
    int fun(int i, int[] cost) {
        if (i == cost.length) {
            return 0;
        }
        if (i > cost.length) {
            return Integer.MAX_VALUE;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int oneStep = fun(i + 1, cost);
        int twoStep = fun(i + 2, cost);
        int min = Math.min(oneStep, twoStep);

        if (min == Integer.MAX_VALUE) {
            return dp[i] = Integer.MAX_VALUE;
        }
        return dp[i] = cost[i] + min;
    }
    public int minCostClimbingStairs(int[] cost) {
        Arrays.fill(dp, -1);
        return Math.min(fun(0, cost), fun(1, cost));
    }
}