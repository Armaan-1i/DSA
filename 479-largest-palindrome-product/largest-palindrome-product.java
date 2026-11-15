class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;

        long max = (long) Math.pow(10, n) - 1;
        long min = (long) Math.pow(10, n - 1);

        for (long i = max; i >= min; i--) {
            long palindrome = i;
            long temp = i;

            while (temp > 0) {
                palindrome = palindrome * 10 + temp % 10;
                temp /= 10;
            }
            for (long j = max; j * j >= palindrome; j--) {
                if (palindrome % j == 0) {
                    long other = palindrome / j;

                    if (other >= min && other <= max) {
                        return (int) (palindrome % 1337);
                    }
                }
            }
        }

        return -1;
    }
}
