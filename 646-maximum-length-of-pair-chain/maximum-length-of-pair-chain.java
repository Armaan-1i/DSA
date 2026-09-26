class Solution {
    int [][] dp;
    int fun(int i, int p, int[][] pairs) {
        if (i >= pairs.length)    return 0;

        if (p != -1 && dp[i][p] != -1) {
            return dp[i][p];
        }
     int ans = 0;
        for (int j = i; j < pairs.length; j++) {

            if (p == -1 || pairs[j][0] > pairs[p][1]) {
                int take = 1 + fun(j + 1, j, pairs);
                ans = Math.max(ans, take);
            }
        }
        if (p != -1) {
            dp[i][p] = ans;
        }


        return ans;
    }


    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int n = pairs.length;
        dp = new int[1005][1005];

        for(int i = 0; i< 1005; i++){
            Arrays.fill(dp[i], -1);
        }

        return fun(0, -1, pairs);
    }
}