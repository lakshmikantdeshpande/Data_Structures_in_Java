package graph.algorithms;

import java.util.*;

class Graph {
    private static final int MAX = 100;
    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;
    static Map<Integer, List<Integer>> map;
    private static int[] colors;
    private static int[] finished;
    private static int[] distance;
    private static int[] parent;
    private static int time;
    private final List<Integer> topologicalLinkedList;

    public Graph() {
        map = new HashMap<>();
        colors = new int[MAX];
        distance = new int[MAX];
        finished = new int[MAX];
        parent = new int[MAX];
        time = 0;
        topologicalLinkedList = new LinkedList<>();
    }

    public void addEdge(int source, int destination) {
        if (!map.containsKey(destination))
            map.put(destination, new LinkedList<>());

        if (map.containsKey(source)) {
            List<Integer> list = map.get(source);
            list.add(destination);
        } else {
            List<Integer> list = new LinkedList<>();
            list.add(destination);
            map.put(source, list);
        }
//         if it would be an undirected graph
//        List destinationList = map.get(destination);
//        destinationList.add(source);
    }

    //     not necessary for topological sort,
//     wrote for practice
    public void BFS(int source) {
        if (!map.containsKey(source))
            return;

        Arrays.fill(colors, WHITE);
        Arrays.fill(distance, 0);
        Arrays.fill(parent, -1);

        colors[source] = GRAY;
        distance[source] = 0;
        parent[source] = -1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            List<Integer> vertexList = map.get(temp);
            if (vertexList == null) {
                return;
            }
            System.out.print(temp + " ");
            for (int vertex : vertexList) {
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


    public void DFS(int source) {
        Arrays.fill(colors, WHITE);
        Arrays.fill(distance, 0);
        Arrays.fill(parent, -1);
        Arrays.fill(finished, 0);
        time = 0;

        for (int vertex : map.keySet()) {
//        for (int vertex : map.get(source)) {   // to start DFS from a particular edge
            if (colors[vertex] == WHITE)
                DFSUtil(vertex);
        }
    }

    private void DFSUtil(int source) {
        time++;  // update time
        distance[source] += 1;
        colors[source] = GRAY; // visited, so update color

        System.out.print(source + " ");
        for (int vertex : map.get(source)) {
            if (colors[vertex] == WHITE) {
                parent[vertex] = source;  // set parent
                DFSUtil(vertex);
            }
        }

        colors[source] = BLACK;
        time++;
        finished[source] = time;
        topologicalLinkedList.add(0, source);
    }

    public void printTopologicallySorted() {
        for (int x : topologicalLinkedList)
            System.out.print(x + "->");
    }

}


public class Topological_Sort {
    public static void main(String args[]) {
        Graph g = new Graph();

        g.addEdge(7, 11);
        g.addEdge(7, 8);
        g.addEdge(3, 2);
        g.addEdge(3, 10);
        g.addEdge(5, 11);
        g.addEdge(11, 2);
        g.addEdge(11, 2);
        g.addEdge(8, 9);
//        g.addEdge(3, 2);

        g.DFS(2);
        System.out.println();
        g.printTopologicallySorted();
        System.out.println();
        g.BFS(7);

    }
}
