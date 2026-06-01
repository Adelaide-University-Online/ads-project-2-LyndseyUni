import java.io.File;
import java.util.Scanner;

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

        String filename = "XBIT.txt";

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

        graph.printGraph();

        file.close();
    }
}
