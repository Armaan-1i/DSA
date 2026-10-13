class Solution {
    int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        dp = new int[202][202];

        for(int i =0; i< m; i++){
           for(int j = 0; j< m; j++){
            dp[i][j] = -9999999;
           }
        }
        return func(triangle, 0, 0, dp);
    }
    public int func(List<List<Integer>> temp, int i, int j, int [][] dp){
        int m = temp.size();
        int n = temp.get(i).size();

        if(i>= m || j>= n){
            return 0;
        }
        if( dp[i][j] != -9999999){
            return dp[i][j];
        }
        if(i == m-1){
            return dp[i][j] = temp.get(i).get(j);
        }
        int down = func(temp, i+1, j, dp);
        int downright = func(temp, i+1, j+1, dp);

        dp[i][j]= temp.get(i).get(j) + Math.min(down, downright);
        return dp[i][j];
    }
}