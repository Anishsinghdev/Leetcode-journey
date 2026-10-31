
import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> list = new ArrayList<>();

        // Add all existing intervals
        for (int[] interval : intervals) {
            list.add(interval);
        }

        // Add the new interval
        list.add(newInterval);

        // Sort by starting point
        list.sort((a, b) -> Integer.compare(a[0], b[0]));

        // Merge overlapping intervals
        List<int[]> res = new ArrayList<>();

        int start = list.get(0)[0];
        int end = list.get(0)[1];

        for (int i = 1; i < list.size(); i++) {

            int currStart = list.get(i)[0];
            int currEnd = list.get(i)[1];

            if (currStart <= end) {
                end = Math.max(end, currEnd);
            } else {
                res.add(new int[]{start, end});

                start = currStart;
                end = currEnd;
            }
        }

        res.add(new int[]{start, end});

        return res.toArray(new int[res.size()][]);
    }
}
