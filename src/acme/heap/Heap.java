package acme.heap;

public class Heap {
    protected int[] heap;

    protected int size;

    public Heap(int capacity) {
        this.heap = new int[capacity];
    }

    /**
     * Time complexity: O(log(n)), O of log(n)
     *
     * @param value number
     */
    public void insert(int value) {
        if (this.isFull()) {
            throw new IndexOutOfBoundsException("Heap is full");
        }

        this.heap[this.size] = value;

        this.fixHeapAbove(this.size);

        this.size++;
    }

    /**
     * Time complexity: O(1), constant time
     *
     * @return max item from heap
     */
    public int peek() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        return this.heap[0];
    }

    public void printHeap() {
        for (int i = 0; i < this.size; ++i) {
            System.out.print("Data = " + this.heap[i] + ", ");
        }
        System.out.println();
    }

    /**
     * Time complexity: O(log(n)), O of log(n)
     *
     * @param index of item that should be deleted
     *
     * @return deleted item
     */
    public int delete(int index) {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        int parent = this.getParent(index);
        int deletedValue = this.heap[index];

        this.heap[index] = this.heap[this.size - 1];

        if (index == 0 || this.heap[index] < this.heap[parent]) {
            this.fixHeapBelow(index, this.size - 1);
        } else {
            this.fixHeapAbove(index);
        }

        --this.size;

        return deletedValue;
    }

    public int getParent(int index) {
        return (index - 1) / 2;
    }

    public boolean isFull() {
        return this.size == this.heap.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getChild(int index, boolean left) {
        return 2 * index + (left ? 1 : 2);
    }

    /**
     * Time complexity: O(n * log(n)), O of n * log(n)
     * Space complexity: In-place algorithm
     */
    public void sort() {
        int lastHeapIndex = this.size - 1;

        for (int i = 0; i < lastHeapIndex; ++i) {
            int temp = this.heap[0];
            this.heap[0] = this.heap[lastHeapIndex - i];
            this.heap[lastHeapIndex - i] = temp;

            this.fixHeapBelow(0, lastHeapIndex - i - 1);
        }
    }

    private void fixHeapAbove(int index) {
        int newValue = this.heap[index];

        while (index > 0 && newValue > this.heap[this.getParent(index)]) {
            this.heap[index] = this.heap[this.getParent(index)];
            index = this.getParent(index);
        }

        this.heap[index] = newValue;
    }

    private void fixHeapBelow(int index, int lastHeapIndex) {
        int childToSwap;

        while (index <= lastHeapIndex) {
            int leftChild = this.getChild(index, true);
            int rightChild = this.getChild(index, false);

            if (leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = this.heap[leftChild] > this.heap[rightChild] ? leftChild : rightChild;
                }

                if (this.heap[index] < this.heap[childToSwap]) {
                    int temp = this.heap[index];

                    this.heap[index] = this.heap[childToSwap];
                    this.heap[childToSwap] = temp;
                } else {
                    break;
                }

                index = childToSwap;
            } else {
                break;
            }
        }
    }
}
