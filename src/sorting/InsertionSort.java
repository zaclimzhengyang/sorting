package sorting;

import java.util.Arrays;

public class InsertionSort {
    /**
     * insertion sort is a simple sorting algorithm that works by iterating over an array or list
     * of elements and inserting each element into its correct position within a sorted subarray
     * or sublist. the sorted subarray or sublist starts with the first element and grows by one
     * element eah iteration
     *
     * here are the basic steps of the insertion sort algorithm:
     *      1. starting with the second element, iterate over each element in the array or list
     *      2. for each element, compare it with the elements in the sorted subarray or sublist
     *      3. if the element is less than any of the elements in the sorted subarray or sublist,
     *          insert the element into the correct position in the sorted subarray or sublist by
     *          shifting the greater elements to the right
     *      4. if the element is greater than or equal to all the elements in the sorted subarray
     *          or sublist, insert the element at the end of the sorted subarray or sublist
     *      5. repeat steps 2 - 4 for each element in the array or the list
     *
     *  time complexity:
     *      O(n^2), where n is the number of the elements in the array or list. this is because the
     *      algorithm involves nested loops an outer loop that iterates over each element in the array,
     *      and an inner loop that iterates over the sorted subarray or sublist to find the correct position
     *      for each element. in the worst case scenario, where the input array or list is in reverse order,
     *      each element will have to be compared to every other element in the sort subarray or sublist,
     *      resulting in n^2 comparisons
     *
     *  space complexity:
     *      O(1), because the algorithm only requires a constant amount of additional space to store temporary
     *      variables like the `key` variable and tbe index `j`. the algorithm sorts the array in place,
     *      so no additional memory is needed.
     *
     */

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i ++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {8,3,2,6,1,10};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
