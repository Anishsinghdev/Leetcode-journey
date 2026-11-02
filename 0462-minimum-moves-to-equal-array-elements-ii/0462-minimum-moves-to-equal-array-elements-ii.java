
import java.util.*;

class Solution {
    public int minMoves2(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        // Find median
        int median = nums[n / 2];

        int moves = 0;

        // Calculate total moves
        for (int num : nums) {
            moves += Math.abs(num - median);
        }

        return moves;
    }
}
