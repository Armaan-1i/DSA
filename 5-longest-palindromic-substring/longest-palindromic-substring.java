class Solution {
    int[][] dp;
    int start = 0;
    int maxLen = 1;

    boolean check(int i, int j, String s) {
        if (i >= j)  return true;
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        if (s.charAt(i) != s.charAt(j)) {
            dp[i][j] = 0;
            return false;
        }
        boolean ans = check(i + 1, j - 1, s);
        if (ans) {
            dp[i][j] = 1;
        } else {
            dp[i][j] = 0;
        }
        return ans;
    }
    void fun(int i, int j, String s) {
        if (i >= s.length()) {
            return;
        }
        if (j >= s.length()) {
            fun(i + 1, i + 1, s);
            return;
        }
        if (check(i, j, s)) {
            int len = j - i + 1;
            if (len > maxLen) {
                maxLen = len;
                start = i;
            }
        }
        fun(i, j + 1, s);
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        dp = new int[1005][1005];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        fun(0, 0, s);
        return s.substring(start, start + maxLen);
    }
}