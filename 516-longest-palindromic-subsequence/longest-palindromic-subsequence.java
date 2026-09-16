class Solution {
    int [][] dp;
    int fun(int i, int j,  String s){
    if (i > j) return 0;
    if (i == j) return 1;
    if (dp[i][j] != -1) return dp[i][j];
    int m = 0;
    if(s.charAt(i) == s.charAt(j)) {
            int a = 2 + fun(i + 1, j - 1, s);
            m = Math.max(m,a);
        }else{
            int a = fun(i+1, j, s);
             int b = fun(i, j-1, s);
             m = Math.max(m,a);
             m = Math.max(m,b);
        }
    
    return dp[i][j]= m;
}
    public int longestPalindromeSubseq(String s) {
        dp = new int[1005][1005];
        for(int i=0; i<1002; i++){
            Arrays.fill(dp[i], -1);
        }
        return fun(0,s.length()-1, s);
    }
}