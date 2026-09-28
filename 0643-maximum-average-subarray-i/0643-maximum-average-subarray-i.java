class Solution {
    public double findMaxAverage(int[] nums, int k) {
      double average = 0;
        double sum = 0;
        double maxavg = 0.0;
        for(int high = 0;high<k;high++){
            sum += nums[high];
        }
        average = sum/k;
        maxavg = average;
        for(int high=k;high<nums.length;high++){
            int left = high-k;
            sum-=nums[left];
            sum+=nums[high];
            average = sum/k;
            maxavg = Math.max(maxavg,average);
            
          }
          return maxavg;
    }
}