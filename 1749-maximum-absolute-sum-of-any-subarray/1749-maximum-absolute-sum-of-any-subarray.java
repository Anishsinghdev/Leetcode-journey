class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxsum =  maxsumsubarray(nums);
        int minsum = minsumsubarray(nums);
        return Math.max(Math.abs(maxsum),Math.abs(minsum));
    }

        public int maxsumsubarray(int[] nums){
            int maxsum = nums[0];
            int ans = nums[0];
            for(int i=1;i<nums.length;i++){
                int v1 = maxsum+nums[i];
                int v2 = nums[i];
                maxsum = Math.max(v1,v2);
                ans = Math.max(ans,maxsum);
            }
            return ans;
        }

        public int minsumsubarray(int[] nums){
            int minsum = nums[0];
            int ans = nums[0];
            for(int i=1;i<nums.length;i++){
                int v1 = minsum+nums[i];
                int v2 = nums[i];
                minsum = Math.min(v1,v2);
                ans = Math.min(ans,minsum);
            }
            return ans;
        }
        
}