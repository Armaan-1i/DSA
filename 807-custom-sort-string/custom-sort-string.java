class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            int index = ch - 'a';

            while (freq[index] > 0) {
                ans.append(ch);
                freq[index]--;
            }
        }

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                ans.append((char)(i + 'a'));
                freq[i]--;
            }
        }

        return ans.toString();
    }
}
