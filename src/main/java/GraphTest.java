import com.sun.source.tree.AssertTree;
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

    @Test
    public void graphsWithSameCoursesAreEqual() {

        Graph graph1 = new Graph();
        Graph graph2 = new Graph();

        graph1.addCourse("COMP1043");
        graph2.addCourse("COMP1043");

        assertEquals(graph1, graph2);
    }

    @Test
    public void equalGraphsHaveSameHashCode() {

        Graph graph1 = new Graph();
        Graph graph2 = new Graph();

        assertEquals(
                graph1.hashCode(),
                graph2.hashCode()
        );
    }

    @Test
    public void toStringContainsCourseName() {

        Graph graph = new Graph();

        graph.addCourse("COMP1043");

        assertTrue(
                graph.toString().contains("COMP1043")
        );
    }
}
