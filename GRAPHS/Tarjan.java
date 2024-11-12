import java.util.ArrayList;

public class Tarjan {
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
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    public static void dfs(ArrayList<Edge>[] graph, int[] dt, int[] low, boolean[] vis, int curr, int parent,
            int time) {
        vis[curr] = true;

        dt[curr] = low[curr] = ++time;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (e.dest == parent) {
                continue;
            } else if (!vis[e.dest]) {
                dfs(graph, dt, low, vis, e.dest, curr, time);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if (dt[curr] < low[e.dest]) {
                    System.out.println(curr + "-----" + e.dest);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[e.dest]);

            }
        }
    }

    public static void getbridge(ArrayList<Edge>[] graph, int v) {
        int[] dt = new int[v];
        int[] low = new int[v];
        boolean[] vis = new boolean[v];
        int time = 0;
        for (int i = 0; i < v; i++) {
            dfs(graph, dt, low, vis, i, -1, time);
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        creategraph(graph);
        getbridge(graph, v);
    }
}