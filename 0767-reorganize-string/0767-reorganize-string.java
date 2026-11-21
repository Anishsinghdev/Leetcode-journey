
class Solution {
    public String reorganizeString(String s) {

        int[] freq = new int[26];

        // Count frequency
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Max Heap based on frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }

        // Check if rearrangement is possible
        int max = pq.peek()[1];

        if (max > (s.length() + 1) / 2) {
            return "";
        }

        StringBuilder ans = new StringBuilder();

        int[] prev = null;

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            // Add character to answer
            ans.append((char)(curr[0] + 'a'));
            curr[1]--;

            // Add previous character back
            if (prev != null && prev[1] > 0) {
                pq.offer(prev);
            }

            prev = curr;
        }

        return ans.toString();
    }
}
