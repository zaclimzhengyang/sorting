package sorting;

import java.util.Arrays;

public class QuickSort {
    /**
     * quick sort is a divide-and-conquer algorithm that works by selecting a pivot element
     * and partitioning the array into two sub-arrays, one containing elements smaller than
     * the pivot, and the other containing elements greater than the pivot. the algorithm then
     * recursively sorts each sub-array
     *
     * here is the step-by-step description of the quicksort algorithm:
     *  1. choose a pivot element from the array. this can be any element in the array, but it is
     *      often chosen to be the first or last element.
     *  2. partition the array around the pivot element by rearranging the array so that all elements
     *      less than the pivot are to the left of it, and all elements greater than the pivot are to
     *      the right of it. this can be done by using two pointers, one starting at the beginning of the
     *      array and one starting at the end, and swapping elements as necessary until the two pointers meet
     *  3. recursively sort the sub-array to the left of the pivot and the sub-array to the right of the pivot.
     *      this can be done by repeating steps 1 and 2 on each sub-array until the sub-arrays are of length 1
     *      or 0, which are already sorted
     *
     * e.g.
     *      10  80  30  90  40  50  70
     *          *   *               ^
     *      10  30  80  90  40  50  70
     *              *       *       ^
     *      10  30  40  90  80  50  70
     *                  *       *   ^
     *      10  30  40  50  80  90  70
     *                      *       *
     *      10  30  40  50  70  90  80
     *
     *  now 70 is at its correct place. all elements smaller than 70 are before it
     *  and all elements greater than 70 are after it
     *
     *      10  30  40  50  70  80  90
     *
     *
     * time complexity:
     *      O(n log n), making it a very efficient sorting algorithm. however,in the worst case, when the pivot
     *      element is consistently chosen to be minimum or maximum in the array, the time complexity can be O(n^2)
     *      to avoid this worst case, various optimizations can be made, such as choosing a randomized pivot element,
     *      or using insertion sort for small sub-arrays
     *
     * space complexity:
     *      O(1), which is constant space complexity and does not depend on the size of the input array
     *      this is only true if sorting is implemented as an in-place sorting algorithm
     *
     *      O(n), if quick sort implementation may use additional memory to hold temporary data, such as
     *      non-in-place partition algorithm is used or when recursion depth is too deep
     */

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // partition the array
            int pivotIndex = partition(arr, low, high);

            // recursively sort the left and right sub-arrays
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        // loop through the array from low to high - 1
        for (int j = low; j < high; j++) {
            // if the current element is less than or equal to the pivot,swap it with the left element
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap the pivot with the left element
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // return the index of the pivot element
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {50, 60, 20, 80, 10};
        int arrLength = arr.length;
        quickSort(arr,0, arrLength - 1);
        System.out.println(Arrays.toString(arr));
    }
}
