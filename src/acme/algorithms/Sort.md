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

* Time complexity: O(n * log(n))
* Space complexity: Not in-place algorithm
* Stable algorithm
