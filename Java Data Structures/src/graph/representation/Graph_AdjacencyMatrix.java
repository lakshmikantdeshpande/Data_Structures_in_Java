// unweighted undirected graph
// boook

package graph.representation;

public class Graph_AdjacencyMatrix {
    private boolean[][] adjacencyMatrix;
    private int vertices;

    public Graph_AdjacencyMatrix(int vertices) {
        if (vertices <= 0)
            vertices = 10;
        this.vertices = vertices;
        this.adjacencyMatrix = new boolean[vertices][vertices];
    }

    public void addEdge(int i, int j) {
        if ((i >= 0 && i < vertices) && (j >= 0 && j < vertices)) {
            adjacencyMatrix[i][j] = true;
            adjacencyMatrix[j][i] = true;
        }
    }

    public void removeEdge(int i, int j) {
        if ((i >= 0 && i < vertices) && (j >= 0 && j < vertices)) {
            adjacencyMatrix[i][j] = true;
            adjacencyMatrix[j][i] = true;
        }
    }

    public boolean isEdge(int i, int j) {
        if ((i >= 0 && i < vertices) && (j >= 0 && j < vertices))
            return adjacencyMatrix[i][j];
        return false;
    }

}
