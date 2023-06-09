import java.util.ArrayList;
import java.util.PriorityQueue;

public class GetPrint {
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

    public static void dijkstrasAlgorithm(ArrayList<Edge> graph[], int source, int vertices) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int distance[] = new int[vertices];
        boolean visited_Array[] = new boolean[vertices];

        // at index 0 -> 0 willbe get intilzed and restall index are initilized with
        // infinite
        for (int i = 0; i < distance.length; i++) {
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

                    if (distance[u] + e.weight < distance[v]) {
                        distance[v] = distance[u] + e.weight;
                        pq.add(new Pair(v, distance[v]));
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
        int vertices = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        dijkstrasAlgorithm(graph, 0, vertices);

    }
}
