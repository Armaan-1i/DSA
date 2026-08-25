class Solution {

    void fun(List<Integer> input, List<Integer> output,
             List<List<Integer>> ans) {

        if (input.size() == 0) {
            ans.add(new ArrayList<>(output));
            return;
        }

        for (int i = 0; i < input.size(); i++) {

            List<Integer> ip = new ArrayList<>(input);
            List<Integer> op = new ArrayList<>(output);

            if (i > 0 && ip.get(i) == ip.get(i - 1)) {
                continue;
            }

            op.add(ip.get(i));
            ip.remove(i);

            fun(ip, op, ans);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> input = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        for (int a : nums) {
            input.add(a);
        }

        Collections.sort(input);

        fun(input, output, ans);

        return ans;
    }
}