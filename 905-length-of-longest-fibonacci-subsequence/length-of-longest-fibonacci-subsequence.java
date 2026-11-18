class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;

        int[][] dp = new int[n][n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);

            for (int j = 0; j < n; j++) {
                dp[i][j] = 2;
            }
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int prev = arr[j] - arr[i];

                if (map.containsKey(prev)) {
                    int k = map.get(prev);
                    if (k < i) {
                        dp[i][j] = dp[k][i] + 1;
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
        }

        return ans >= 3 ? ans : 0;
    }
}
