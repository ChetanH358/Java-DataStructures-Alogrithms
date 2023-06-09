import java.util.ArrayList;

/*
 * Time complexity -> O (V+E)
 */

public class Cycle_Detection {
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
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

    public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean visited_array[], int current,
            boolean recusive_stack[]) {
        visited_array[current] = true;
        recusive_stack[current] = true;

        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if (recusive_stack[e.destination] == true) {
                return true;
            } else if (!visited_array[e.destination]) {
                boolean does_cycle_exist = isCycleDirected(graph, visited_array, e.destination, recusive_stack);
                if (does_cycle_exist) {
                    return true;
                }
            }
        }
        recusive_stack[current] = false;
        return false;
    }

    public static void main(String[] args) {
        int vertices = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        boolean visited_array[] = new boolean[vertices];
        boolean recursive_stack[] = new boolean[vertices];

        /*
         * this function won't cover all nodes -->
         * System.out.println(isCycleDirected(graph, visited_array, 0,
         * recursive_stack));
         */

        // visiting all nodes by for loop
        for (int i = 0; i < vertices; i++) {
            if (!visited_array[i]) {
                Boolean is_cycle = isCycleDirected(graph, visited_array, 0,
                        recursive_stack);
                if (is_cycle) {
                    // we may get multiple cycles exist but if, we get one single cycle we break
                    System.out.println(is_cycle + " : yes cycle exist");
                    break;
                }
            }
        }

    }
}