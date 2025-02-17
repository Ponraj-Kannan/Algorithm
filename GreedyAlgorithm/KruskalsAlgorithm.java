package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class KruskalGraph {
    private int vertices;
    private List<Edge> edges;

    // Constructor
    public KruskalGraph(int vertices) {
        this.vertices = vertices;
        edges = new ArrayList<>();
    }

    // Edge class to store source, destination, and weight
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Add an edge to the graph
    public void addEdge(int source, int destination, int weight) {
        edges.add(new Edge(source, destination, weight));
    }

    // Disjoint Set Union (DSU) class
    static class DSU {
        int[] parent;
        int[] rank;

        public DSU(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i; // Each node is its own parent initially
            }
        }

        // Find the root of a node with path compression
        public int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]); // Path compression
            }
            return parent[node];
        }

        // Union two sets by rank
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    // Kruskal's Algorithm
    public void kruskalMST() {
        // Sort edges by weight
        edges.sort(Comparator.comparingInt(edge -> edge.weight));

        // Initialize DSU
        DSU dsu = new DSU(vertices);

        // List to store the MST edges
        List<Edge> mst = new ArrayList<>();

        // Iterate through sorted edges
        for (Edge edge : edges) {
            int rootSource = dsu.find(edge.source);
            int rootDestination = dsu.find(edge.destination);

            // If adding the edge doesn't form a cycle
            if (rootSource != rootDestination) {
                mst.add(edge); // Add the edge to the MST
                dsu.union(rootSource, rootDestination); // Union the sets
            }

            // Stop if the MST has V-1 edges
            if (mst.size() == vertices - 1) {
                break;
            }
        }

        // Print the MST
        System.out.println("Minimum Spanning Tree (MST):");
        for (Edge edge : mst) {
            System.out.println("Edge: " + edge.source + " - " + edge.destination + " (Weight: " + edge.weight + ")");
        }
    }
}

public class KruskalsAlgorithm {
    public static void main(String[] args) {
        int vertices = 5;
        KruskalGraph graph = new KruskalGraph(vertices);

        // Add edges to the graph
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        // Run Kruskal's algorithm
        graph.kruskalMST();
    }
}