package graph.representation;

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
    }

    public static void main(String[] args) {
        GraphSimple g = new GraphSimple(4);
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);

        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.print("BFS Traversal:");
        g.BFS(5);
        System.out.print("DFS Traversal:");
        g.DFS();
    }

    public void addEdge(int source, int destination) {
        if (!map.containsKey(destination))
            map.put(destination, new LinkedList<>());

        if (map.containsKey(source)) {
            List list = map.get(source);
            list.add(destination);
        } else {
            List<Integer> list = new LinkedList();
            list.add(destination);
            map.put(source, list);
        }
//         if it would be an undirected graph
//         List destinationList = map.get(destination);
//         destinationList.add(source);
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
            System.out.print(temp + " ");

            List<Integer> adjacencyList = map.get(temp);
            for (int vertex : adjacencyList) {
                if (colors[vertex] == WHITE) {
                    colors[vertex] = GRAY;
                    parent[vertex] = temp;
                    distance[vertex] += 1;
                    queue.add(vertex);
                }
            }
            colors[temp] = BLACK;
        }
    }

    public void DFS() {
        Arrays.fill(colors, WHITE);
        Arrays.fill(distance, 0);
        Arrays.fill(parent, -1);
        time = 0;

        for (int vertex : map.keySet())
            if (colors[vertex] == WHITE)
                doDFS(vertex);
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
