class Solution {
    String fun(int i, int j, String a, String b, int carry) {
        if (i < 0 && j < 0) {
            if (carry == 1) {
                return "1";
            }
            return "";
        }
        int x = 0;
        int y = 0;
        if (i >= 0) {
            x = a.charAt(i) - '0';
        }
        if (j >= 0) {
            y = b.charAt(j) - '0';
        }
        int sum = x + y + carry;
        int digit = sum % 2;
        int newCarry = sum /2;
        return fun(i - 1, j - 1, a, b, newCarry) + digit;
    }

    public String addBinary(String a, String b) {
        return fun(a.length() - 1, b.length() - 1, a, b, 0);
    }
}