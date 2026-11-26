import java.util.Arrays;
import java.util.List;

public class Dijkstra {
    public static int[] run(int start, List<Edge> edges) {
        int n = GraphData.N;
        int[] dist = new int[n];
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, GraphData.INF);
        Arrays.fill(parent, -1);
        dist[start] = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }

            if (u == -1 || dist[u] == GraphData.INF) {
                break;
            }

            visited[u] = true;

            for (Edge edge : edges) {
                if (edge.from == u && !visited[edge.to]
                        && dist[u] + edge.weight < dist[edge.to]) {
                    dist[edge.to] = dist[u] + edge.weight;
                    parent[edge.to] = u;
                }
            }
        }

        System.out.println("Дейкстра:");
        for (int i = 0; i < n; i++) {
            System.out.println(GraphData.VERTICES[i] + " = "
                    + (dist[i] == GraphData.INF ? "∞" : dist[i]));
        }

        System.out.print("Маршрут A -> F: ");
        printPath(parent, 5);
        System.out.println();

        return dist;
    }

    private static void printPath(int[] parent, int vertex) {
        if (vertex == -1) {
            return;
        }
        printPath(parent, parent[vertex]);
        System.out.print(GraphData.VERTICES[vertex] + " ");
    }
}
