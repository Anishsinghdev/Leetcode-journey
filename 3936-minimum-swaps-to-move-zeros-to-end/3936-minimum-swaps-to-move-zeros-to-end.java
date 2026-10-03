class Solution {
    public int minimumSwaps(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int swaps = 0;

        while (left < right) {

            while (left < right && nums[left] != 0) {
                left++;
            }

            while (left < right && nums[right] == 0) {
                right--;
            }

            if (left < right) {

                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                swaps++;

                left++;
                right--;
            }
        }

        return swaps;
    }
}