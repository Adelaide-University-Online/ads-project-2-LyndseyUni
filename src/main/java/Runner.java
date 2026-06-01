import java.io.File;
import java.util.Scanner;

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

        graph.printGraph();

        file.close();
    }
}
