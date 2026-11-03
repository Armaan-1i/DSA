class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int ans = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                int count = map.get(key) + map.get(key + 1);
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
