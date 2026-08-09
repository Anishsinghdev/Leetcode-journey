class Solution {
    public int search(int[] arr, int target) {
        int answer = -1;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[left] <= arr[mid]) {

                // Left half is sorted
                if (arr[left] <= target && arr[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else {

                // Right half is sorted
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}