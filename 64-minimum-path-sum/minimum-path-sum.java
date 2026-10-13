class Solution {
    int dp[][];
    public int fun( int i, int j,int[][] grid ){
        if (i == 0 && j == 0) return grid[0][0];
        if(i< 0 || j<0) return Integer.MAX_VALUE;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = fun(i-1, j, grid);
        int left = fun(i, j-1, grid);

        int ans = grid[i][j]+ Math.min(right, left);
        return dp[i][j] = ans;
    }
    public int minPathSum(int[][] grid) {
       int m = grid.length;
       int n = grid[0].length;
       dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

       return fun(m-1, n-1, grid); 
    }
}