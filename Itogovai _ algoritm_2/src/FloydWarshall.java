import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    public static int[][] run() {
        int n = GraphData.N;
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], GraphData.INF);
            dist[i][i] = 0;
        }

        List<Edge> edges = GraphData.directedEdges();
        for (Edge edge : edges) {
            dist[edge.from][edge.to] = edge.weight;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != GraphData.INF
                            && dist[k][j] != GraphData.INF) {
                        dist[i][j] = Math.min(
                                dist[i][j],
                                dist[i][k] + dist[k][j]
                        );
                    }
                }
            }
        }

        System.out.println("\\nФлойд — Уоршелл:");
        System.out.print("    ");
        for (char vertex : GraphData.VERTICES) {
            System.out.printf("%5c", vertex);
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.printf("%3c ", GraphData.VERTICES[i]);
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == GraphData.INF) {
                    System.out.printf("%5s", "∞");
                } else {
                    System.out.printf("%5d", dist[i][j]);
                }
            }
            System.out.println();
        }

        return dist;
    }
}
