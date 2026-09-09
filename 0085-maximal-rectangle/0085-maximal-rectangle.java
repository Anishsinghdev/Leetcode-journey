import java.util.*;

class Solution {

    public int maximalRectangle(char[][] arr) {

        int n = arr.length;        // rows
        int m = arr[0].length;     // columns

        int[] heights = new int[m];

        int maxarea = 0;           // ✅ outside loop

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {   // ✅ m, not n

                if (arr[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            int area = largestrectangle(heights);

            maxarea = Math.max(maxarea, area);
        }

        return maxarea;
    }


    public int largestrectangle(int[] arr) {

        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        // Right smaller
        for (int i = n - 1; i >= 0; i--) {

            while (!st.empty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            right[i] = st.empty() ? n : st.peek();

            st.push(i);
        }

        // Clear stack
        while (!st.empty()) {
            st.pop();
        }

        // Left smaller
        for (int i = 0; i < n; i++) {

            while (!st.empty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            left[i] = st.empty() ? -1 : st.peek();

            st.push(i);
        }

        // Calculate maximum area
        int ans = 0;

        for (int i = 0; i < n; i++) {

            int width = right[i] - left[i] - 1;

            int currArea = arr[i] * width;

            ans = Math.max(ans, currArea);
        }

        return ans;
    }
}