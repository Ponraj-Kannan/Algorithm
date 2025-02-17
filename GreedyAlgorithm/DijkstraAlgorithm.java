package GreedyAlgorithm;

import java.util.*;

class Graph {
    private int vertices;
    private List<List<Node>> adjacencyList;

    // Constructor
    public Graph(int vertices) {
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

    // Dijkstra's Algorithm
    public void dijkstra(int source) {
        // Priority queue to store nodes with the smallest distance
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));

        // Distance array to store the shortest distance from the source
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);

        // Add the source node to the priority queue
        minHeap.add(new Node(source, 0));
        distances[source] = 0;

        // Process nodes in the priority queue
        while (!minHeap.isEmpty()) {
            // Extract the node with the smallest distance
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;

            // Relax all edges of the current node
            for (Node neighbor : adjacencyList.get(currentVertex)) {
                int newDistance = distances[currentVertex] + neighbor.weight;

                // If a shorter path is found, update the distance
                if (newDistance < distances[neighbor.vertex]) {
                    distances[neighbor.vertex] = newDistance;
                    minHeap.add(new Node(neighbor.vertex, newDistance));
                }
            }
        }

        // Print the shortest distances
        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + ": " + distances[i]);
        }
    }
}

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);

        // Add edges to the graph
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);

        // Run Dijkstra's algorithm from source vertex 0
        graph.dijkstra(0);
    }
}