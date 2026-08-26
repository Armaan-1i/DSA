class Solution {
    void fun(int n, int k, int start,
             List<Integer> output,
             List<List<Integer>> ans) {
        if (output.size() == k) {
            ans.add(new ArrayList<>(output));
            return;
        }
        for (int i = start; i <= n; i++) {
            output.add(i);
            fun(n, k, i + 1, output, ans);
            output.remove(output.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        fun(n, k, 1, output, ans);
        return ans;
    }
}