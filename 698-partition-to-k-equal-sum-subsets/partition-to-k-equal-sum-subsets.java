class Solution {
    boolean fun(int i, int[] nums, int k, int target, int sum, boolean[] vis) {
        if (k == 1) {
            return true;
        }
        if (sum == target) {
            return fun(0, nums, k - 1, target, 0, vis);
        }
        for (int j = i; j < nums.length; j++) {
            if (!vis[j] && sum + nums[j] <= target) {
                vis[j] = true;
                if (fun(j + 1, nums, k, target, sum + nums[j], vis)) {
                    return true;
                }
                vis[j] = false;
            }
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int x : nums) {
            total += x;
        }
        if (total % k != 0) {
            return false;
        }
        int target = total / k;
        boolean[] vis = new boolean[nums.length];
        return fun(0, nums, k, target, 0, vis);
    }
}