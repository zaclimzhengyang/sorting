package sorting;

import java.util.Arrays;

public class BubbleSort {
    /**
     * bubble sort is a simple sorting algorithm that works by repeatedly swapping adjacent
     * elements in an array or list that are in the wrong order. the algorithm iterates over the
     * array or list multiple times, with each iteration bubbling the largest unsorted element to
     * the end of the array or list. after each iteration, the algorithm shrinks the size of the
     * unsorted portion of the array or list by one element
     *
     * here are the basic steps of the bubble sort algorithm:
     *      1. starting with the first element, compare each adjacent pair of elements in the array or list
     *      2. if the elements are in the wrong order, swap them
     *      3. repeat steps 1 - 2 for each adjacent pair of elements in the array or list
     *      4. after each iteration, the largest unsorted element will have "bubbled up" to the end of
     *         the array or list
     *      5. shrink the size of the unsorted portion of the array or list by one element
     *      6. repeat steps 1 - 5 until the entire array or list is sorted
     *
     * time complexity:
     *      O(n^2), where n is the number of the elements in the array or list being sorted. this is because the
     *      algorithm involves nested loops: an outer loop that iterates over each element in the array or list,
     *      and an inner loop that iterates over the remaining unsorted elements to find the largest unsorted element
     *      and bubble it to the end of the array or list. in the worst case scenario, where the input
     *      array or list is in reverse order, each element will have to be compared to every other elements, resulting
     *      in n^2 comparisons
     *
     * space complexity:
     *      O(1), because the algorithm sorts the array or list in place without requiring any additional memory.
     *      the only additional memory used is a few temporary variables to store the current and next element being
     *      compared, as well as a variable to track whether any swaps have been made on each iteration of the outer
     *      loop. these variables use a constant amount of memory, regardless of the size of the input array or list
     *
     * e.g.
     *      first pass:
     *          6   3   0   5   (6 > 3)
     *          3   6   0   5   (6 > 0)
     *          3   0   6   5   (6 > 5)
     *          3   0   5   6
     *
     *      second pass:
     *          0   3   5   6   (3 > 0)
     *          0   3   5   6   (3 < 5)
     *
     *      third pass:
     *          0   3   5   6 (0 < 3)
     *
     *
     */

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] arr = {5,2,8,3,6,4,10};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
