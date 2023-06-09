import java.util.ArrayList;

/*
 * 
 */

public class Articulation_Point {

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

        graph[4].add(new Edge(4, 3));
    }

    // graph[] , curr , par , dt[] , low[] , vis[] , time , boolean ap[]
    public static void depth_first_search(ArrayList<Edge> graph[], int current, boolean visited_array[],
            int discovery_time[], int lowest_discovery_time[], int time, int parent, boolean Articulation_Point[]) {

        visited_array[current] = true;
        discovery_time[current] = lowest_discovery_time[current] = ++time;
        int children = 0;

        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            int neighbour = e.destination;

            if (parent == neighbour) {
                continue;
            } else if (visited_array[e.destination]) {
                lowest_discovery_time[current] = Math.min(lowest_discovery_time[current],
                        lowest_discovery_time[e.destination]);
            } else {
                depth_first_search(graph, neighbour, visited_array, discovery_time, lowest_discovery_time, time,
                        current, Articulation_Point);
                lowest_discovery_time[current] = Math.min(lowest_discovery_time[current],
                        discovery_time[neighbour]);
                if (discovery_time[current] <= lowest_discovery_time[neighbour] && parent != -1) {
                    Articulation_Point[current] = true;
                }
                children++;
            }
        }

        // corner case of DFS i.e starting condition
        if (parent == -1 && children > 1) {
            Articulation_Point[current] = true;
        }
    }

    public static void getArticulation_Point(ArrayList<Edge> graph[], int vertices) {
        int discovery_time[] = new int[vertices];
        int lowest_discovery_time[] = new int[vertices];
        int time = 0;
        boolean visited_array[] = new boolean[vertices];
        boolean Articulation_Point[] = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited_array[i]) {
                depth_first_search(graph, i, visited_array, discovery_time, lowest_discovery_time, time, -1,
                        Articulation_Point);
            }
        }
        for (int i = 0; i < vertices; i++) {
            if (Articulation_Point[i]) {
                System.out.println("AP : " + i + " " + Articulation_Point[i]);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        createGraph(graph);
        getArticulation_Point(graph, vertices);
    }
}
