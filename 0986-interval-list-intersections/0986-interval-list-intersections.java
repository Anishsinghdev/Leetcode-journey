
import java.util.*;

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> res = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < firstList.length && j < secondList.length) {

            // Get current intervals
            int start1 = firstList[i][0];
            int end1 = firstList[i][1];

            int start2 = secondList[j][0];
            int end2 = secondList[j][1];

            // Calculate intersection
            int start = Math.max(start1, start2);
            int end = Math.min(end1, end2);

            // Check if intersection exists
            if (start <= end) {
                res.add(new int[]{start, end});
            }

            // Move pointer whose interval ends first
            if (end1 <= end2) {
                i++;
            } else {
                j++;
            }
        }

        // Convert List<int[]> into int[][]
        return res.toArray(new int[res.size()][]);
    }
}
