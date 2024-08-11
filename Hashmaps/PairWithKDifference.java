package hasmaps_ques;

import java.util.HashMap;

public class PairWithKDifference {
    
    // Method to find the number of pairs with a given difference k
    public static int numPair(int[] arr, int k) {
        // HashMap to store the frequency of each number in the array
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int pairs = 0; // Variable to count the number of valid pairs
        
        // Iterate through each number in the array
        for(int num : arr) {
            int p1 = num + k; // Calculate the number that would form a valid pair with num if added
            boolean check = false; // Flag to check if num is equal to p1 (special case when k is 0)
            if(num == p1) {
                check = true; // Set check to true if num is equal to p1
            }
            
            // Check if the number p1 exists in the map
            if(map.containsKey(p1)) {
                pairs += map.get(p1); // Increment pairs by the frequency of p1
            }
            
            int p2 = num - k; // Calculate the number that would form a valid pair with num if subtracted
            // Check if the number p2 exists in the map and num is not equal to p1
            if(map.containsKey(p2) && !check) {
                pairs += map.get(p2); // Increment pairs by the frequency of p2
            }
            
            // Update the frequency of num in the map
            if(map.containsKey(num)) {
                map.put(num,  map.get(num) + 1);
            } else {
                map.put(num, 1);
            }        
        }
        return pairs; // Return the total number of valid pairs
    }

    // Main method to test the numPair method
    public static void main(String[] args) {
        int[] arr = {1, 4, -1, 2, 5, 6, 3}; // Test array
        System.out.println(numPair(arr, 3)); // Output the number of pairs with difference 3
    }
}
