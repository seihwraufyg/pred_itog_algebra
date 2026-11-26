import java.util.ArrayList;
import java.util.List;

public class Prim {
    public static List<Edge> run() {
        boolean[] visited = new boolean[GraphData.N];
        List<Edge> result = new ArrayList<>();
        visited[0] = true;
        int total = 0;

        while (result.size() < GraphData.N - 1) {
            Edge best = null;

            for (Edge edge : GraphData.undirectedEdges()) {
                boolean connectsTree =
                        (visited[edge.from] && !visited[edge.to])
                        || (visited[edge.to] && !visited[edge.from]);

                if (connectsTree && (best == null || edge.weight < best.weight)) {
                    best = edge;
                }
            }

            if (best == null) {
                throw new IllegalStateException("Граф не является связным.");
            }

            result.add(best);
            visited[best.from] = true;
            visited[best.to] = true;
            total += best.weight;
        }

        System.out.println("\\nАлгоритм Прима:");
        for (Edge edge : result) {
            System.out.println(edge);
        }
        System.out.println("Общая стоимость: " + total);

        return result;
    }
}
