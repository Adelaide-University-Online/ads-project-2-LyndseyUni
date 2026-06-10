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

    // Constructs and empty graph
    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Adds a course as a vertex in the graph
    public void addCourse(String course) {
        adjacencyList.put(course, new ArrayList<>());
    }

    // Displays the graph structure
    public void printGraph() {
        System.out.println(adjacencyList);
    }

    // Adds a directed edge from a pre-requisite course
    // to the course that requires it
    public void addEdge(String prerequisite, String course) {
        // Ensure the pre-requisite exists in the graph
        if (!adjacencyList.containsKey(prerequisite)) {
            System.out.println("Warning: prerequisite not found: " + prerequisite);
            return;
        }

        adjacencyList.get(prerequisite).add(course);
    }

    // Calculates the indegree of every course
    public Map<String, Integer> calculateIndegrees() {

        Map<String, Integer> indegrees = new HashMap<>();

        // Initialise all indegrees to zero
        for (String course : adjacencyList.keySet()) {
            indegrees.put(course, 0);
        }

        // For loop to count all incoming edges for each course
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

    // Returns the adjacency list representation of the graph
    public Map<String, ArrayList<String>> getAdjacencyList() {
        return adjacencyList;
    }

    // Returns a String representation of the graph
    @Override
    public String toString() {
        return adjacencyList.toString();
    }

    // Compares two Graph objects for equality
    @Override
    public boolean equals(Object obj) {

        // Checks if both references point to the same object
        if (this == obj) {
            return true;
        }

        // Ensure the object is a Graph
        if (!(obj instanceof Graph)) {
            return false;
        }

        Graph other = (Graph) obj;

        // Compares adjacency lists
        return adjacencyList.equals(other.adjacencyList);
    }

    // Generates a hashCode based on the adjacency list
    @Override
    public int hashCode() {
        return adjacencyList.hashCode();
    }
}
