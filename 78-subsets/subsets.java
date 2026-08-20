class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        fun(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void fun(int[] nums, int i, List<Integer> list, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        fun(nums, i + 1, list, ans);

        list.add(nums[i]);
        fun(nums, i + 1, list, ans);
        list.remove(list.size() - 1);
    }
}