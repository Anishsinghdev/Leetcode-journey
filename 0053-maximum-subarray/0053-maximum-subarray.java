class Solution {
    public int maxSubArray(int[] nums) {
        int bestending = nums[0];
        int result = nums[0];
        for(int i=1;i<nums.length;i++){
            int v1 = nums[i]+bestending;
            int v2 = nums[i];
            bestending = Math.max(v1,v2);
            result = Math.max(bestending , result);
        }
        return result;
    }
}