class Solution {
    public int findDuplicate(int[] nums) {

        int slow = 0;
        int fast = 0;

        // Phase 1
        while (true) {

            slow = nums[slow];

            fast = nums[fast];
            fast = nums[fast];

            if (slow == fast) {
                break;
            }
        }

        // Phase 2
        slow = 0;

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}