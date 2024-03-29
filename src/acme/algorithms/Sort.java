package acme.algorithms;

public class Sort {
    /**
     * Array must be sorted in order to use binary search.
     *
     * Time complexity: O(log(n))
     * Space complexity: In-place algorithm
     *
     * @param input sorted array
     * @param value needle
     *
     * @return index of needle in the sorted array
     */
    public static int binarySearchIterative(int[] input, int value) {
        int start = 0;
        int end = input.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (input[mid] == value) {
                return mid;
            } else if (input[mid] < value) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return -1;
    }

    /**
     * Recursive binary search implementation.
     *
     * Time complexity: O(log(n))
     * Space complexity: In-place algorithm
     *
     * @param input sorted array
     * @param value needle
     *
     * @return index of needle or -1 if not found
     */
    public static int binarySearchRecursive(int[] input, int value) {
        return binarySearchRecursive(input, value, 0, input.length);
    }

    /**
     *
     * @param input sorted array
     * @param value needle
     * @param start index
     * @param end index
     *
     * @return needle index or -1 if not found
     */
    private static int binarySearchRecursive(int[] input, int value, int start, int end) {
        if (start >= end)
            return -1;

        int mid = (start + end) / 2;

        if (input[mid] == value)
            return mid;
        else if (input[mid] < value)
            return binarySearchRecursive(input, value, mid + 1, end);
        else
            return binarySearchRecursive(input, value, start, mid);
    }

    /**
     * Sorts array with radix sort based on assumptions that the radix and the width should be the same of items.
     *
     * @param array unsorted array
     * @param radix number
     * @param width number
     */
    public static void radixSortAsc(int[] array, int radix, int width) {
        for (int i = 0; i < width; ++i) {
            radixSortSingleAsc(array, i, radix);
        }
    }

    /**
     *
     * @param array unsorted array
     * @param position digit position in number
     * @param radix system
     */
    private static void radixSortSingleAsc(int[] array, int position, int radix) {
        int numItems = array.length;
        int[] countArray = new int[radix];

        for (int value: array) {
            countArray[getDigit(position, value, radix)]++;
        }

        // adjust the count array
        for (int j = 1; j < radix; ++j) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; --tempIndex) {
            temp[--countArray[getDigit(position, array[tempIndex], radix)]] = array[tempIndex];
        }

