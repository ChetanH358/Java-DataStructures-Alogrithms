
import java.util.ArrayList;

public class Cycles_In_graph {
    static class Edge {
        int source;
        int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        // adding
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        // graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
        // graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));
    }

    public static boolean isCycleUndirected(ArrayList<Edge> graph[], boolean visited[], int current, int parent) {
        visited[current] = true;
        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if (visited[e.destination] && e.destination != parent) {
                return true;
            } else if (!visited[e.destination]) {
                boolean isCycle = isCycleUndirected(graph, visited, e.destination, current);
                if (isCycle == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int vertices = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        boolean visited_array[] = new boolean[vertices];
        // Node is zero and parent is -1
        boolean iscycle = isCycleUndirected(graph, visited_array, 0, -1);
        System.out.println(iscycle);

    }
}
