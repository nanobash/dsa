**Bubble sort**

* Time complexity: O(n ^ 2), O of n ^ 2
* Space complexity: In-place algorithm
* Stable sort algorithm (guarantees to preserve ordering of relative duplicate items)
* Divides an array into sorted and unsorted partitions

---

**Selection sort**

* Time complexity: O(n ^ 2), O of n ^ 2
* Space complexity: In-place algorithm
* Unstable sort algorithm (does not guarantee to preserve ordering of relative duplicate items)
* Divides an array into sorted and unsorted partitions
* Does not require as much swapping as bubble sort (hence considered generally more efficient than bubble sort, however selection sort is unstable sort algorithm compared to bubble sort)

---

**Insertion sort**

* Time complexity: O(n ^ 2), O of n ^ 2
* Space complexity: In-place algorithm
* Stable sort algorithm (guarantees to preserve ordering of relative duplicate items)
* Divides an array into sorted and unsorted partitions
* Considered to be more efficient than selection sort if part of the unsorted array is already sorted, however shifting items complexity is O of n ^ 2, while in selection sort it is O of n

---

**Shell sort (Donald Shell)**

* Time complexity: Worst case O(n ^ 2), O of n ^ 2, but it depends on the gap, and it can perform much better than that
* Space complexity: In-place algorithm
* Unstable sort algorithm (does not guarantee to preserve ordering of relative duplicate items)
* Does not require as much shifting as insertion sort, so it usually performs better
* Shell sort gap calculation idea can be applied to insertion sort (decreases shifting) and bubble sort (decreases swapping)

---

**Merge sort**

* Divide and conquer algorithm
* Recursive algorithm
* Two phases: splitting (logical, e.i not create new arrays) and merging
* Starting with unsorted array
* Divides an array into two sub arrays. The first array is the left array, and the second array is the right array
* Keep splitting until all the arrays have only one element each - one element array is always sorted
* Time complexity: O(n * log(n))
* Space complexity: Not in-place algorithm
* Stable algorithm

---

**Quick sort**

* Divide and conquer algorithm
* Recursive algorithm
* Uses pivot element to partition the array into two parts
* Elements to the left < pivot, elements to the right > pivot
* Pivot will be in its correct sorted position
* Process is repeated for the left and right arrays
* Eventually, every element has been he pivot, so every element will be in its correct sorted position
* As with merge sort, we'll end up with partitioning the array into a series of 1-element arrays
* Time complexity: On average it is O(n * log(n)), O of n * log(n), in it's worst case it's O(n ^ 2)
  Most of the time it performs better than the merge sort
* Space complexity: In-place algorithm
* Unstable algorithm

---

**Counting sort**

* Makes assumptions about the data
* Doesn't use comparisons
* Counts the number of occurrences of each value
* Only works with non-negative discrete values (can't work with floats, strings)
* Values must be within a specific rage
* Counting sort is best used when range of unsorted values are around the same length of the input array
* Time complexity: O(n), O of n
* Space complexity: Not in-place algorithm
* Unstable (generally unstable, can be made as stable with additional sort though)

---

**Radix sort**

* Makes assumptions about the data
* Data must have same radix and width
  * Therefore data must be integers or strings
* Sort is based on each individual digit or letter position
* Start at rightmost position
* Must use a stable sort algorithm at each stage
* Tome complexity: O(n), O of n
  * However, if often runs slower than O(n * log(n)), because of the overhead involved
* Space complexity: in-place depending on which sort algorithm is used
* Stable algorithm
