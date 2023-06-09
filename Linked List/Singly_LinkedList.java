
public class Singly_LinkedList {
    Node head;
    private int size;

    public int Getsize() {
        return size;
    }

    Singly_LinkedList() {
        this.size = 0;
    }

    public class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
            size++;

        }
    }

    // printing the list
    public void printList() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");

    }

    // adding the element at first
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // adding the element at last
    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    // delete the element at first
    // make 2-nd element from start as head
    public void Delete_First() {
        if (head == null) {
            System.out.println("the list is empty");
            return;
        }
        size--;
        head = head.next;
    }

    // delete the last element
    // traverse upto end and make second last node as null
    public void Delete_Last() {
        if (head == null) {
            System.out.println("the list is empty");
            return;
        }
        size--; // single node is behaving as first as well as last node
        if (head.next == null) {
            /*
             * another corner case : head.next = null -> lastNode=null , but
             * null.next = ?
             */
            head = null;
            return;
        }
        Node secondLast = head;
        Node lastnode = head.next;

        while (lastnode.next != null) {
            lastnode = lastnode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
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

    public Node Reversing_List_Recursively(Node head) {
        // base case -> if we have single element then also return head and
        // base case -> if our head.next becomes null then also return null

        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = Reversing_List_Recursively(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        Singly_LinkedList ll = new Singly_LinkedList();
        ll.addFirst("a");
        ll.addFirst("b");
        ll.addFirst("d");
        ll.addFirst("e");

        // ll.printList();
        // ll.Reversing_List_Iteratively();
        // ll.printList();

        ll.printList();
        // System.out.println(ll.head);
        ll.head = ll.Reversing_List_Recursively(ll.head);
        ll.printList();
        System.out.println(ll.Getsize());

    }
}