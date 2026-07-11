class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int width = right - left;
            int h;

            if (height[left] < height[right]) {
                h = height[left];
                left++;
            } else {
                h = height[right];
                right--;
            }

            int area = width * h;
            if (area > max) {
                max = area;
            }
        }

        return max;
    }
}