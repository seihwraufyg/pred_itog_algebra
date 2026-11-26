import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public static List<Edge> run() {
        List<Edge> sorted = new ArrayList<>(GraphData.undirectedEdges());
        sorted.sort(Comparator.comparingInt(edge -> edge.weight));

        DisjointSet dsu = new DisjointSet(GraphData.N);
        List<Edge> result = new ArrayList<>();
        int total = 0;

        for (Edge edge : sorted) {
            if (dsu.union(edge.from, edge.to)) {
                result.add(edge);
                total += edge.weight;

                if (result.size() == GraphData.N - 1) {
                    break;
                }
            }
        }

        System.out.println("\\nАлгоритм Краскала:");
        for (Edge edge : result) {
            System.out.println(edge);
        }
        System.out.println("Общая стоимость: " + total);

        return result;
    }
}
