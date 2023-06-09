/*
 * x=6 & y=10 inclusive
 * x <= root <= y -> search in left and right
 * x>root -> all numbers are found in right side
 * y<root -> all numbers are found in left side
 * 
 */

public class Print_In_Range {
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

    // Traversing the tree i.e Inorder Traversal -> which gives sorted array
    public static void Inorder(Node root) {
        if (root == null) {
            return;
        }
        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }

    public static void Print_Within_Range(Node root, int x, int y) {
        if (root == null) {
            return;
        }
        if (root.data >= x && root.data <= y) {
            Print_Within_Range(root.left, x, y);
            System.out.println(root.data + " ");
            Print_Within_Range(root.right, x, y);
        } else if (root.data >= y) {
            Print_Within_Range(root.left, x, y);
        } else {
            Print_Within_Range(root.right, x, y);
        }
    }

    public static void main(String[] args) {
        int values[] = { 1, 3, 4, 5, 6, 8, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = Insert(root, values[i]);
        }
        Inorder(root);
        System.out.println("\nthese are the numbers lie within range 6-10");
        Print_Within_Range(root, 6, 10);
    }
}
