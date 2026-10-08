class Solution {

    public int maxSubarraySumCircular(int[] nums) {

        int total = 0;
        int curMax = 0;
        int maxSum = nums[0];
        int curMin = 0;
        int minSum = nums[0];
        for (int x : nums) {
            curMax = Math.max(x, curMax + x);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(x, curMin + x);
            minSum = Math.min(minSum, curMin);

            total += x;
        }
        if (maxSum < 0) {
            return maxSum;
        }
        int circular = total - minSum;
        return Math.max(maxSum, circular);
    }
}