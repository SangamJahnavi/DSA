import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstrassrcdest {
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void creategraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }

    public static class Pair implements Comparable<Pair> {
        int node;
        int wt;

        Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.wt - p2.wt;
        }
    }

    public static void Dijkstra(ArrayList<Edge>[] graph, int src, int vv, int dest) {
        boolean[] vis = new boolean[vv];
        int[] dis = new int[vv];
        for (int i = 0; i < vv; i++) {
            if (i != src) {
                dis[i] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair p1 = pq.remove();
            if (vis[dest]) {
                System.out.println(dis[dest]);
                return;
            }
            if (!vis[p1.node]) {
                vis[p1.node] = true;
                for (int i = 0; i < graph[p1.node].size(); i++) {
                    Edge e = graph[p1.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    // relaxation
                    if (dis[u] + e.wt < dis[v]) {
                        dis[v] = dis[u] + e.wt;
                        pq.add(new Pair(v, dis[v]));
                    }
                }
            }
        }
        // for (int i = 0; i < 7; i++) {
        // System.out.println(dis[i]);
        // }
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        creategraph(graph);
        Dijkstra(graph, 0, v, 1);
        Dijkstra(graph, 0, v, 2);
        Dijkstra(graph, 0, v, 3);
        Dijkstra(graph, 0, v, 4);
        Dijkstra(graph, 0, v, 5);
    }
}
