import java.util.ArrayList;

/*
 * Adjcancy List by -> List of Lists
 * 
 * why Adjacency List is Optimized way ?
 * the number of neighboures with respect to nodes , if we have
 * x neighbours we get O(x) time
 * No Extra space is used and time is also reduced
 * as in graphs we are finding neighbour's every time so it should be optimized
 * 
 */
public class Adjacency_list_1 {
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

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
    }

    public static void main(String[] args) {
        int vertex = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[vertex];
        /*
         * At present the array list is null so we cannot able to store data directly so
         * we need to make arraylist empty at each index then only we able to add list
         * of elements into the array/specified index
         */

        createGraph(graph);
        // print 2's neighbours
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.print(e.destination + " ");
        }

    }

}