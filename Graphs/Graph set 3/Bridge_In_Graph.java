import java.util.ArrayList;

/*
 * Bridge in graph -> Tarjan's Algorithm
 * 
 * for the first diagram in the pic -> vertices = 5
 * O/p -> 2 bridges
 *  bridge is : 3 --- 4
    bridge is : 0 --- 3

 * for the second diagram in the pic -> vertices = 5
 * O/p -> 1 bridges
    bridge is : 0 --- 3
 * 
 */

public class Bridge_In_Graph {

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
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }

    /*
     * all Tarjan's algorithm logic is going to work in dfs where in getBridge is
     * helper function
     */
    public static void depth_first_search(ArrayList<Edge> graph[], int current, boolean visited_array[],
            int discovery_time[], int lowest_discovery_time[], int time, int parent) {
        visited_array[current] = true;
        discovery_time[current] = lowest_discovery_time[current] = ++time;

        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);

            if (e.destination == parent) {
                continue;
            } else if (!visited_array[e.destination]) {
                depth_first_search(graph, e.destination, visited_array, discovery_time, lowest_discovery_time, time,
                        current);
                lowest_discovery_time[current] = Math.min(lowest_discovery_time[current],
                        lowest_discovery_time[e.destination]);
                if (discovery_time[current] < lowest_discovery_time[e.destination]) {
                    System.out.println("bridge is : " + current + " --- " + e.destination);
                }
            } else {
                lowest_discovery_time[current] = Math.min(lowest_discovery_time[current],
                        discovery_time[e.destination]);
            }
        }
    }

    public static void getBridge(ArrayList<Edge> graph[], int vertices) {
        int discovery_time[] = new int[vertices];
        int lowest_discovery_time[] = new int[vertices];
        int time = 0;
        boolean visited_array[] = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            /*
             * at starting we are directly visiting the node and that node dosn't contain
             * any parent so it's parent is -1
             */
            if (!visited_array[i]) {
                depth_first_search(graph, i, visited_array, discovery_time, lowest_discovery_time, time, -1);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        getBridge(graph, vertices);

    }
}
