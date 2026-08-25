class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        int n = nums.length;

        for (int x : nums) {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }

        for (int i = 1; i <= n; i++) {
            if (!mp.containsKey(i)) {
                ans.add(i);
            }
        }

        return ans;
    }
}