class Solution {
    public int countDominantElements(int[] nums) {
        int n = nums.length;
        int count = 0;
        if (n == 1) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) { 
                if (nums[0] >= nums[1]) {
                    count++;
                }
            } else if (i == n - 1) { 
                if (nums[n - 1] >= nums[n - 2]) {
                    count++;
                }
            } else {
                if (nums[i] >= (nums[i - 1] + nums[i + 1]) / 2.0) {
                    count++;
                }
            }
        }
        return count;
    }
}
