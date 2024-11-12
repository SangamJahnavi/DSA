import java.util.ArrayList;

public class Bellmanford {
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

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));

    }

    public static void Bellman(ArrayList<Edge>[] graph, int src, int vv) {
        int[] dis = new int[vv];
        for (int i = 0; i < vv; i++) {
            if (i != src) {
                dis[i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < vv - 1; i++) {
            for (int j = 0; j < vv; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    // relaxation
                    if (dis[u] != Integer.MAX_VALUE && dis[u] + e.wt < dis[v]) {
                        dis[v] = dis[u] + e.wt;
                    }
                }
            }
        }
        for (int i = 0; i < vv; i++) {
            System.out.println(dis[i]);
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        creategraph(graph);
        Bellman(graph, 0, v);
    }

}
