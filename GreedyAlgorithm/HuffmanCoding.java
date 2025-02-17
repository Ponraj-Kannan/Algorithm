package GreedyAlgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Node class for Huffman Tree
class HuffmanNode implements Comparable<HuffmanNode> {
    char character;
    int frequency;
    HuffmanNode left, right;

    // Constructor for leaf nodes
    public HuffmanNode(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    // Constructor for internal nodes
    public HuffmanNode(int frequency, HuffmanNode left, HuffmanNode right) {
        this.character = '\0'; // Internal nodes don't store characters
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    // Compare nodes based on frequency
    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}

public class HuffmanCoding {

    // Function to build the Huffman Tree
    public static HuffmanNode buildHuffmanTree(Map<Character, Integer> frequencyMap) {
        // Create a min-heap (priority queue)
        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>();

        // Add all characters to the min-heap
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            minHeap.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        // Combine nodes until one node remains
        while (minHeap.size() > 1) {
            HuffmanNode left = minHeap.poll(); // Remove the node with the smallest frequency
            HuffmanNode right = minHeap.poll(); // Remove the next smallest frequency node

            // Create a new internal node with the sum of frequencies
            HuffmanNode internalNode = new HuffmanNode(left.frequency + right.frequency, left, right);
            minHeap.add(internalNode); // Add the new node back to the heap
        }

        return minHeap.poll(); // Return the root of the Huffman tree
    }

    // Function to generate Huffman codes
    public static void generateCodes(HuffmanNode root, String code, Map<Character, String> huffmanCodes) {
        if (root == null) {
            return;
        }

        // If it's a leaf node, store the code
        if (root.left == null && root.right == null) {
            huffmanCodes.put(root.character, code);
        }

        // Traverse left (add '0' to the code)
        generateCodes(root.left, code + "0", huffmanCodes);

        // Traverse right (add '1' to the code)
        generateCodes(root.right, code + "1", huffmanCodes);
    }

    // Function to print Huffman codes
    public static void printHuffmanCodes(Map<Character, String> huffmanCodes) {
        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String input = "huffman coding is fun!";
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Calculate frequency of each character
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Build the Huffman tree
        HuffmanNode root = buildHuffmanTree(frequencyMap);

        // Generate Huffman codes
        Map<Character, String> huffmanCodes = new HashMap<>();
        generateCodes(root, "", huffmanCodes);

        // Print Huffman codes
        printHuffmanCodes(huffmanCodes);
    }
}