
/*
 * Time Complexity of Count of Nodes is -> O(n)
 * Because we have visited each node once so if we have n-> nodes then we have to visit n-times
 */

/*
 * Time Complexity of Sum of Nodes is -> O(n)
 */

public class Count_and_Sum_of_Nodes {
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

    static int Count_of_Nodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = Count_of_Nodes(root.left);
        int rightNodes = Count_of_Nodes(root.right);

        return leftNodes + rightNodes + 1;
    }

    static int Sum_of_Nodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = Sum_of_Nodes(root.left);
        int rightSum = Sum_of_Nodes(root.right);

        return leftSum + rightSum + root.data;
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = Binary_Tree.Build_Tree(nodes);
        System.out.println("The root Node of the tree is : " + root.data);

        System.out.println("count of nodes in Tree : " + Count_of_Nodes(root));
        System.out.println("Sum of nodes in Tree : " + Sum_of_Nodes(root));

    }
}
