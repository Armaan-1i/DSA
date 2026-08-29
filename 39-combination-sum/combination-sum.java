class Solution {

    void fun(int[] nums, int target, int i,
             List<Integer> output,
             List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(output));
            return;
        }

        if (i == nums.length || target < 0) {
            return;
        }

        // Take
        output.add(nums[i]);

        fun(nums, target - nums[i], i, output, ans);

        output.remove(output.size() - 1);

        // Not Take
        fun(nums, target, i + 1, output, ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        fun(candidates, target, 0, output, ans);

        return ans;
    }
}