class Solution {

    Set<String> result = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {

        int removeLeft = 0;
        int removeRight = 0;

        // Find minimum number of '(' and ')' to remove
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                removeLeft++;
            } 
            else if (ch == ')') {

                if (removeLeft > 0) {
                    removeLeft--;
                } else {
                    removeRight++;
                }
            }
        }

        // Backtracking
        dfs(s, 0, 0, 0, removeLeft, removeRight, new StringBuilder());

        return new ArrayList<>(result);
    }

    private void dfs(
        String s,
        int index,
        int left,
        int right,
        int removeLeft,
        int removeRight,
        StringBuilder current
    ) {

        // End of string
        if (index == s.length()) {

            if (removeLeft == 0 &&
                removeRight == 0 &&
                left == right) {

                result.add(current.toString());
            }

            return;
        }

        char ch = s.charAt(index);

        // Remove current character
        if (ch == '(' && removeLeft > 0) {

            dfs(
                s,
                index + 1,
                left,
                right,
                removeLeft - 1,
                removeRight,
                current
            );
        }

        if (ch == ')' && removeRight > 0) {

            dfs(
                s,
                index + 1,
                left,
                right,
                removeLeft,
                removeRight - 1,
                current
            );
        }

        // Keep current character
        current.append(ch);

        if (ch != '(' && ch != ')') {

            dfs(
                s,
                index + 1,
                left,
                right,
                removeLeft,
                removeRight,
                current
            );

        } 
        else if (ch == '(') {

            dfs(
                s,
                index + 1,
                left + 1,
                right,
                removeLeft,
                removeRight,
                current
            );

        } 
        else if (right < left) {

            dfs(
                s,
                index + 1,
                left,
                right + 1,
                removeLeft,
                removeRight,
                current
            );
        }

        // Backtrack
        current.deleteCharAt(current.length() - 1);
    }
}