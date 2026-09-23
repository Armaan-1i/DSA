class Solution {
    int[][] dp;
    int fun(int i, int j, String s1, String s2){
        if(i >=s1.length()){
            int sum =0;
            for(int k = j; k< s2.length(); k++){
                sum += s2.charAt(k);
            }
            return sum;
        }
         if(j >=s2.length()){
            int sum =0;
            for(int k = i; k< s1.length(); k++){
                sum += s1.charAt(k);
            }
            return sum;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = fun (i+1 , j+1, s1, s2);
        }
        int a = s1.charAt(i)+ fun(i+1, j, s1, s2);
        int b = s2.charAt(j)+ fun(i, j+1, s1, s2);
        return dp[i][j]= Math.min(a,b);
    }
    public int minimumDeleteSum(String s1, String s2) {
          dp = new int[1005][1005];
        for (int i = 0; i < 1005; i++) {
            Arrays.fill(dp[i], -1);
        }
        return fun(0, 0, s1, s2);
    }
}