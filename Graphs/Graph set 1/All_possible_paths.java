import java.util.ArrayList;

/*
 * All paths from source to target :
 * for given source and target ,print all paths that exist from sorce to target
 * source: 0 and target : 5
 * 
 * O/p -> 
 *  0 1 3 4 5 
    0 1 3 5   
    0 2 4 3 5 
    0 2 4 5   

 * Here we are using modified DFS :
 * 
 */

public class All_possible_paths {

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

    public static void depth_first_search(ArrayList<Edge> graph[], int current, boolean visited_array[]) {
        System.out.print(current + " ");
        visited_array[current] = true;

        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if (visited_array[e.destination] == false) {
                depth_first_search(graph, e.destination, visited_array);
            }
        }
    }

    public static void printAllPath(ArrayList<Edge> graph[], boolean visited_array[], int current, String path,
            int target) {
        if (current == target) {
            System.out.println(path);
            return;
        }
        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if (!visited_array[e.destination]) {

                visited_array[current] = true;
                printAllPath(graph, visited_array, e.destination, path + e.destination + " ", target);
                visited_array[current] = false;
            }

        }
    }

    public static void main(String[] args) {
        int vertices = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);

        boolean visited_array[] = new boolean[vertices];
        int source = 0;
        int target = 5;

        System.out.println("These are the All_Possible Paths --->");
        printAllPath(graph, visited_array, source, "0 ", target);

    }
}
