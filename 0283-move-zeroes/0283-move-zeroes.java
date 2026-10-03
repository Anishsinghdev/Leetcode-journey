class Solution {
    public void moveZeroes(int[] nums) {

        int left = 0;
        int right = 1;

        while (left < nums.length && right < nums.length) {

            while (left < nums.length && nums[left] != 0) {
                left++;
            }

            // right ko left ke aage rakho
            right = Math.max(right, left + 1);

            while (right < nums.length && nums[right] == 0) {
                right++;
            }

            if (left < nums.length && right < nums.length) {

                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right++;
            }
        }
    }
}