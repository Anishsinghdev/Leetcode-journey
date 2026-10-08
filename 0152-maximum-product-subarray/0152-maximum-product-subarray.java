class Solution {
    public int maxProduct(int[] nums) {
        int maxending = nums[0];
        int minending = nums[0];
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            int v1 = nums[i];
            int v2 = nums[i]*maxending;
            int v3 = nums[i]*minending;
            maxending = Math.max(v1,Math.max(v2,v3));
            minending = Math.min(v1,Math.min(v2,v3));
            res = Math.max(res,Math.max(maxending,minending));
        }
        return res;
        
    }
}