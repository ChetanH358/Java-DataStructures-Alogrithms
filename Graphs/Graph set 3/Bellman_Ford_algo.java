import java.util.ArrayList;

/**
 * Bellman_Ford_algo
 */
public class Bellman_Ford_algo {

    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        // adding
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    public static void bellman_ford(ArrayList<Edge> graph[], int source, int vertices) {
        int distance[] = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            if (i != source) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        for (int k = 0; k < vertices - 1; k++) { // O(V)
            // O(E)
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.source;
                    int v = e.destination;

                    if (distance[u] != Integer.MAX_VALUE && distance[u] + e.weight < distance[v]) {
                        distance[v] = distance[u] + e.weight;
                    }
                }
            }
        }

        // to detect negative weight cycle
        for (int k = 0; k < vertices - 1; k++) { // O(V)
            // O(E)
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.source;
                    int v = e.destination;

                    if (distance[u] != Integer.MAX_VALUE && distance[u] + e.weight < distance[v]) {
                        System.out.println("negative weight cycle");
                    }
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int vertices = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        bellman_ford(graph, 0, vertices);
    }
}