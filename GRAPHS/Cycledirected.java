import java.util.ArrayList;

public class Cycledirected {
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

        // graph[1].add(new Edge(1, 0));

        // graph[0].add(new Edge(0, 2));

        // graph[2].add(new Edge(2, 3));

        // graph[3].add(new Edge(3, 0));
        graph[0].add(new Edge(0, 1));

        // graph[2].add(new Edge(2, 1));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 2));

    }

    public static boolean cycle(ArrayList<Edge>[] graph, boolean vis[], int curr,
            boolean rec[]) {
        vis[curr] = true;
        rec[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (rec[e.dest]) {
                return true;
            } else if (!vis[e.dest]) {
                if (cycle(graph, vis, e.dest, rec)) {
                    return true;
                }

            }
        }
        rec[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[5];
        creategraph(graph);
        System.out.println(cycle(graph, new boolean[5], 0, new boolean[5]));

        // for dis connected graph

        // boolean vis[] = new boolean[5];
        // boolean[] rec = new boolean[5];

        // for (int i = 0; i < 5; i++) {
        // if (!vis[i]) {
        // if (cycle(graph, vis, 0, rec)) {
        // System.out.println(cycle(graph, vis, 0, rec));
        // }
        // }
        // }
    }
}
