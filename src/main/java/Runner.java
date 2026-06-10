import java.io.File;
import java.util.*;

/**
 * File: Runner.java
 * Description: Assignment 2.2 Applied Data Structures
 * Author: Lyndsey Threlfall
 * Student ID: a3005482
 * Email ID: a3005482
 * AI Tool Used: Y
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/

public class Runner {

    public static void main(String[] args) throws Exception {

        // Create a scanner object to read user input from keyboard entry
        Scanner keyboard = new Scanner(System.in);

        // Ask the user for the input text file containing the list of courses
        System.out.print("Enter filename: ");
        String filename = keyboard.nextLine();

        // Ask the user for the maximum number of courses allowed per study period
        System.out.print("Maximum courses per study period: ");
        int maxCourses = keyboard.nextInt();
        System.out.println("Max courses = " + maxCourses);

        // Open the file for reading
        Scanner file = new Scanner(new File(filename));

        // Read the first line
        String firstLine = file.nextLine();

        System.out.println(firstLine);

        // Split the course list into individual course names
        String[] courses = firstLine.split(",");

        // Create a graph to store course pre-requisites
        Graph graph = new Graph();

        // For loop to add each course as a vertex in the graph
        for (String course : courses) {
            graph.addCourse(course.trim());
        }

        // Read the remaining lines of the file to build pre-requisite edges
        while (file.hasNextLine()) {

            String line = file.nextLine();

            String[] parts = line.split(",");

            // The first item in the course
            String course = parts[0].trim();

            // Remaining items are pre-requisites for that course
            for (int i = 1; i < parts.length; i++) {

                String prerequisite = parts[i].trim();

                // Create a directed edge from pre-requisite to course
                graph.addEdge(prerequisite, course);

            }
        }

        // Calculate the indegree for each course
        Map<String, Integer> indegrees = graph.calculateIndegrees();

        // Queue used for topological sorting
        Queue<String> queue = new LinkedList<>();

        // Add all courses with no pre-requisites to the queue
        for (String course : indegrees.keySet()) {
            if (indegrees.get(course) == 0) {
                queue.add(course);
            }
        }

        // Stores the final course completion order
        ArrayList<String> order = new ArrayList<>();

        // Get the graph adjacency list
        Map<String, ArrayList<String>> adj = graph.getAdjacencyList();

        // Track the current study period number
        int studyPeriod = 1;

        // While loop processes courses until no more are available
        while (!queue.isEmpty()) {

            System.out.println("\nStudy Period " + studyPeriod);

            // Count how many courses have been scheduled this study period
            int coursesThisPeriod = 0;

            // While loop to schedule courses upto the maximum allowed for that study period
            while (!queue.isEmpty() && coursesThisPeriod < maxCourses) {

                // Remove the next available course from the queue
                String current = queue.remove();

                // Add the course to the completion order
                order.add(current);

                // Display the scheduled course
                System.out.println(current);

                coursesThisPeriod++;

                // For loop to update indegrees of course that depend on the current course
                for (String neighbour : adj.get(current)) {

                    indegrees.put(
                            neighbour,
                            indegrees.get(neighbour) - 1
                    );

                    // If statement to determine if all pre-requisites have been completed,
                    // then add the course to the queue
                    if (indegrees.get(neighbour) == 0) {
                        queue.add(neighbour);
                    }

                }

            }

            // Moves to the next study period
            studyPeriod++;

            // Displays print outs of the progress information
            System.out.println("Courses in graph: " + graph.getAdjacencyList().size());
            System.out.println("Courses in order: " + order.size());

            file.close();
        }
    }

}