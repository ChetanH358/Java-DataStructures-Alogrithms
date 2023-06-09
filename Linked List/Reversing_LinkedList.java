
/*Constraints to solve this problem
 * space complexity -> O(1) -> which means no extra memory 
 * time complexity -> O(n) -> we can have time complexity of n
  */

/*
 * solving this problem by using iterative approach 
 * three pointers -> previous , next , currentnode
 * 
 */
public class Reversing_LinkedList {
    Node head;
    Node tail;
    private int size;

    public int Getsize() {
        return size;
    }

    class Node {
        Node previous;
        String data;
        Node next;

        Node(String data) {
            this.previous = null;
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // printing the doubly linked list
    public void PrintList() {
        if (head == null) {
            System.out.println("the list is empty");
            return;
        }
        Node currnode = head;
        System.out.print("null <- ");
        while (currnode != null) {
            System.out.print(currnode.data + " -> ");
            currnode = currnode.next;
        }
        System.out.println("null");
    }

    // Add element at first
    public void addFirst(String data) {
        Node newnode = new Node(data);
        if (head == null) {
            // if the head is null then, make the newnode as head
            head = newnode;
            tail = head;
            return;
        }
        head.previous = newnode;
        newnode.next = head;
        head = newnode;
    }

    // Add element at last
    public void addLast(String data) {
        Node newnode = new Node(data);
        if (tail == null) {
            // if the head is null then, make the newnode as head
            head = newnode;
            tail = head;
            return;
        }
        tail.next = newnode;
        newnode.previous = tail;
        tail = newnode;

    }

    // delete the element at first
    public void DELETE_First() {
        if (head == null) {
            System.out.println("the list is empty");
            return;
        }
        size--;
        head = head.next;

    }

    // delete the element at last
    public void DELETE_Last() {
        if (tail == null) {
            System.out.println("the list is empty");
            return;
        }
        if (tail.next == null && tail.previous == null) {
            head = null;
            tail = null;
            return;
        }
        size--;
        tail = tail.previous;
        tail.next = null;
    }

    public Node Reversing_List_Recursively(Node head) {
        // base case -> if we have single element then also return head and
        // -> if our head.next becomes null then also return null
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = Reversing_List_Recursively(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public void Reversing_List_Iteratively() {
        if (head == null || head.next == null) {
            /*
             * if we have single element in the list then head=null then no need to reverse
             * -> head.next i.e null.next will give an exception
             */
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;
        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            // update
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }

    public static void main(String[] args) {
        Reversing_LinkedList rl = new Reversing_LinkedList();
        rl.addFirst("a");
        rl.addFirst("b");
        rl.addFirst("c");
        rl.addFirst("d");
        rl.addLast("z");
        rl.addLast("k");

        rl.PrintList();
        rl.head = rl.Reversing_List_Recursively(rl.head);
        rl.PrintList();

        // rl.PrintList();
        // rl.Reversing_List_Iteratively();
        // rl.PrintList();

        System.out.println("size of the doubly linked list -> " + rl.Getsize());

    }
}
