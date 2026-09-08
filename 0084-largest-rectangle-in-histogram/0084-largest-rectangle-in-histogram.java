class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int maxArea = 0;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= n; i++) {

            int currentHeight = (i == n) ? 0 : heights[i];

            while (!st.empty() && heights[st.peek()] > currentHeight) {

                int height = heights[st.pop()];

                int width;

                if (st.empty()) {
                    width = i;
                } else {
                    width = i - st.peek() - 1;
                }

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            if (i < n) {
                st.push(i);
            }
        }

        return maxArea;
    }
}