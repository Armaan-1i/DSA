class Solution {
    int[][] dp;
    int fun(int i, int j, String word1, String word2) {
        if (i >= word1.length() || j >= word2.length())  return 0;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = 1 + fun(i + 1, j + 1, word1, word2);
        }
        int a = fun(i + 1, j, word1, word2);
        int b = fun(i, j + 1, word1, word2);
        return dp[i][j] = Math.max(a, b);
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int lcs = fun(0, 0, word1, word2);
        return n + m - 2 * lcs;
    }
}