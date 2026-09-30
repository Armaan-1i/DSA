class Solution {
    void fun(String str,int a, int b, int n, List<String> ans) {
        // if( b>a){
        //     return;
        // }
        if (str.length() == 2 * n) {
            ans.add(str);
            return;
        }
        if(a < n){
             fun(str + "(", a + 1, b, n, ans);
        }
        if(b < a){
            fun(str + ")", a, b + 1, n, ans);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        fun("", 0, 0,n, ans);
        return ans;
    }
}
 