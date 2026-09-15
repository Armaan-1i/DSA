class Solution {
    int [][] dp;
    int fun(int i, int j,String s, String t) {
        if (i == s.length() || j == t.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if (s.charAt(i) == t.charAt(j)) {
            return 1 + fun(i+1, j+1,s, t);
        }
        int a = fun(i+1, j, s, t);
        int b = fun(i, j+1, s, t);
        return dp[i][j] = Math.max(a, b);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[1002][1002];
        for(int i=0; i<1002; i++){
            Arrays.fill(dp[i], -1);
        }
        return fun(0, 0, text1, text2);
    }
}