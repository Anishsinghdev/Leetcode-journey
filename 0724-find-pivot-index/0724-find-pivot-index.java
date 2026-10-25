class Solution {
    public int pivotIndex(int[] nums) {
        int left = 0;
        int sum = calculatesum(nums);
        for(int i=0;i<nums.length;i++){
            int right = sum-nums[i]-left;
            if(left == right){
                return i;
            }
            left+= nums[i];
        }
        return -1;

        
    }
    public int calculatesum(int[] nums){
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }
        return sum;
    }
}