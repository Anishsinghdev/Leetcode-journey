class Solution {
    public int romanToInt(String s) {

        int result = 0;

        for (int i = 0; i < s.length(); i++) {

            int current;
            int next = 0;

            // Current character ki value
            switch (s.charAt(i)) {
                case 'I': current = 1; break;
                case 'V': current = 5; break;
                case 'X': current = 10; break;
                case 'L': current = 50; break;
                case 'C': current = 100; break;
                case 'D': current = 500; break;
                default: current = 1000; // M
            }

            // Next character ki value
            if (i + 1 < s.length()) {

                switch (s.charAt(i + 1)) {
                    case 'I': next = 1; break;
                    case 'V': next = 5; break;
                    case 'X': next = 10; break;
                    case 'L': next = 50; break;
                    case 'C': next = 100; break;
                    case 'D': next = 500; break;
                    default: next = 1000; // M
                }
            }

            // Main logic
            if (current < next) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }
}