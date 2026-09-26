class Solution {
    int [][] dp;
    public int findLongestChain(int[][] pairs) {
        dp = new int[ pairs.length][pairs.length];

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        for(int i=0; i< pairs.length; i++){
            Arrays.fill(dp[i], -1);
        }
        int ans = func(pairs, 0, dp);
        return ans;
    }
    public int func(int [][] pairs, int i, int [][] dp){
       
        if(i>= pairs.length){
            return 0;
        }
        if(dp[i][0] != -1){
            return dp[i][0];
        }
        int id = pairs.length;
    //     for(int j= i+1; j< pairs.length; j++){
    //         if(pairs[i][1] < pairs[j][0]){
    //             id= j;
    //             break;
    //         }   

    //     }
    int low = i+1;
    int high = pairs.length -1;
    while(low <= high){
        int mid = (low + high) / 2;
        if(pairs[mid][0] > pairs[i][1]){
            id= mid;
            high = mid -1;
        }else{
            low = mid +1;
        }
    }
        int take =1;
        if(id < pairs.length){
            take = 1 + func(pairs, id,dp);
        }
        
        int skip = func(pairs, i + 1, dp);

        dp[i][0]= Math.max(take, skip);
        return dp[i][0];
    }

}