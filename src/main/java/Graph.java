import java.util.*;

/**
 * File: Graph.java
 * Description: Assignment 2.2 Applied Data Structures
 * Author: Lyndsey Threlfall
 * Student ID: a3005482
 * Email ID: a3005482
 * AI Tool Used: Y
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/

public class Graph {

    // Stores the graph as an adjacency list where each course maps
    // to a list of courses that depend on it
    private Map<String, ArrayList<String>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addCourse(String course) {
        adjacencyList.put(course, new ArrayList<>());
    }

    public void printGraph() {
        System.out.println(adjacencyList);
    }

    public void addEdge(String prerequisite, String course) {
        if (!adjacencyList.containsKey(prerequisite)) {
            System.out.println("Warning: prerequisite not found: " + prerequisite);
            return;
        }

        adjacencyList.get(prerequisite).add(course);
    }

    public Map<String, Integer> calculateIndegrees() {

        Map<String, Integer> indegrees = new HashMap<>();

        for (String course : adjacencyList.keySet()) {
            indegrees.put(course, 0);
        }

        for (String course : adjacencyList.keySet()) {

            for (String neighbour : adjacencyList.get(course)) {

                indegrees.put(
                        neighbour,
                        indegrees.get(neighbour) + 1
                );
            }
        }

        return indegrees;
    }

    public Map<String, ArrayList<String>> getAdjacencyList() {
        return adjacencyList;
    }

    @Override
    public String toString() {
        return adjacencyList.toString();
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Graph)) {
            return false;
        }

        Graph other = (Graph) obj;

        return adjacencyList.equals(other.adjacencyList);
    }

    @Override
    public int hashCode() {
        return adjacencyList.hashCode();
    }
}
