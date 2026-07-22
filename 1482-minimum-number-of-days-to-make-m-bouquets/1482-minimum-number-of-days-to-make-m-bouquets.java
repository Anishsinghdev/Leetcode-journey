class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long) m*k>bloomDay.length) return -1;
        int left = findMin(bloomDay);
         int right = findMax(bloomDay);
         int answer = right;
         while(left<=right){
            int mid = left+(right-left)/2;
            int bounqutes = countbounq(bloomDay , mid , k);
            if(bounqutes >=m){
                answer = mid;
                right = mid-1;

            }
            else{
                left = mid+1;
            }
         }

        return answer;

    
    }
    private int countbounq(int[]bloomDay , int day , int k){
        int count = 0;
        int bouqutes = 0;
        for(int bloom:bloomDay){
            if(bloom <= day)
           {
             count++;
           }else{
            bouqutes += count/k;
            count = 0;
           }
        }
        bouqutes += count/k;
        return bouqutes;
    }



    private int findMin(int[] bloomDay){
        int min = bloomDay[0];
        for(int bloom:bloomDay){
            min = Math.min(min,bloom);
        }
        return min;
    }

     private int findMax(int[] bloomDay){
        int max = bloomDay[0];
        for(int bloom:bloomDay){
            max = Math.max(max,bloom);
        }
        return max;
    }
}