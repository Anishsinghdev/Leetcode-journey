class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>();

        backtrack(n, 0, 0, "", ans);

        return ans;
    }

    public void backtrack(int n, int open, int close,
                           String s, List<String> ans) {

        // String complete
        if (s.length() == 2 * n) {
            ans.add(s);
            return;
        }

        // Add opening bracket
        if (open < n) {
            backtrack(n, open + 1, close, s + "(", ans);
        }

        // Add closing bracket
        if (close < open) {
            backtrack(n, open, close + 1, s + ")", ans);
        }
    }
}