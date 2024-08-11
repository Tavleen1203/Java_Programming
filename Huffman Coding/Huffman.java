package hc;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Huffman {

    public static void printCodes(HuffmanNode root, String s, Map<Character, String> huffmanCode) {
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            huffmanCode.put(root.c, s);
            return;
        }

        if (root.left != null) {
            printCodes(root.left, s + "0", huffmanCode);
        }
        
        if (root.right != null) {
            printCodes(root.right, s + "1", huffmanCode);
        }
    }

    public static void encode(String text) {
        // Calculate frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Create a priority queue to store live nodes of the Huffman tree
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.data));

        // Create a leaf node for each character and add it to the priority queue
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.add(new HuffmanNode(entry.getValue(), entry.getKey()));
        }

        // Iterate until the size of the queue becomes 1
        while (priorityQueue.size() > 1) {
            // Remove the two nodes of highest priority (lowest frequency) from the queue
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();

            // Create a new internal node with these two nodes as children and with a frequency equal to the sum of the two nodes' frequencies
            int sum = left.data + right.data;
            HuffmanNode newNode = new HuffmanNode(sum, '-');
            newNode.left = left;
            newNode.right = right;

            // Add the new node to the priority queue
            priorityQueue.add(newNode);
        }

        // The remaining node is the root node and the tree is complete
        HuffmanNode root = priorityQueue.poll();

        // Traverse the Huffman Tree and store the Huffman Codes in a map
        Map<Character, String> huffmanCode = new HashMap<>();
        printCodes(root, "", huffmanCode);

        // Print the Huffman codes
        System.out.println("Huffman Codes: " + huffmanCode);

        // Encode the input string
        StringBuilder encodedString = new StringBuilder();
        for (char c : text.toCharArray()) {
            encodedString.append(huffmanCode.get(c));
        }

        System.out.println("Encoded String: " + encodedString.toString());
    }

    public static void main(String[] args) {
        String text = "this is an example for huffman encoding";
        encode(text);
    }
}
