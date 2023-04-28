package sorting;

import java.util.Arrays;

public class MergeSort {
    /**
     * merge sort is a popular sorting algorithm that follows the divide-and-conquer strategy.
     * it divides the input array into two halves, sort each half recursively, and then merges
     * them into a sorted output array. the merge step is the key component of the algorithm which
     * combines the two sorted subarrays into a single sorted array
     *
     * why merge sort?
     *      it is able to handle large arrays relatively quickly.
     *      it is also stable, which means that the order of elements with equal values is preserved
     *      during the sort
     *
     *  merge sort working process:
     *      think of it as a recursive algorithm continuously splits the array in half until it cannot
     *      be further divided. this means that if the array becomes empty or has only one element left,
     *      the dividing will stop, e.g. it is the base case to stop the recursion. if the array has multiple
     *      elements, split the array into halves and recursively invoke the merge sort on each of the halves.
     *      finally, when both halves are sorted, the merge operation is applied. merge operation is the process
     *      of taking two smaller sorted arrays, and combining them to eventually make a larger one
     *
     *                  [38  27  43  3   9   82  10]
     *                                |
     *          [38   27     43  3]              [9   82  10]
     *                   |                              |
     *       [38      27]  [43     3]         [9   82]   [10]
     *            |            |                 |
     *     [38]     [27]  [43]   [3]        [9]      [82]   [10]
     *
     *     ***** start merging **********
     *     [27, 38]         [3, 43]         [9, 82]     [10]
     *          [3, 27, 38, 43]                 [9, 10, 82]
     *                  [3, 9, 10, 27, 38, 43, 82]
     *
     * time complexity:
     *      O(n log n) in the worst-case scenario. this is because the algorithm divides the input
     *      array into two halves recurisvely until the size of each subarray becomes 1. the merge
     *      step takes O(n) time to combine the two sorted subarrays into a single array. therefore,
     *      the total time complexity is O(n log n) for the entire sorting process.
     *
     * space complexity:
     *      O(n) as it requires an additional array of the same size as the input array to hold the
     *      temporary values during the merge step. this is because Merge Sort creates temporary arrays
     *      in the merge step to hold the sorted subarrays before erging them back into the original
     *      array. the maximum space required by Merge Sort is proportional to the size of the input array.
     */

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            // recursively calling mergeSort itself on both smaller arrays
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid ,right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        // find the sizes of the two subarrays to be merged
        int size1 = mid - left + 1;
        int size2 = right - mid;

        // create a temporary arrays for the left and right subarrays
        int[] leftArr = new int[size1];
        int[] rightArr = new int[size2];

        // copy the data into the temporary arrays
        for (int i = 0; i < size1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < size2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        // merge the temporary arrays back into the original array
        int i = 0;
        int j = 0;
        int k = left;

        while (i < size1 && j < size2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // copy any remaining elements from the left or right subarray
        while (i < size1) {
            arr[k++] = leftArr[i++];
        }
        while (j < size2) {
            arr[k++] = rightArr[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {50, 60, 20, 80, 10};
        mergeSort(arr, 0, arr.length -1);
        System.out.println(Arrays.toString(arr));
    }
}
