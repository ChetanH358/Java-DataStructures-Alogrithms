
/**
 * Build_BST Insertion time complexity is O(H) , where H ->Height of tree
 * Build_BST Search time complexity is O(H) , where H ->Height of tree
 */
public class Build_BST {
    // creating structure of Node of a tree
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

    // searching a value in BST
    public static boolean Search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (key < root.data) {
            return Search(root.left, key);
        } else if (root.data == key) {
            return true;
        } else {
            return Search(root.right, key);
        }
    }

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = Insert(root, values[i]);
        }

        Inorder(root);
        System.out.println();

        if (Search(root, 7)) {
            System.out.println("found");
        } else {
            System.out.println("Not found");
        }
    }
}