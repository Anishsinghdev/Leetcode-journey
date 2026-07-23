class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = findmax(weights);
        int right = sumelement(weights);
        int answer = right;
        while(left <= right){
            int mid = left + (right-left)/2;
            int reqdays = requiredays(weights , mid);
            if(reqdays <= days){
                answer = mid;
                right = mid-1;
                
            }
            else{
                
                left = mid+1;
            }
        }
        return answer;

    }
    private int requiredays(int[] weights,int capacity){
        int days = 1;int load = 0;
        for (int weight : weights) {

    if (load + weight > capacity) {

        days++;
        load = weight;

    } else {

        load += weight;
    }
}
        return days;
    }


    private int findmax(int[] weights){
        int max = weights[0];
        for(int weight:weights){
            max = Math.max(max,weight);
        }
        return max;
    }
    private int sumelement(int[] weights){
        int sum = 0;
        for(int weightsum:weights){
            sum += weightsum;
        }
        return sum;
    }
}