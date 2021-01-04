package acme.algorithms;

public class Sort {
    /**
     * Bubble sort sorts on array in asc order,
     *      therefore larger values in the array will bubble up to the end of the array.
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
        int unsortedIdx = array.length;

        while (unsortedIdx != 0) {
            for (int i = 0; i < unsortedIdx - 1; ++i) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i + 1];

                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }

            --unsortedIdx;
        }

        return array;
    }

    /**
     * Bubble sort sorts on array in desc order,
     *      therefore smaller values in the array will bubble up to the end of the array.
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
                if (array[i] < array[i + 1]) {
                    int temp = array[i + 1];

                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }

            --unsortedIdx;
        }

        return array;
    }
}
