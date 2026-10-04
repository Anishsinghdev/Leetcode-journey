class Solution {
    public boolean checkValidString(String s) {

        int low = 0;
        int high = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                low++;
                high++;
            }
            else if (c == ')') {
                low--;
                high--;
            }
            else { // '*'
                low--;   // '*' as ')'
                high++;  // '*' as '('
            }

            // Cannot have negative open brackets
            low = Math.max(0, low);

            // Even maximum possible balance is negative
            if (high < 0) {
                return false;
            }
        }

        return low == 0;
    }
}