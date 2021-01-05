package acme.algorithms;

public class Sort {
    /**
     * Insertion sort is considered to be generally more effective than bubble sort, and more efficient than selection
     *      sort if some part of the array is already sorted, as it will need less iterations. However compare to
     *      selection sort swapping in insertion sort considered to be O of n ^ 2, while on selection sort O of n.
     *
     * Insertion sort sorts on array starting from 1 index, considering that first part item at 0 index is already
     *      sorted, and does checks starting from 1 index. Insertion sort is efficient is some part of the array is
     *      already sorted.
     *
     * Insertion sort divides an array into sorted and unsorted partitions.
     *
     * Insertion sort is stable algorithm.
     *
     * Time complexity: O(n ^ 2), O of n ^ 2
     *
     * Space complexity: This is an in-place algorithm, as extra memory that is needed doesn't depend
     *      on the number of items that are going to be sorted.
     *
     * @param array unsorted array
     *
     * @return sorted array
     */
    public static int[] insertionSortAsc(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            int firstUnsortedIdx = i;

            while (firstUnsortedIdx != 0 && array[firstUnsortedIdx - 1] > array[firstUnsortedIdx]) {
                swap(array, firstUnsortedIdx - 1, firstUnsortedIdx);

                --firstUnsortedIdx;
            }
        }

        return array;
    }

    /**
     * Insertion sort is considered to be generally more effective than bubble sort, and more efficient than selection
     *      sort if some part of the array is already sorted, as it will need less iterations. However compare to
     *      selection sort swapping in insertion sort considered to be O of n ^ 2, while on selection sort O of n.
     *
     * Insertion sort sorts on array starting from 1 index, considering that first part item at 0 index is already
     *      sorted, and does checks starting from 1 index. Insertion sort is efficient is some part of the array is
     *      already sorted.
     *
     * Insertion sort divides an array into sorted and unsorted partitions.
     *
     * Insertion sort is stable algorithm.
     *
     * Time complexity: O(n ^ 2), O of n ^ 2
     *
     * Space complexity: This is an in-place algorithm, as extra memory that is needed doesn't depend
     *      on the number of items that are going to be sorted.
     *
     * @param array unsorted array
     *
     * @return sorted array
     */
    public static int[] insertionSortDesc(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            int firstUnsortedIdx = i;

            while (firstUnsortedIdx != 0 && array[firstUnsortedIdx - 1] < array[firstUnsortedIdx]) {
                swap(array, firstUnsortedIdx - 1, firstUnsortedIdx);

                --firstUnsortedIdx;
            }
        }

        return array;
    }

    /**
     * Selection sort is considered to be generally more effective than bubble sort, as it does swapping only once
     *      per sub iteration, compare to bubble sort. However selection sort does not guarantees stable sorting, hence
     *      selection sort is an unstable sort algorithm.
     *
     * Selection sort sorts on array in asc order,
     *      by memorizing larger value of the array and swaps with the last unsorted index.
     *
     * Selection sort divides an array into sorted and unsorted partitions.
     *
     * Selection sort is an unstable algorithm, meaning that it does not preserve relative ordering of duplicate items.
     *
     * Time complexity: O(n ^ 2), O of n ^ 2
     *
     * Space complexity: This is an in-place algorithm, as extra memory that is needed doesn't depend
     *      on the number of items that are going to be sorted.
     *
     * @param array unsorted array
     *
     * @return sorted array
     */
    public static int[] selectionSortAsc(int[] array) {
        int lastUnsortedIdx = array.length - 1;

        while (lastUnsortedIdx != 0) {
            int largestItemIdx = 0;

            for (int i = 0; i <= lastUnsortedIdx; ++i) {
                if (array[i] > array[largestItemIdx]) {
                    largestItemIdx = i;
                }
            }

            swap(array, largestItemIdx, lastUnsortedIdx);

            --lastUnsortedIdx;
        }

        return array;
    }

    /**
     * Selection sort is considered to be generally more effective than bubble sort, as it does swapping only once
     *      per sub iteration, compare to bubble sort. However selection sort does not guarantees stable sorting, hence
     *      selection sort is an unstable sort algorithm.
     *
     * Selection sort sorts on array in desc order,
     *      by memorizing larger value of the array and swaps with the last unsorted index.
     *
     * Selection sort divides an array into sorted and unsorted partitions.
     *
     * Selection sort is an unstable algorithm, meaning that it does not preserve relative ordering of duplicate items.
     *
     * Time complexity: O(n ^ 2), O of n ^ 2
     *
     * Space complexity: This is an in-place algorithm, as extra memory that is needed doesn't depend
     *      on the number of items that are going to be sorted.
     *
     * @param array unsorted array
     *
     * @return sorted array
     */
    public static int[] selectionSortDesc(int[] array) {
        int lastUnsortedIdx = array.length - 1;

        while (lastUnsortedIdx != 0) {
            int largestItemIdx = 0;

            for (int i = 0; i <= lastUnsortedIdx; ++i) {
                if (array[i] < array[largestItemIdx]) {
                    largestItemIdx = i;
                }
            }

            swap(array, largestItemIdx, lastUnsortedIdx);

            --lastUnsortedIdx;
        }

        return array;
    }

    /**
     * Bubble sort sorts on array in asc order,
     *      by bubbling (moving) up larger values of the array to the end of the array.
     *
     * Bubble sort divides an array into sorted and unsorted partitions.
     *
     * Bubble sort is a stable algorithm, meaning that it preserves relative ordering of duplicate items.
     *
     * Time complexity: O(n ^ 2), O of n ^ 2
     *
     * Space complexity: This is an in-place algorithm, as extra memory that is needed doesn't depend
     *      on the number of items that are going to be sorted.
     *
     * @param array unsorted array
     *
     * @return sorted array
     */
    public static int[] bubbleSortAsc(int[] array) {
        for (int unsortedIdx = array.length - 1; unsortedIdx > 0; --unsortedIdx) {
            for (int i = 0; i < unsortedIdx; ++i) {
                if (array[i] > array[i + 1]) { // sort is stable, it could become unstable by >= comparison
                    swap(array, i, i + 1);
                }
            }
        }

        return array;
    }

    /**
     * Bubble sort sorts on array in desc order,
     *      by bubbling (moving) up smaller values of the array to the end of the array.
     *
     * Bubble sort divides an array into sorted and unsorted partitions.
     *
     * Bubble sort is a stable algorithm, meaning that it preserves relative ordering of duplicate items.
     *
     * Time complexity: O(n ^ 2), O of n ^ 2
     *
     * Space complexity: This is an in-place algorithm, as extra memory that is needed doesn't depend
     *      on the number of items that are going to be sorted.
     *
     * @param array unsorted array
     *
     * @return sorted array
     */
    public static int[] bubbleSortDesc(int[] array) {
        int unsortedIdx = array.length;

        while (unsortedIdx != 0) {
            for (int i = 0; i < unsortedIdx - 1; ++i) {
                if (array[i] < array[i + 1]) { // sort is stable, it could become unstable by <= comparison
                    swap(array, i, i + 1);
                }
            }

            --unsortedIdx;
        }

        return array;
    }

    /**
     * Swaps items of the array of specific i and j indices.
     *
     * @param array array
     * @param i index
     * @param j index
     */
    protected static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = array[j];

        array[j] = array[i];
        array[i] = temp;
    }
}
