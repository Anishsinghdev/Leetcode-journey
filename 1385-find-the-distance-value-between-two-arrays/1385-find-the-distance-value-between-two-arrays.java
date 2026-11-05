import java.util.Arrays;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        Arrays.sort(arr2);

        int count = 0;

        for (int num : arr1) {

            int target = num - d;

            int index = lowerBound(arr2, target);

            if (index == arr2.length ||
                arr2[index] > num + d) {

                count++;
            }
        }

        return count;
    }

    public int lowerBound(int[] arr, int target) {

        int low = 0;
        int high = arr.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}