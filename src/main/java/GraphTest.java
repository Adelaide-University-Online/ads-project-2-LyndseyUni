import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {

    @Test
    public void addCourseAddsVertex() {

        Graph graph = new Graph();

        graph.addCourse("COMP1043");

        assertTrue(
                graph.getAdjacencyList().containsKey("COMP1043")
        );

    }

    @Test
    public void addEdgeCreatesConnections() {

        Graph graph = new Graph();

        graph.addCourse("A");
        graph.addCourse("B");

        graph.addEdge("A", "B");

        assertTrue(
                graph.getAdjacencyList().get("A").contains("B")
        );

    }

    @Test
    public void calculateIndegreesWorks() {

        Graph graph = new Graph();

        graph.addCourse("A");
        graph.addCourse("B");

        graph.addEdge("A", "B");

        var indegrees = graph.calculateIndegrees();

        assertEquals(0, indegrees.get("A"));
        assertEquals(1, indegrees.get("B"));

    }
}
