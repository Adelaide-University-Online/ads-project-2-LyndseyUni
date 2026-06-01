import java.util.*;

/**
 * File: Deck.java
 * Description: Assignment 2.1 Applied Data Structures
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
}
