// Code from Hackerrank BFS DFS tutorial
package graph.trial;

import java.util.*;

public class Graph_AdjacencyList {
    private Map<Integer, Node> map;

    private Node getNode(int id) {
        return map.get(id);
    }

    public void addEdge(int source, int destination) {
        Node s = map.get(source);
        Node d = map.get(destination);
        s.adjacent.add(d);
    }

    public boolean hasPathDFS(int source, int destination) {
        Node s = map.get(source);
        Node d = map.get(destination);
        Set<Integer> visited = new HashSet<>();
        return hasPathDFS(s, d, visited);
    }

    private boolean hasPathDFS(Node source, Node destination, Set<Integer> visited) {
        if (visited.contains(source.id)) {
            return false;
        }

        visited.add(source.id);
        if (source == destination) {
            return true;
        }
        for (Node child : source.adjacent) {
            if (hasPathDFS(child, destination, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasPathBFS(Node source, Node destination) {
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(source);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node == destination) {
                return true;
            }

            if (visited.contains(node.id)) {
                continue;
            }
            visited.add(node.id);

            queue.addAll(node.adjacent); // iterate and add all adjacent nodes to the queue
        }
        return false;
    }

    private static class Node {
        List<Node> adjacent = new LinkedList<>();
        private int id;

        private Node(int id) {
            this.id = id;
        }
    }

}
