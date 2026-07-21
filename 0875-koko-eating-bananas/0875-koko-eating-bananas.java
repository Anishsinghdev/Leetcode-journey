class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1,right = findMax(piles);
        int ans = right;
        while(left<=right){
            int mid = left+(right-left)/2;
            
            long hour = totalHours(piles, mid);
            if(hour<=h){
                ans = mid;
                right = mid-1;
                
            }
            else{
                left = mid+1;
            }
        }
        return ans;
        
    }
    private int findMax(int[] piles) {

        int max = piles[0];

        for (int pile : piles) {

            max = Math.max(max, pile);
        }

        return max;
    }

    private long totalHours(int[] piles, int speed) {

        long hours = 0;

        for (int pile : piles) {

            hours += (pile + speed - 1) / speed;
        }

        return hours;
    }
}