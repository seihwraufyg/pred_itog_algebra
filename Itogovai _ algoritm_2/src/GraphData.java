import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GraphData {
    public static final int N = 6;
    public static final int INF = 1_000_000_000;
    public static final char[] VERTICES = {'A', 'B', 'C', 'D', 'E', 'F'};

    private GraphData() {
    }

    public static List<Edge> directedEdges() {
        return new ArrayList<>(Arrays.asList(
                new Edge(0, 1, 4),  // A -> B
                new Edge(0, 2, 2),  // A -> C
                new Edge(2, 1, 1),  // C -> B
                new Edge(1, 3, 5),  // B -> D
                new Edge(2, 3, 8),  // C -> D
                new Edge(3, 4, 2),  // D -> E
                new Edge(1, 4, 10), // B -> E
                new Edge(4, 5, 3)   // E -> F
        ));
    }

    public static List<Edge> undirectedEdges() {
        return new ArrayList<>(Arrays.asList(
                new Edge(0, 1, 6), // A - B
                new Edge(0, 2, 3), // A - C
                new Edge(1, 2, 2), // B - C
                new Edge(1, 3, 5), // B - D
                new Edge(2, 3, 4), // C - D
                new Edge(2, 4, 7), // C - E
                new Edge(3, 4, 2), // D - E
                new Edge(3, 5, 6), // D - F
                new Edge(4, 5, 3)  // E - F
        ));
    }
}
