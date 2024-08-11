package pq_assignment;
import java.util.*;

// Helper class to represent an element in the min-heap
class num {
    int value;        // The value of the element
    int arrayIndex;   // Index of the array from which this element is taken
    int elementIndex; // Index of this element within the array

    public num(int v, int ai, int ei) {
        value = v;
        arrayIndex = ai;
        elementIndex = ei;
    }
}

public class MergeKSortedArrays {
    public static List<Integer> mergeKSortedArrays(List<List<Integer>> input) {
        // PriorityQueue to keep track of the smallest elements
        PriorityQueue<num> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n.value));
        List<Integer> ans = new ArrayList<>();

        // Initialize the heap with the first element of each array
        for (int i = 0; i < input.size(); i++) {
            if (!input.get(i).isEmpty()) {
                heap.add(new num(input.get(i).get(0), i, 0));
            }
        }

        // Process the heap until it is empty
        while (!heap.isEmpty()) {
            num min = heap.poll(); // Extract the smallest element
            ans.add(min.value);    // Add it to the result list

            // If there are more elements in the same array, add the next element to the heap
            if (min.elementIndex + 1 < input.get(min.arrayIndex).size()) {
                heap.add(new num(input.get(min.arrayIndex).get(min.elementIndex + 1), min.arrayIndex, min.elementIndex + 1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(List.of(1, 2, 4, 5));
        input.add(List.of(1, 3, 4, 6));
        input.add(List.of(2, 5));
        input.add(List.of(3, 5, 8, 9));

        List<Integer> ans = mergeKSortedArrays(input);
        for (int item : ans) {
            System.out.print(item + " ");
        }
    }
}

