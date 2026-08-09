class Solution {
    private int fristocurrance(int[]arr,int target){
        int frist = -1;
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid]==target){
                frist = mid;
                right = mid-1;
            } else if(arr[mid]<target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return frist;

    }
    private int lastocurrance(int[]arr,int target){
        int last = -1;
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid]==target){
                last = mid;
               left = mid+1;
            } else if(arr[mid]<target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return last;

    }
    public int[] searchRange(int[] nums, int target) {
        int frist =  fristocurrance(nums,target);
        int last =  lastocurrance(nums,target);
        return new int[]{frist , last};

        
    }
}