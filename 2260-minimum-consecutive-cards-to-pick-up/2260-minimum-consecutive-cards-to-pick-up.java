import java.util.HashMap;

class Solution {
    public int minimumCardPickup(int[] cards) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int min = Integer.MAX_VALUE;

        for (int high = 0; high < cards.length; high++) {

            // If card already exists
            if (map.containsKey(cards[high])) {

                int previousIndex = map.get(cards[high]);

                int length = high - previousIndex + 1;

                min = Math.min(min, length);
            }

            // Store/update last index
            map.put(cards[high], high);
        }

        if (min == Integer.MAX_VALUE) {
            return -1;
        }

        return min;
    }
}