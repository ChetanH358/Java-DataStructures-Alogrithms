import java.util.HexFormat;

/*
 * Height of a tree ->
 * it is the distance(hight) between root to deepest leaf.
 * level of root from the deepest leaf (4,5,6 -> are the deepset leaf).
 * here hight of the tree is 3.
 * Approach :-
 * 1) first find the hight of left subtree and then find hight of right subtree w.r.t root
 * 2) now for root we have the hight of left subtree and right subtree and max among them + 1
 *    (+1 is the hight of the root itself) gives total hight of the tree
 * 3) replicate this procedure at each and every level
 */

/*
 * Diameter of a tree ->
 * Number of Nodes in the Longest path between any 2 nodes
 * case 1:- Longest path going through the root o/p -> 5 (img)
 * case 2:- Longest path Not passing through the root 
 * 
 * Approach 1 : Time-Complexity is O(n^2)
 * 1) Diamter_1 -> find largest diameter from left subtree
 * 2) Diamter_2 ->find largest diameter form right subtree
 * 3) Diamter_3 ->(find the maximum height of left subtree and find maximum height fo right subtree ) + 1.
 * 
 * Approach 2 : Time-Complexity is O(n) -> linear time-Complexity
 * here we are storing both height and diameter simultaniously for each and every Node in a class called Tree_Info
 * 1) create a class which stores information hight and diameter
 */

public class Hight_and_Diameter_of_Tree {
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

    public static int Hight_Tree(Node root) {
        if (root == null) {
            return 0;
        }
        int LeftHight = Hight_Tree(root.left);
        int RightHight = Hight_Tree(root.right);
        int myHeight = Math.max(LeftHight, RightHight) + 1;

        return myHeight;
    }

    public static int Diameter_Tree_Approach_1(Node root) {
        if (root == null) {
            return 0;
        }
        int diameter_1 = Diameter_Tree_Approach_1(root.left);
        int diameter_2 = Diameter_Tree_Approach_1(root.right);
        int diameter_3 = Hight_Tree(root.left) + Hight_Tree(root.right) + 1;

        return Math.max(diameter_3, Math.max(diameter_1, diameter_2));
    }

    // *********************************************************************************************************************************

    static class Tree_Info {
        int height;
        int diameter;

        Tree_Info(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static Tree_Info Diameter_Tree_Approach_2(Node root) {
        /*
         * we have to return an object of Tree_Info such that the information (hight &
         * diameter gets stored)
         */

        if (root == null) {
            return new Tree_Info(0, 0);
        }

        Tree_Info left = Diameter_Tree_Approach_2(root.left);
        Tree_Info right = Diameter_Tree_Approach_2(root.right);

        int myHeight = Math.max(left.height, right.height) + 1;

        int diameter_1 = left.diameter;
        int diameter_2 = right.diameter;
        int diameter_3 = left.height + right.height + 1;
        int mydiameter = Math.max(diameter_3, Math.max(diameter_1, diameter_2));

        Tree_Info myInfo = new Tree_Info(myHeight, mydiameter);
        return myInfo;
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = Binary_Tree.Build_Tree(nodes);
        System.out.println("The root Node of the tree is : " + root.data);

        System.out.println("Height of the tree is : " + Hight_Tree(root));
        System.out.println("Diameter of the tree By Approach-1 is : " + Diameter_Tree_Approach_1(root));
        System.out.println("Diameter of the tree By Approach-2 is : " + (Diameter_Tree_Approach_2(root).diameter));
    }
}
