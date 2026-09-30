class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[]ans = new int[n];

        int left = 0;
        int right = n-1;
        int high = n-1;
    
    while(left<=right){
        if(Math.abs(nums[left])>Math.abs(nums[right])){
            ans[high] = nums[left]*nums[left];
            left++;
        }
        else{
             ans[high] = nums[right]*nums[right];
             right--;
        }
        high--;
    }
    return ans;
    }
}