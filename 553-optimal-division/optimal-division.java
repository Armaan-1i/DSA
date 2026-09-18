class Solution {
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return String.valueOf(nums[0]);
        }
        if (n == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder ans = new StringBuilder();
        ans.append(nums[0]).append("/(");
        for (int i = 1; i < n; i++) {
            ans.append(nums[i]);
            if (i != n - 1) {
                ans.append("/");
            }
        }
        ans.append(")");
        return ans.toString();
    }
}