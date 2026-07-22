class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1,right = findmax(nums);
        int answer = right;
        while(left<=right){
            int mid = left+(right-left)/2;
            int calculatesum = calcusum(nums , mid);

            if(calculatesum<=threshold){
                answer = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return answer;
    }
    private int findmax(int[] nums){
        int max = nums[0];
        for(int num:nums){
            max = Math.max(max,num);
        }
        return max;
    }
    private int calcusum(int[] nums,int mid){
        int sum = 0;
        for(int num:nums){
             sum += (num + mid - 1) / mid;
        }
    return sum;
    }
}