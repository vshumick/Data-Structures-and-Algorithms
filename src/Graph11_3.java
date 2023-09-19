import java.util.*;

// Тип графа: матрица смежности (adjacency matrix)
public class Graph11_3 {
    private int currentSize;
    private Map<String, Integer> nodeIndexMap;
    private int[][] adjacencyMatrix;

    public Graph11_3() {
        this.currentSize = 0;
        this.nodeIndexMap = new HashMap<>();
        this.adjacencyMatrix = new int[currentSize][currentSize];
    }

    public void addNode(String s) {
        if (!nodeIndexMap.containsKey(s)) {
            nodeIndexMap.put(s, currentSize);

            currentSize++;
            int[][] newMatrix = new int[currentSize][currentSize];
            for (int i = 0; i < currentSize - 1; i++) {
                for (int j = 0; j < currentSize - 1; j++) {
                    newMatrix[i][j] = adjacencyMatrix[i][j];
                }
            }

            adjacencyMatrix = newMatrix;
        }
    }

    public void removeNode(String s) {
        if (nodeIndexMap.containsKey(s)) {
            int indexToRemove = nodeIndexMap.get(s);

            int[][] newMatrix = new int[currentSize - 1][currentSize - 1];

            int iOffset = 0, jOffset = 0;
            for (int i = 0; i < currentSize; i++) {
                if (i == indexToRemove) {
                    iOffset = -1;
                    continue;
                }
                for (int j = 0; j < currentSize; j++) {
                    if (j == indexToRemove) {
                        jOffset = -1;
                        continue;
                    }
                    newMatrix[i + iOffset][j + jOffset] = adjacencyMatrix[i][j];
                }
                jOffset = 0;
            }

            nodeIndexMap.remove(s);

            for (Map.Entry<String, Integer> entry : nodeIndexMap.entrySet()) {
                if (entry.getValue() > indexToRemove) {
                    entry.setValue(entry.getValue() - 1);
                }
            }

            currentSize--;
            adjacencyMatrix = newMatrix;
        }
    }

    public void addEdge(String s1, String s2) {
        if (nodeIndexMap.containsKey(s1) && nodeIndexMap.containsKey(s2)) {
            int sourceIndex = nodeIndexMap.get(s1);
            int destinationIndex = nodeIndexMap.get(s2);

            adjacencyMatrix[sourceIndex][destinationIndex] = 1;
            adjacencyMatrix[destinationIndex][sourceIndex] = 1;  // Граф ненаправленный
        }
    }

    public void removeEdge(String s1, String s2) {
        if (nodeIndexMap.containsKey(s1) && nodeIndexMap.containsKey(s2)) {
            int sourceIndex = nodeIndexMap.get(s1);
            int destinationIndex = nodeIndexMap.get(s2);

            adjacencyMatrix[sourceIndex][destinationIndex] = 0;
            adjacencyMatrix[destinationIndex][sourceIndex] = 0;  // Граф ненаправленный
        }
    }

    public boolean isAdjacentNodes(String s1, String s2) {
        if (nodeIndexMap.containsKey(s1) && nodeIndexMap.containsKey(s2)) {
            int sourceIndex = nodeIndexMap.get(s1);
            int destinationIndex = nodeIndexMap.get(s2);

            return adjacencyMatrix[sourceIndex][destinationIndex] == 1;
        }
        return false;
    }

    private String getNodeByIndex(int index) {
        for (Map.Entry<String, Integer> entry : nodeIndexMap.entrySet()) {
            if (entry.getValue().equals(index)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public List<String> getAdjacentNodeList(String s) {
        List<String> adjacentVertices = new ArrayList<>();

        if (nodeIndexMap.containsKey(s)) {
            int index = nodeIndexMap.get(s);

            for (int j = 0; j < currentSize; j++) {
                if (adjacencyMatrix[index][j] == 1) {
                    adjacentVertices.add(getNodeByIndex(j));
                }
            }
        }

        return adjacentVertices;
    }

    public void printMatrix() {
        for (int i = 0; i < currentSize; i++) {
            for (int j = 0; j < currentSize; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Graph{nodes=").append(nodeIndexMap.keySet().toString()).append(", ");
        sb.append("edges=[");

        Set<String> addedEdges = new HashSet<>(); // Для отслеживания уже добавленных рёбер

        boolean first = true;
        for (String source : nodeIndexMap.keySet()) {
            for (String dest : getAdjacentNodeList(source)) {
                // Создаем строковое представление ребра, учитывая возможные комбинации вершин
                String edge1 = source + "-" + dest;
                String edge2 = dest + "-" + source;

                // Добавляем ребро, только если его еще не было добавлено в множество
                if (!addedEdges.contains(edge1) && !addedEdges.contains(edge2)) {
                    if (!first) {
                        sb.append(",");
                    }
                    first = false;
                    sb.append("{").append(source).append(", ").append(dest).append("}");
                    addedEdges.add(edge1);
                    addedEdges.add(edge2);
                }
            }
        }
        sb.append("]}");

        return sb.toString();
    }
}
