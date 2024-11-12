import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void creategraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topsort(ArrayList<Edge>[] graph, boolean[] vis, int curr, Stack<Integer> s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topsort(graph, vis, e.dest, s);
            }
        }
        s.push(curr);
    }

    public static void topologicalsort(ArrayList<Edge>[] graph, int v) {
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                topsort(graph, vis, i, s);
            }
        }
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        creategraph(graph);
        topologicalsort(graph, v);

    }

}
