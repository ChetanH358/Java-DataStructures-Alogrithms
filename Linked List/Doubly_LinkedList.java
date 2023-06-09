public class Doubly_LinkedList {
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

    public static void main(String[] args) {
        Doubly_LinkedList dl = new Doubly_LinkedList();
        dl.addFirst("a");
        dl.addFirst("b");
        dl.addFirst("c");
        dl.addFirst("d");
        dl.addLast("z");
        dl.addLast("k");
        dl.addFirst("y");
        dl.PrintList();
        dl.DELETE_First();
        dl.PrintList();
        dl.DELETE_Last();
        dl.PrintList();
        System.out.println("size of the doubly linked list -> " + dl.Getsize());

    }
}
