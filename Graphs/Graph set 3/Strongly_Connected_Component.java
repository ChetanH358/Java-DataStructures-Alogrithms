import java.util.ArrayList;
import java.util.Stack;

/*
 * Kosaraju's Algorithm :
 */
public class Strongly_Connected_Component {

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
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    public static void topologica_sort(ArrayList<Edge> graph[], int current, boolean visited_array[],
            Stack<Integer> stack) {
        visited_array[current] = true;
        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if (!visited_array[e.destination]) {
                topologica_sort(graph, e.destination, visited_array, stack);
            }
        }
        stack.push(current);
    }

    public static void depth_first_search(ArrayList<Edge> graph[], int current, boolean visited_array[]) {
        visited_array[current] = true;
        System.out.print(current + " ");
        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if (visited_array[e.destination] == false) {
                depth_first_search(graph, e.destination, visited_array);
            }
        }
    }

    public static void KosarajuAlgo(ArrayList<Edge> graph[], int vertices) {
        // step 1 :topological order -> Time Complexity - O(V+E)
        Stack<Integer> stack = new Stack<>();
        boolean visited_array[] = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited_array[i]) {
                topologica_sort(graph, i, visited_array, stack);
            }
        }

        // step 2 :Transpose graph (crating a copy of the graph) - Time complexity
        // O(V+E)
        /*
         * -> creating a transpose array
         * ->initilizing the array
         * -> visiting every neighbour of the graph
         * -> reversing it's source to destination and destination to soruce using for
         * loop
         */
        @SuppressWarnings("unchecked")
        ArrayList<Edge> transpose[] = new ArrayList[vertices];
        for (int i = 0; i < transpose.length; i++) {
            visited_array[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j); // e.source -> e.destination
                transpose[e.destination].add(new Edge(e.destination, e.source));
            }
        }

        // step 3 -> perform DFS on transpose graph - Time compelxity O(V+E)
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited_array[current]) {
                depth_first_search(transpose, current, visited_array);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        KosarajuAlgo(graph, vertices);
    }
}
