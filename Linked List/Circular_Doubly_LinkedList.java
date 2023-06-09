public class Circular_Doubly_LinkedList {
    Node head;
    Node tail;
    int size;

    class Node {
        Node previous;
        String data;
        Node next;

        Node(String data) {
            this.previous = null;
            this.data = data;
            this.next = null;
        }
    }

    // printing the doubly circular linkedlist
    public void printList() {
        if (tail == null && head == null) {
            System.out.println("Nothing to print list is empty");
            return;
        }
        Node currNode = tail.next;
        while (currNode != tail) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.print(currNode.data);
        System.out.println();
    }

    // add element at first
    public void Add_First(String data) {
        Node newnode = new Node(data);
        if (head == null && tail == null) {
            // if the head and tail is null then, make head and tail point to the newnode
            head = newnode;
            tail = newnode;
            tail.next = newnode;
            tail.previous = newnode;
            size++;
            return;
        }
        newnode.previous = head.previous;
        newnode.next = head;
        head.previous = newnode;
        tail.next = newnode;
        head = newnode;
        size++;
    }

    // add element at last
    public void Add_Last(String data) {
        Node newnode = new Node(data);
        if (head == null && tail == null) {
            // if the head and tail is null then, make head and tail point to the newnode
            head = newnode;
            tail = newnode;
            tail.next = newnode;
            tail.previous = newnode;
            size++;
            return;
        }
        newnode.previous = tail;
        newnode.next = tail.next;
        tail.next = newnode;
        head.previous = newnode;
        tail = newnode;
        size++;
    }

    // delete element at first
    public void Delete_First() {
        if (head == null && tail == null) {
            System.out.println("the list is empty");
            return;
        }
        head = head.next;
        head.previous = tail;
        tail.next = head;
        size--;
    }

    // delete element at last
    public void Delete_Last() {
        if (head == null && tail == null) {
            System.out.println("the list is empty");
            return;
        }
        tail = tail.previous;
        tail.next = head;
        head.previous = tail;
        size--;
    }

    public static void main(String[] args) {
        Circular_Doubly_LinkedList cdl = new Circular_Doubly_LinkedList();
        cdl.Add_First("a");
        cdl.Add_First("b");
        cdl.Add_First("c");
        cdl.Add_First("d");
        cdl.Add_First("e");
        cdl.printList();
        cdl.Add_Last("g");
        cdl.Add_Last("h");
        cdl.Add_Last("i");
        cdl.printList();
        cdl.Delete_First();
        cdl.Delete_First();
        cdl.printList();
        cdl.Delete_Last();
        cdl.printList();
        System.out.println(cdl.size);
        System.out.println("enter your name");
    }

}
