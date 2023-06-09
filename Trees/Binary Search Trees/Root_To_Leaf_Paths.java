import java.util.ArrayList;

/*
 * all possible paths which starts from root and ends upto leaf nodes
 * 8->5->3
 * 8->5->6
 * 8->10->11->14
 * 
 * Approach :
 * node that we are traversing ,we are adding it into into ArrayList 
 * when we reach leaf node we are going to print the path
 * we delete last but first node from the array list (internally we are stepping back after reaching leaf node)
 * as and how we are backtracking simultaninously removing the elements -> wherever we encounter leaf node we are printing the path
 * 
 * LOGICAL-ALGORITHM :---
 * preorder
 * root(add)
 * left subtree
 * right subtree
 * remove
 */

public class Root_To_Leaf_Paths {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Inserting values into the tree
    public static Node Insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.data) {
            root.left = Insert(root.left, value);
        } else {
            root.right = Insert(root.right, value);
        }
        return root;
    }

    // traversal of tree
    public static void Inorder(Node root) {
        if (root == null) {
            return;
        }
        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }

    public static void Print_To_Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);

        // leaf
        if (root.left == null && root.right == null) {
            PrintPath(path);
        } else { // non-leaf
            Print_To_Leaf(root.left, path);
            Print_To_Leaf(root.right, path);
        }
        path.remove(path.size() - 1);
    }

    public static void PrintPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " -> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int values[] = { 1, 3, 4, 5, 6, 8, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = Insert(root, values[i]);
        }
        Inorder(root);
        System.out.println();
        Print_To_Leaf(root, new ArrayList<>());
    }
}
