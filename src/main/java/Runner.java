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

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter filename: ");
        String filename = keyboard.nextLine();

        System.out.print("Maximum courses per study period: ");
        int maxCourses = keyboard.nextInt();
        System.out.println("Max courses = " + maxCourses);

        Scanner file = new Scanner(new File(filename));

        String firstLine = file.nextLine();

        System.out.println(firstLine);

        String[] courses = firstLine.split(",");

        Graph graph = new Graph();

        for (String course : courses) {
            graph.addCourse(course.trim());
        }

        while (file.hasNextLine()) {

            String line = file.nextLine();

            String[] parts = line.split(",");

            String course = parts[0].trim();

            for (int i = 1; i < parts.length; i++) {

                String prerequisite = parts[i].trim();

                graph.addEdge(prerequisite, course);

            }
        }

        Map<String, Integer> indegrees = graph.calculateIndegrees();

        Queue<String> queue = new LinkedList<>();

        for (String course : indegrees.keySet()) {
            if (indegrees.get(course) == 0) {
                queue.add(course);
            }
        }

        ArrayList<String> order = new ArrayList<>();

        Map<String, ArrayList<String>> adj = graph.getAdjacencyList();

        int studyPeriod = 1;

        while (!queue.isEmpty()) {

            System.out.println("\nStudy Period " + studyPeriod);

            int coursesThisPeriod = 0;

            while (!queue.isEmpty() && coursesThisPeriod < maxCourses) {

                String current = queue.remove();

                order.add(current);

                System.out.println(current);

                coursesThisPeriod++;

                for (String neighbour : adj.get(current)) {

                    indegrees.put(
                            neighbour,
                            indegrees.get(neighbour) - 1
                    );

                    if (indegrees.get(neighbour) == 0) {
                        queue.add(neighbour);
                    }

                }

            }

            studyPeriod++;

            System.out.println("Courses in graph: " + graph.getAdjacencyList().size());
            System.out.println("Courses in order: " + order.size());

            file.close();
        }
    }

}