        System.arraycopy(temp, 0, array, 0, numItems);
    }

    /**
     * Returns value of the digit at each position.
     *
     * @param position position of digit in number
     * @param value of item
     * @param radix digit system of 10
     *
     * @return value of the digit at each position
     */
    public static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }

    /**
     * Sorts array based on counting sort assumptions
     *
     * @param array unsorted array
     * @param min unsorted array min value
     * @param max unsorted array max value
     *
     * @return sorted array
     */
    public static int[] countingSortAsc(int[] array, int min, int max) {
        int[] counting = new int[max - min + 1];

        for (int k : array) {
            counting[k - min]++;
        }

        int c = 0;
        for (int i = min; i <= max; ++i) {
            while (counting[i - min] > 0) {
                array[c++] = i;
                counting[i - min]--;
            }
        }

        return array;
    }

    /**
     * Time complexity: Average O(n * log(n)), worst O(n ^ 2)
     * Space complexity: In-place algorithm
     *
     * @param array unsorted array
     * @param start unsorted array start index
     * @param end unsorted array end index
     */
    public static void quickSortAsc(int[] array, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int pivotIndex = quickSortAscPartition(array, start, end);
        quickSortAsc(array, start, pivotIndex);
        quickSortAsc(array, pivotIndex + 1, end);
    }

    /**
     * Returns unsorted array pivot item index
     *
     * @param array unsorted array
     * @param start unsorted array start index
     * @param end unsorted array end index
     *
     * @return pivot item index
     */
    private static int quickSortAscPartition(int[] array, int start, int end) {
        int pivot = array[start];
        int i = start;
        int j = end;

        while (i < j) {
            // NOTE: empty loop body
            while (i < j && array[--j] >= pivot);

            if (i < j) {
                array[i] = array[j];
            }

            // NOTE: empty loop body
            while (i < j && array[++i] <= pivot);

            if (i < j) {
                array[j] = array[i];
            }
        }

        array[j] = pivot;

        return j;
    }

    /**
     * Merge sort
     *
     * Time complexity: O(n * log(n)), O of n * log(n)
     * Space complexity: Not in-place algorithm
     * Stable algorithm
     *
     * @param array unsorted array
     * @param start unsorted array start index
     * @param end unsorted array end index
     */
    public static void mergeSortAsc(int[] array, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSortAsc(array, start, mid);
        mergeSortAsc(array, mid, end);
        mergeAsc(array, start, mid, end);
    }

    /**
     * Merges two unsorted partitions.
     *
     * @param array unsorted array
     * @param start unsorted array start index
     * @param mid unsorted array mid index
     * @param end unsorted array end index
     */
    private static void mergeAsc(int[] array, int start, int mid, int end) {
        if (array[mid - 1] <= array[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            temp[tempIndex++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        System.arraycopy(array, i, array, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, array, start, tempIndex);
    }

    /**
     * Merge sort
     *
     * Time complexity: O(n * log(n)), O of n * log(n)
     * Space complexity: Not in-place algorithm
     * Stable algorithm
     *
     * @param array unsorted array
     * @param start unsorted array start index
     * @param end unsorted array end index
     */
    public static void mergeSortDesc(int[] array, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSortDesc(array, start, mid);
        mergeSortDesc(array, mid, end);
        mergeDesc(array, start, mid, end);
    }

    /**
     * Merges two unsorted partitions.
     *
     * @param array unsorted array
     * @param start unsorted array start index
     * @param mid unsorted array mid index
     * @param end unsorted array end index
     */
    private static void mergeDesc(int[] array, int start, int mid, int end) {
        if (array[mid - 1] >= array[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            temp[tempIndex++] = array[i] >= array[j] ? array[i++] : array[j++];
        }

        System.arraycopy(array, i, array, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, array, start, tempIndex);
    }

    public static int[] shellSortAscGapOfKnuth(int[] array) {
        int gap = getKnuthSequence(array.length);

        for (; gap > 0; --gap) {
            for (int firstUnsortedIdx = gap; firstUnsortedIdx < array.length; ++firstUnsortedIdx) {
                int currentItem = array[firstUnsortedIdx];

                int i = firstUnsortedIdx;

                while (i >= gap && array[i - gap] > currentItem) {
                    array[i] = array[i - gap];

                    i -= gap;
                }

                array[i] = currentItem;
            }
        }

        return array;
    }

    /**
     * @param length length of array
     *
     * @return gap calculated based on knuth sequence
     */
    public static int getKnuthSequence(int length) {
        int limit = length * 2 + 1;
        int base = 3;
        int result = 1;

        while (base < limit) {
            ++result;

            base *= base;
        }

        return result;
    }

    /**
     * Shell sort optimises insertion sort by reducing shifting items.
     *
     * Shell sort is unstable algorithm.
     *
     * Time complexity: O(n ^ 2), O of n ^ 2
     *
     * Space complexity: In-place algorithm
     *
     * @param array unsorted array
     *
     * @return sorted array
     */
    public static int[] shellSortAscGapOfHalfArrayLength(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int firstUnsortedIdx = gap; firstUnsortedIdx < array.length; ++firstUnsortedIdx) {
                int currentItem = array[firstUnsortedIdx];

                int i = firstUnsortedIdx;

                while (i >= gap && array[i - gap] > currentItem) {
                    array[i] = array[i - gap];

                    i -= gap;
                }

                array[i] = currentItem;
            }
        }

        return array;
    }

    /**
     * Shell sort optimises insertion sort by reducing shifting items.
     *
     * Shell sort is unstable algorithm.
     *
     * Time complexity: O(n ^ 2), O of n ^ 2
     *
     * Space complexity: In-place algorithm
     *
     * @param array unsorted array
     *
     * @return sorted array
     */
    public static int[] shellSortDescGapOfHalfArrayLength(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int firstUnsortedIdx = gap; firstUnsortedIdx < array.length; ++firstUnsortedIdx) {
                int currentItem = array[firstUnsortedIdx];

                int i = firstUnsortedIdx;

                while (i >= gap && array[i - gap] < currentItem) {
                    array[i] = array[i - gap];

                    i -= gap;
                }

                array[i] = currentItem;
            }
        }

        return array;
    }

    /**
     * Insertion sort is considered to be generally more effective than bubble sort, and more efficient than selection
     *      sort if some part of the array is already sorted, as it will need less iterations. However compare to
     *      selection sort shifting in insertion sort considered to be O of n ^ 2, while on selection sort O of n.
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
        for (int firstUnsortedIdx = 1; firstUnsortedIdx < array.length; ++firstUnsortedIdx) {
            int newElement = array[firstUnsortedIdx];

            int i = firstUnsortedIdx;

            while (i != 0 && array[i - 1] > newElement) {
                array[i] = array[i - 1];

                --i;
            }

            array[i] = newElement;
        }

        return array;
    }

    /**
     * Insertion sort is considered to be generally more effective than bubble sort, and more efficient than selection
     *      sort if some part of the array is already sorted, as it will need less iterations. However compare to
     *      selection sort shifting in insertion sort considered to be O of n ^ 2, while on selection sort O of n.
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
        for (int firstUnsortedIdx = 1; firstUnsortedIdx < array.length; ++firstUnsortedIdx) {
            int newElement = array[firstUnsortedIdx];

            int i = firstUnsortedIdx;

            while (i != 0 && array[i - 1] < newElement) {
                array[i] = array[i - 1];

                --i;
            }

            array[i] = newElement;
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
