
import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        Arrays.fill(ans, -1);

        Stack<Integer> st = new Stack<>();

        // Traverse the array twice, from right to left
        for (int i = 2 * n - 1; i >= 0; i--) {

            int idx = i % n;

            // Remove smaller or equal elements
            while (!st.isEmpty() && nums[st.peek()] <= nums[idx]) {
                st.pop();
            }

            // Store answer only for original array indices
            if (i < n) {
                if (!st.isEmpty()) {
                    ans[idx] = nums[st.peek()];
                }
            }

            // Store current index
            st.push(idx);
        }

        return ans;
    }
}
