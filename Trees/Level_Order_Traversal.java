import java.util.LinkedList;
import java.util.Queue;

/*
 * In level Order Traversal we print the Node level wise.
 * Approcach -> Use of Iteration and Queue Data-Structure.
 * Time complexity is linear -> O(n)
 * 1) insert root node value into Queue
 * 2) remove that value and print it
 * 3) before removing store it's left and right node values into queue
 * o/p :---
 * 1
 * 2 3 
 * 4 5 6
 */

/*
 * 1) Depth-First-Search ->
 * going deep upto the leaf(null) {all 3 modes of traversal}
 * i.e Pre-Order, Post-Order, In-Order
 * 
 * 2) Breadth-First-Search ->
 * going level wise i.e level order traversal
 * 
 * DFS & BFS are important in graphs
 */
public class Level_Order_Traversal {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Binary_Tree {
        static int index = -1;

        public static Node Build_Tree(int nodes[]) {
            index++;
            if (nodes[index] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = Build_Tree(nodes);
            newNode.right = Build_Tree(nodes);

            return newNode;

        }
    }

    public static void Level_Order(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = Binary_Tree.Build_Tree(nodes);
        System.out.println("The root Node of the tree is : " + root.data);
        Level_Order(root);

    }
}
