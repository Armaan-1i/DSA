class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] count = new int[n+1];
        int duplicate = -1;
        int missing = -1;
        for (int x : nums) {
            count[x]++;
        }
        for (int i = 0; i <= n; i++) {
            if (count[i] == 2) {
                duplicate = i;
            } else if (count[i] == 0) {
                missing = i;
            }
        }
        return new int[]{duplicate, missing};
    }
}
