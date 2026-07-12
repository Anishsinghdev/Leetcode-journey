class Solution {
    public int findNthDigit(int n) {
        long digits = 1;
        long count = 9;
        long start = 1;

        // Find the block where the nth digit belongs
        while (n > digits * count) {
            n -= digits * count;
            digits++;
            count *= 10;
            start *= 10;
        }

        // Find the actual number
        start += (n - 1) / digits;

        // Find the digit inside that number
        String number = Long.toString(start);
        return number.charAt((int) ((n - 1) % digits)) - '0';
    }
}