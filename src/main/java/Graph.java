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
            System.out.println("Missing prerequisite: " + prerequisite);
            return;
        }

        adjacencyList.get(prerequisite).add(course);
    }
}
