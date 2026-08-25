class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        solve(nums, output, ans);

        return ans;
    }

    void solve(int[] nums, List<Integer> output,
               List<List<Integer>> ans) {

        if (output.size() == nums.length) {
            ans.add(new ArrayList<>(output));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (output.contains(nums[i])) {
                continue;
            }

            output.add(nums[i]);

            solve(nums, output, ans);

            output.remove(output.size() - 1);
        }
    }
}