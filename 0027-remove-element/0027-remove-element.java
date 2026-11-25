class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--; // Shrink valid array size
            } else {
                left++;  // Element is good, move forward
            }
        }
        return right;
    }
}