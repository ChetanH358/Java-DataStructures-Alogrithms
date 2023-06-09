/**
 * Build_Tree_Preorder
 */

/*
 * 1) Pre-Order Traversal
 * root -> printed first
 * left subtree
 * right subtree
 * 
 * here root comes first so it is a Pre-Order-Traversal
 * Time complexity is O(n)
 */

/*
 * 2) In-Order Traversal
 * left subtree
 * root -> root will be printed after printing all left subtree
 * right subtree
 * 
 * here root comes In-Between so it is a In-Order-Traversal
 * Time complexity is O(n)
 */

/*
 * 3) Post-Order Traversal
 * left subtree
 * right subtree
 * root -> root will be printed after left and right subtree
 * 
 * here root comes last so it is a Post-Order-Traversal
 * Time complexity is O(n)
 */

public class Build_Tree_Preorder {
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

    public static void Pre_Order(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        Pre_Order(root.left);
        Pre_Order(root.right);
    }

    public static void In_Order(Node root) {
        if (root == null) {
            return;
        }
        In_Order(root.left);
        System.out.print(root.data + " ");
        In_Order(root.right);
    }

    public static void Post_Order(Node root) {
        if (root == null) {
            return;
        }
        Post_Order(root.left);
        Post_Order(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = Binary_Tree.Build_Tree(nodes);
        System.out.println("The root Node of the tree is : " + root.data);

        System.out.print("pre-Order Traversal is : ");
        Pre_Order(root);

        System.out.print("\nIn-Order Traversal is : ");
        In_Order(root);

        System.out.print("\nPost-Order Traversal is : ");
        Post_Order(root);
    }
}