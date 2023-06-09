import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Breadth_First_Search {
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
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    public static void breadth_first_search(ArrayList<Edge> graph[], int vertices) {
        Queue<Integer> q = new LinkedList<>();
        boolean visited_array[] = new boolean[vertices];
        q.add(0);

        while (!q.isEmpty()) {
            int current = q.remove();
            if (visited_array[current] == false) {
                System.out.print(current + " ");
                visited_array[current] = true;
                for (int i = 0; i < graph[current].size(); i++) {
                    Edge e = graph[current].get(i);
                    q.add(e.destination);
                }
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int vertices = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        breadth_first_search(graph, vertices);

    }
}
