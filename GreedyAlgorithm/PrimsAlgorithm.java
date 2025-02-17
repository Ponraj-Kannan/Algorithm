package GreedyAlgorithm;

import java.util.*;

class PrimsGraph {
    private int vertices;
    private List<List<Node>> adjacencyList;

    // Constructor
    public PrimsGraph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Node class to store vertex and weight
    static class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    // Add an edge to the graph
    public void addEdge(int source, int destination, int weight) {
        adjacencyList.get(source).add(new Node(destination, weight));
        adjacencyList.get(destination).add(new Node(source, weight)); // For undirected graph
    }

    // Prim's Algorithm
    public void primMST() {
        // Priority queue to store vertices based on their key values
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));

        // Key array to store the minimum weight to connect each vertex to the MST
        int[] key = new int[vertices];
        Arrays.fill(key, Integer.MAX_VALUE);

        // Array to store the parent of each vertex in the MST
        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);

        // Visited array to track vertices included in the MST
        boolean[] visited = new boolean[vertices];

        // Start with vertex 0
        key[0] = 0;
        minHeap.add(new Node(0, 0));

        // Process vertices in the priority queue
        while (!minHeap.isEmpty()) {
            // Extract the vertex with the smallest key
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;

            // Mark the vertex as visited
            visited[currentVertex] = true;

            // Relax all edges of the current vertex
            for (Node neighbor : adjacencyList.get(currentVertex)) {
                int neighborVertex = neighbor.vertex;
                int neighborWeight = neighbor.weight;

                // If the neighbor is not visited and a smaller weight is found
                if (!visited[neighborVertex] && neighborWeight < key[neighborVertex]) {
                    key[neighborVertex] = neighborWeight;
                    parent[neighborVertex] = currentVertex;
                    minHeap.add(new Node(neighborVertex, neighborWeight));
                }
            }
        }

        // Print the MST
        System.out.println("Minimum Spanning Tree (MST):");
        for (int i = 1; i < vertices; i++) {
            System.out.println("Edge: " + parent[i] + " - " + i + " (Weight: " + key[i] + ")");
        }
    }
}

public class PrimsAlgorithm {
    public static void main(String[] args) {
        int vertices = 5;
        PrimsGraph graph = new PrimsGraph(vertices);

        // Add edges to the graph
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        // Run Prim's algorithm
        graph.primMST();
    }
}