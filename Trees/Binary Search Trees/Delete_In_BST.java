
public class Delete_In_BST {
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

    public static Node Delete_Node(Node root, int value) {
        if (root.data > value) {
            root.left = Delete_Node(root.left, value);
        } else if (root.data < value) {
            root.right = Delete_Node(root.right, value);
        } else {// root.data = value
            // case 1:
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2:
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.right;
            }
            // case 3
            Node IS = InOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = Delete_Node(root.right, IS.data);
        }
        return root;
    }

    public static Node InOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int values[] = { 1, 3, 4, 5, 6, 8, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = Insert(root, values[i]);
        }
        Inorder(root);
        Delete_Node(root, 1);

        System.out.println();
        Inorder(root);

    }
}
