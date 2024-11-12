import java.util.ArrayList;
import java.util.Stack;

public class Kosaraju {
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
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    public static void toposort(ArrayList<Edge>[] graph, boolean[] vis, Stack<Integer> s, int curr) {
        if (!vis[curr]) {
            vis[curr] = true;
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                toposort(graph, vis, s, e.dest);
            }
            s.push(curr);
        }

    }

    public static void dfs(ArrayList<Edge>[] graph, boolean[] vis, int curr) {
        vis[curr] = true;
        System.out.print(curr + " ");
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, vis, e.dest);
            }
        }
    }

    public static void kk(ArrayList<Edge>[] graph, int v) {
        // step-1
        boolean[] vis = new boolean[v];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                toposort(graph, vis, s, i);
            }
        }
        // step-2
        ArrayList<Edge>[] transpose = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            vis[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }
        // step-3
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!vis[curr]) {
                dfs(transpose, vis, curr);
                System.out.println();
            }

        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        creategraph(graph);
        kk(graph, v);
    }
}
