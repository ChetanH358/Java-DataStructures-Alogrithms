
import java.util.ArrayList;

public class cycle_detection {
    static class Edge {
        int source;
        int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    public static void creategraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        // adding
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

    public static boolean Is_Cycle_exist(ArrayList<Edge> graph[], boolean visited_Array[], int current,
            boolean[] recursive_stack) {
        visited_Array[current] = true;
        recursive_stack[current] = true;

        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if (recursive_stack[e.destination] == true) {
                return true;
            } else if (!visited_Array[e.destination]) {
                boolean does_cycle_exist = Is_Cycle_exist(graph, visited_Array, e.destination, recursive_stack);
                if (does_cycle_exist) {
                    return true;
                }
            }

        }
        // if in case cycle not found in one path then we should make the rec_stack ->
        // false and also return false
        recursive_stack[current] = false;
        return false;
    }

    public static void main(String[] args) {
        int vertices = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        creategraph(graph);
        boolean visted_Array[] = new boolean[vertices];
        boolean recursive_stack[] = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visted_Array[i]) {
                boolean is_cycle = Is_Cycle_exist(graph, visted_Array, 0, recursive_stack);
                if (is_cycle) {
                    System.out.println("cycle exisit : " + is_cycle);
                    break;
                }
            }
        }
    }
}
