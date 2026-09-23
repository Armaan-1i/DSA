class Solution {
    int[][] dp;
    int fun(int i, int j, int[] nums1, int[] nums2) {
        if (i >= nums1.length || j >= nums2.length) return 0;
        if (dp[i][j] != -1)  return dp[i][j];
    
        if (nums1[i] == nums2[j]) {
            return dp[i][j] = 1 + fun(i + 1, j + 1, nums1, nums2);
        }

        int a = fun(i + 1, j, nums1, nums2);
        int b = fun(i, j + 1, nums1, nums2);

        return dp[i][j] = Math.max(a, b);
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fun(0, 0, nums1, nums2);
    }
}