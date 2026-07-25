class Solution {
    public int splitArray(int[] nums, int k) {
        long left = maxbook(nums);
        long right = sumbook(nums);
        long answer = right;
        while(left<=right){
            long mid = left + (right-left)/2;
            if(isvalidbook(nums , mid ,k)){
                answer = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return (int) answer;
    }
    private boolean isvalidbook(int[] arr, long mid , int k){
        int painter = 1;
        int unit = 0;
        for(int units : arr){
            if(unit + units <= mid){
                unit+=units;
            }
            else{
                painter++;
                unit = units;
            }
        }
        return painter <=k;
        
    }
    
    
    private long sumbook(int[] arr){
        long sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        return sum;
    }
    
    
    
    private long maxbook(int[] arr){
        int max = arr[0];
        for(int num:arr){
            max = Math.max(max,num);
        }
        return max;
    }
}