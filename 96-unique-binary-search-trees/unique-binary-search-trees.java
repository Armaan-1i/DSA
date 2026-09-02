class Solution {
    public int numTrees(int n) {
        return fun(1, n);
    }
    public int fun(int start, int end) {
        if (start >= end) {
            return 1;
        }
        int ans = 0;
        for (int i = start; i <= end; i++) {
            int left = fun(start, i - 1);
            int right = fun(i + 1, end);
            ans += left * right;
        }
        return ans;
    }
}