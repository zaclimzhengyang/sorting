package sorting;

import java.util.Arrays;

public class HeapSort {
    /**
     * heap sort is a comparison-based sorting algorithm that works by building a max heap
     * from the input array and repeatedly extracting the maximum element from the heap and
     * placing it at the end of the array
     *
     * here is the step-by-step description of the heap sort algorithm:
     *      1. build a max heap from the input array. this can be done by calling the
     *          `buildMaxHeap` method on the input array.
     *      2. repeatedly extract the maximum element from the heap and swapping it with
     *          the last element of the heap and reducing the size of the heap by 1. this can
     *          be done by calling the `heapSort` method on the input array.
     *      3. after each extraction of the maximum element, restore the heap property by calling
     *          the `maxHeapify` method on the remaining heap
     *      4. the sorted array will be the elements that were swapped with the maximum element
     *          during the extraction process
     *
     * time complexity:
     *      O(n log n), in the worst-case scenario. this is because building the heap takes O(n) time
     *      and for each element, extracting the maximum and fixing the heap takes O(log n) time. the
     *      heapify operation is performed n times, so the total time complexity is O(n log n)
     *
     * space complexity:
     *      O(1) as it only requires a constant amount of additional space to store the temporary variables.
     *      this makes it more memory efficient than some other sorting algorithms like MergeSort, which
     *      require O(n) additional space for merging
     */

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // build a max heap from the input array
        buildMaxHeap(arr);

        // repeatedly extract the maximum element from the heap
        for (int i = n - 1; i > 0; i --) {
            // swap the maximum element with the last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // reduce the size of the heap by 1
            n--;

            // restore the heap property
            maxHeapify(arr, 0, n);
        }
    }

    public static void buildMaxHeap(int[] arr) {
        int n = arr.length;

        // build a max heap from the input array
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, i, n);
        }
    }

    public static void maxHeapify(int[] arr, int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        // find the largest element among the parent node, left child, and right child
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // if the largest element is not the parent node, swap it with the parent node
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // recursively max heapify the affected subtree
            maxHeapify(arr, largest, n);
        }

    }

    public static void main(String[] args) {
        int[] arr = {50, 60, 20, 80, 10};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
