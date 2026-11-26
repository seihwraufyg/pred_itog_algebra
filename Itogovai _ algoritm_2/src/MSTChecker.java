import java.util.List;

public class MSTChecker {
    public static boolean isValidTree(List<Edge> tree) {
        if (tree.size() != GraphData.N - 1) {
            return false;
        }

        DisjointSet dsu = new DisjointSet(GraphData.N);

        for (Edge edge : tree) {
            if (!dsu.union(edge.from, edge.to)) {
                return false; // В дереве не должно быть циклов.
            }
        }

        int root = dsu.find(0);
        for (int i = 1; i < GraphData.N; i++) {
            if (dsu.find(i) != root) {
                return false;
            }
        }

        return true;
    }

    public static int totalWeight(List<Edge> tree) {
        int total = 0;
        for (Edge edge : tree) {
            total += edge.weight;
        }
        return total;
    }
}
