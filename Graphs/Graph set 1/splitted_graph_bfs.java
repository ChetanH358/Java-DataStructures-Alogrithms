import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * this code is applicable for both 
 * if graph is splitted or unsplitted
 */
public class splitted_graph_bfs {
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
        // splitted graph -> Time complexity is O(V+E)
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));
    }

    public static void breadth_first_search(ArrayList<Edge> graph[], int vertices, boolean[] visited_array, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

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
    }

    public static void main(String[] args) {
        int vertices = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        boolean visited_array[] = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (visited_array[i] == false) {
                breadth_first_search(graph, vertices, visited_array, i);
            }
        }
        System.out.println();
    }
}
