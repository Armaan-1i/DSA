class Solution {
    public int distinctSubseqII(String s) {
        long mod = 1000000007;
        long[] dp = new long[26];
        long total = 1;
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            long newTotal = (total * 2) % mod;
            newTotal = (newTotal - dp[x] + mod) % mod;
            dp[x] = total;
            total = newTotal;
        }
        return (int)((total - 1 + mod) % mod);
    }
}