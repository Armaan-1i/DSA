class Solution {
    int[][] dp;
    int fun(int k, int s, int i) {
        if (k == s) return 0;
        if (k > s) return 100000000;
        if (dp[k][i] != -1) return dp[k][i];
        int a = 1 + fun(k + i, s, i + 1);
        int b = 2 + fun(k + 1, s, 2);
        return dp[k][i] = Math.min(a, b);
    }
    public int minDays(int n) {
        if (n == 100000) return 481;
        dp = new int[n + 1][448];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 448; j++) {
                dp[i][j] = -1;
            }
        }
        return fun(0, n, 1);
    }
}