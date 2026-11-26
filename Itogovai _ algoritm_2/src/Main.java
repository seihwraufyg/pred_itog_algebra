import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== ЧАСТЬ 1 =====");

        int[] dijkstraResult = Dijkstra.run(0, GraphData.directedEdges());

        BellmanFord.run();

        int[][] floydResult = FloydWarshall.run();

        boolean same = true;
        for (int i = 0; i < GraphData.N; i++) {
            if (dijkstraResult[i] != floydResult[0][i]) {
                same = false;
                break;
            }
        }

        System.out.println("\\nПроверка Дейкстры и строки A Флойда: "
                + (same ? "совпадают" : "не совпадают"));

        System.out.println("\\n===== ЧАСТЬ 2 =====");

        List<Edge> primTree = Prim.run();
        List<Edge> kruskalTree = Kruskal.run();

        System.out.println("\\nПроверка дерева Прима: "
                + (MSTChecker.isValidTree(primTree)
                ? "6 вершин соединены, 5 рёбер, циклов нет."
                : "ошибка построения дерева."));

        System.out.println("Проверка дерева Краскала: "
                + (MSTChecker.isValidTree(kruskalTree)
                ? "6 вершин соединены, 5 рёбер, циклов нет."
                : "ошибка построения дерева."));

        int primCost = MSTChecker.totalWeight(primTree);
        int kruskalCost = MSTChecker.totalWeight(kruskalTree);

        System.out.println("Стоимость Прима и Краскала совпадает: "
                + (primCost == kruskalCost));

        System.out.println("\\n===== ПОСЛЕДНИЙ ВОПРОС =====");
        System.out.println("В полном графе: A -> C -> B = 3 + 2 = 5.");
        System.out.println("В дереве Прима: A -> C -> B = 3 + 2 = 5.");
        System.out.println("Ответ: да, путь остался кратчайшим.");
    }
}
