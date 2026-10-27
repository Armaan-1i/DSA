class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            freq[idx]--;
            if (visited[idx]) {
                continue;
            }
            while (ans.length() > 0 &&
                   ans.charAt(ans.length() - 1) > ch &&
                   freq[ans.charAt(ans.length() - 1) - 'a'] > 0) {

                char last = ans.charAt(ans.length() - 1);
                visited[last - 'a'] = false;
                ans.deleteCharAt(ans.length() - 1);
            }
            ans.append(ch);
            visited[idx] = true;
        }
        return ans.toString();
    }
}
