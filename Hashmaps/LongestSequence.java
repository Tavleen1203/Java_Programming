package hasmaps_ques;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestSequence {

    // Method to find the longest consecutive sequence in the array
    public static ArrayList<Integer> longestConsecutiveSequence(int[] arr) {
        // HashMap to track if an element has been visited
        HashMap<Integer, Boolean> visited = new HashMap<>();
        // HashMap to store the index of each element
        HashMap<Integer, Integer> index = new HashMap<>();

        // Populate the visited and index maps
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            index.put(num, i);

            if (!visited.containsKey(num)) {
                visited.put(num, false);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int maxLength = 1;  // Length of the longest sequence found
        int ansStart = 0;   // Starting index of the longest sequence

        // Iterate through each element in the array
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];

            int currMin = i; // Current minimum index in the sequence
            int count = 0;   // Length of the current sequence
            int tempNum = num;

            // Check forward sequence
            while (visited.containsKey(tempNum) && !visited.get(tempNum)) {
                visited.put(tempNum, true);
                count++;
                tempNum++;
            }

            // Check backward sequence
            tempNum = num - 1;
            while (visited.containsKey(tempNum) && !visited.get(tempNum)) {
                visited.put(tempNum, true);
                count++;
                currMin = index.get(tempNum);
                tempNum--;
            }

            // Update maxLength and ansStart if a longer sequence is found
            if (count > maxLength) {
                maxLength = count;
                ansStart = currMin;
            } else if (count == maxLength) {
                // If sequences are of the same length, choose the one that starts earlier
                if (currMin < ansStart) {
                    ansStart = currMin;
                }
            }
        }

        // Construct the result
        int start = arr[ansStart];
        ans.add(start);
        if (maxLength > 1) {
            ans.add(start + maxLength - 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 2, 8, 9, 20, 11, 22, 6};
        ArrayList<Integer> ans = longestConsecutiveSequence(arr);
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
