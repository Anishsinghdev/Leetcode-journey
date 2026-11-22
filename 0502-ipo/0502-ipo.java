import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

       
        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));


        PriorityQueue<int[]> maxProfitHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        
        for (int i = 0; i < n; i++) {
            minCapitalHeap.offer(new int[]{capital[i], profits[i]});
        }

     
        for (int i = 0; i < k; i++) {
           
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w) {
                maxProfitHeap.offer(minCapitalHeap.poll());
            }

            
            if (maxProfitHeap.isEmpty()) {
                break;
            }

            
            w += maxProfitHeap.poll()[1];
        }

        return w;
    }
}