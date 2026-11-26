import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFord {
    public static void run() {
        List<Edge> edges = new ArrayList<>();

        for (Edge edge : GraphData.directedEdges()) {
            int weight = (edge.from == 3 && edge.to == 4) ? -2 : edge.weight;
            edges.add(new Edge(edge.from, edge.to, weight));
        }

        int[] dist = new int[GraphData.N];
        Arrays.fill(dist, GraphData.INF);
        dist[0] = 0;

        relaxEdges(dist, edges);

        System.out.println("\\nБеллман — Форд:");
        System.out.println("Минимальная стоимость A -> F: " + dist[5]);

        edges.add(new Edge(4, 1, -4));

        Arrays.fill(dist, GraphData.INF);
        dist[0] = 0;
        relaxEdges(dist, edges);

        boolean[] affected = new boolean[GraphData.N];

        for (Edge edge : edges) {
            if (dist[edge.from] != GraphData.INF
                    && dist[edge.from] + edge.weight < dist[edge.to]) {
                affected[edge.to] = true;
            }
        }

        for (int i = 0; i < GraphData.N; i++) {
            for (Edge edge : edges) {
                if (affected[edge.from]) {
                    affected[edge.to] = true;
                }
            }
        }

        if (affected[5]) {
            System.out.println("После добавления E -> B конечной минимальной стоимости нет.");
            System.out.println("Причина: существует достижимый отрицательный цикл, "
                    + "из которого можно попасть в F.");
        } else {
            System.out.println("После добавления E -> B стоимость A -> F: " + dist[5]);
        }
    }

    private static void relaxEdges(int[] dist, List<Edge> edges) {
        for (int i = 0; i < GraphData.N - 1; i++) {
            boolean changed = false;

            for (Edge edge : edges) {
                if (dist[edge.from] != GraphData.INF
                        && dist[edge.from] + edge.weight < dist[edge.to]) {
                    dist[edge.to] = dist[edge.from] + edge.weight;
                    changed = true;
                }
            }

            if (!changed) {
                break;
            }
        }
    }
}
