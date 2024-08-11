package pq_1;

import java.util.ArrayList;

public class Max_Priority_Queue {
    private ArrayList<Integer> heap;

    public Max_Priority_Queue() {
        heap = new ArrayList<>();
    }

    boolean isEmpty() {
        return heap.isEmpty();
    }

    int getSize() {
        return heap.size();
    }

    int getMax() {
        if (isEmpty()) {
            return Integer.MIN_VALUE; // Return -Infinity if priority queue is empty
        }
        return heap.get(0);
    }

    void insert(int element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (heap.get(childIndex) > heap.get(parentIndex)) {
                // Swap the elements if the child is greater than the parent
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    int removeMax() {
        if (isEmpty()) {
            return Integer.MIN_VALUE; // Return -Infinity if priority queue is empty
        }

        int removedElement = heap.get(0);
        int lastElement = heap.remove(heap.size() - 1);

        if (!isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }

        return removedElement;
    }

    private void heapifyDown(int index) {
        int largest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < heap.size() && heap.get(leftChild) > heap.get(largest)) {
            largest = leftChild;
        }

        if (rightChild < heap.size() && heap.get(rightChild) > heap.get(largest)) {
            largest = rightChild;
        }

        if (largest != index) {
            // Swap the elements at index and largest
            int temp = heap.get(index);
            heap.set(index, heap.get(largest));
            heap.set(largest, temp);

            // Recursively heapify down
            heapifyDown(largest);
        }
    }
}
