class Solution {
    int count = 0;
    String ans = "";
    void fun(String input, String output, int k) {
        if (input.length() == 0) {
            count++;
            if (count == k) {
                ans = output;
            }
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            String left = input.substring(0, i);
            String right = input.substring(i + 1);
            fun(left + right, output + ch, k);
            if (!ans.equals("")) {
                return;
            }
        }
    }
    public String getPermutation(int n, int k) {
        String input = "";
        for (int i = 1; i <= n; i++) {
            input += i;
        }
        fun(input, "", k);
        return ans;
    }
}