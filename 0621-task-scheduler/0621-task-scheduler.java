
class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        // Count frequency
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        // Max Heap
        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> b - a);

        for (int f : freq) {
            if (f > 0) {
                pq.offer(f);
            }
        }

        // Cooldown Queue: {remainingFreq, availableTime}
        Queue<int[]> q = new LinkedList<>();

        int time = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {

            time++;

            // Release tasks whose cooldown is over
            if (!q.isEmpty() && q.peek()[1] <= time) {
                pq.offer(q.poll()[0]);
            }

            // Execute most frequent available task
            if (!pq.isEmpty()) {

                int count = pq.poll();
                count--;

                if (count > 0) {
                    q.offer(new int[]{count, time + n + 1});
                }
            }
        }

        return time;
    }
}
