package graph;

import java.util.*;

public class GraphSimple {
    private static final int MAX = 100;
    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;
    private static int vertices;
    private static int time = 0;
    private static int[] colors;
    private static int[] distance;
    private static int[] parent;
    private static int[] finish;
    Map<Integer, List<Integer>> map;

    // just a damn constructor
    public GraphSimple(int vertices) {
        map = new HashMap<>();

        this.time = 0;
        this.vertices = vertices;
        colors = new int[MAX];
        distance = new int[MAX];
        parent = new int[MAX];
        finish = new int[MAX];

        for (int i = 0; i < vertices; i++)
            map.put(i, new ArrayList<Integer>());
    }

    public static void main(String[] args) {
        GraphSimple g1 = new GraphSimple(4);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(2, 0);
        g1.addEdge(2, 3);
        g1.addEdge(3, 3);

        System.out.print("BFS Traversal:");
        g1.BFS(2);
        System.out.print("DFS Traversal:");
        g1.DFS(2);
    }

    public void addEdge(int source, int destination) {
        if (!map.containsKey(source) || !map.containsKey(destination))
            throw new IllegalArgumentException("Vertices are invalid");

        List<Integer> listA = map.get(source);
        listA.add(destination);

        List<Integer> listB = map.get(destination);
        listB.add(source);
    }

    public void BFS(int source) {
        Arrays.fill(colors, WHITE);
        Arrays.fill(distance, 0);
        Arrays.fill(parent, -1);

        // visit the source first and make it gray
        colors[source] = GRAY;
        parent[source] = -1;
        distance[source] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.println(temp);

            List<Integer> adjacencyList = map.get(temp);
            for (int vertex : adjacencyList) {
                if (colors[vertex] == WHITE) {
                    colors[vertex] = GRAY;
                    distance[vertex] += 1;
                    parent[vertex] = temp;
                    queue.add(vertex);
                }
            }
            colors[temp] = BLACK;
        }
    }

    public void DFS(int source) {
        Arrays.fill(colors, WHITE);
        Arrays.fill(distance, 0);
        Arrays.fill(parent, -1);
        time = 0;

        for (int vertex : map.keySet())
            if (colors[source] == WHITE)
                doDFS(source);
    }

    private void doDFS(int source) {
        colors[source] = GRAY;
        time++;
        distance[source] = time;

        System.out.print(source + " ");
        for (int vertex : map.get(source)) {
            if (colors[vertex] == WHITE) {
                parent[vertex] = source;
                doDFS(vertex);
            }
        }

        colors[source] = BLACK;
        time++;
        finish[source] = time;


    }


}
