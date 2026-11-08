class Solution {
    public int findNthDigit(int n) {
        long start = 1;
        long digits = 1;
        long count = 9;
        while (n > count * digits) {
            n -= count * digits;

            start *= 10;
            digits++;
            count *= 10;
        }
        long number = start + (n - 1) / digits;
        int index = (int) ((n - 1) % digits);
        String s = String.valueOf(number);
        return s.charAt(index) - '0';
    }
}
