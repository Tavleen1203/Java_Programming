package arrays_ques;

public class FindDup {
    public static int dupNum(int[] arr) {
        int n = arr.length;
        int xor_all_elements = 0;
        int xor_1_to_n_minus_1 = 0;

        // XOR all elements in the array
        for (int num : arr) {
            xor_all_elements ^= num;
        }

        // XOR all numbers from 1 to n-1
        for (int i = 1; i < n; i++) {
            xor_1_to_n_minus_1 ^= i;
        }

        // The result of XORing these two will be the duplicate number
        return xor_all_elements ^ xor_1_to_n_minus_1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        System.out.println(dupNum(arr)); // Should print 2
    }
}
