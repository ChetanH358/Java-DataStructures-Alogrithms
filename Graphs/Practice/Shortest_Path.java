import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * Dijkstras Algorithm ----->>>>>
 */
public class Shortest_Path {

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

    public static void creategraph(ArrayList<Edge> graph[]) {
        // crating a new arraylist of element type of edge
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }

    public static class Pair implements Comparable<Pair> {
        int node;
        int distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Pair p) {
            return this.distance - p.distance;
        }
    }

    public static void dijkstras_algo(ArrayList<Edge> graph[], int source, int vertices) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int distance[] = new int[vertices];
        boolean visited_Array[] = new boolean[vertices];

        for (int i = 0; i < distance.length; i++) {
            // here we are making every thing infinte except first index
            if (i != 0) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.remove();
            if (!visited_Array[current.node]) {
                visited_Array[current.node] = true;

                for (int i = 0; i < graph[current.node].size(); i++) {
                    Edge e = graph[current.node].get(i);
                    int u = e.source;
                    int v = e.destination;
                    // int weight = e.weight;

                    if (distance[u] + e.weight < distance[v]) {
                        distance[v] = distance[u] + e.weight;
                        pq.add(new Pair(v, distance[v]));
                    }
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            System.out.println(distance[i] + " ");
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        creategraph(graph);
        dijkstras_algo(graph, 0, vertices);
    }
}