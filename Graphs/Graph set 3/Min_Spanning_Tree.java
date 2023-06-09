import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Min_Spanning_Tree
 */
public class Min_Spanning_Tree {

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
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    // to sort the cost i.e based on the cost in ascending order
    public static class Pair implements Comparable<Pair> {
        int node;
        int cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p) {
            return this.cost - p.cost;
        }
    }

    public static void Prims_Algorithm(ArrayList<Edge> graph[], int vertices) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // Non-MST
        boolean visited[] = new boolean[vertices]; // MST

        pq.add(new Pair(0, 0));
        int MST_Cost = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.remove();
            if (!visited[current.node]) {
                visited[current.node] = true;
                MST_Cost += current.cost;

                for (int i = 0; i < graph[current.node].size(); i++) {
                    Edge e = graph[current.node].get(i);
                    if (!visited[e.destination]) {
                        pq.add(new Pair(e.destination, e.weight));
                    }
                }
            }
        }
        System.out.println("min cost of MST = " + MST_Cost);
    }

    public static void main(String[] args) {
        int vertices = 4;
        @SuppressWarnings("unchecked")

        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        Prims_Algorithm(graph, vertices);
    }
}