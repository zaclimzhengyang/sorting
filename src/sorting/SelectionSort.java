package sorting;

import java.util.Arrays;

public class SelectionSort {
    /**
     * selection sort is a simple and intuitive sorting algorithm that works by repeatedly finding
     * the minimum element from the unsorted part of an array and moving it to the beginning
     * of the array. the algorithm maintains two subarrays: one that is sorted and the other that
     * is unsorted. in each iteration, the smallest element from the unsorted subarray is selected
     * and swapped with the leftmost element of the unsorted subarray to grow the sorted subarray.
     *
     * here are the steps for selection sort:
     *      1. set the first element of the array as the minimum value
     *      2. compare the minimum value with the next element in the array. if the next element is
     *          smaller, update the minimum value to be the index of that element
     *      3. repeat step 2 for all the remaining elements in the array
     *      4. swap the minimum value with the leftmost unsorted element to move it to the sorted subarray
     *      5. repeat steps 1 - 4 until the entire array is sorted
     *
     * e.g.
     *      first pass:
     *          64  25  12  22  11
     *          ^               ^
     *      second pass:
     *          11  25  12  22  64
     *              ^   ^
     *      third pass:
     *          11  12  25  22  64
     *                  ^   ^
     *          11  12  22  25  64
     *                      ^ lowest
     *
     * time complexity:
     *      O(n^2) in the worst case because it has to traverse the entire unsorted part of the array in each
     *      iteration to find the minmimum element
     *
     * space complexity:
     *      O(1) as it does not require any additional space beyond the original array
     */

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {50, 70, 60, 30, 80, 10};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
