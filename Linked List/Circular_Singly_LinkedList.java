public class Circular_Singly_LinkedList {
    Node tail; // to track last node of list
    int size;

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // traversing the circular linked list
    public void printList() {
        if (tail == null) {
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

    // inserting element at first
    public void Add_First(String data) {
        Node newnode = new Node(data);
        if (tail == null) {
            tail = newnode;
        } else {
            newnode.next = tail.next;
        }
        tail.next = newnode;
        size++;
    }

    // inserting element at Last
    public void Add_Last(String data) {
        Node newnode = new Node(data);
        if (tail == null) {
            tail = newnode;
            tail.next = tail;
        } else {
            newnode.next = tail.next;
            tail.next = newnode;
            tail = newnode;
        }
        size++;
    }

    // delete element at first
    public void Delete_First() {
        Node currnode = tail.next;
        if (tail.next == tail) {
            tail = null;
        } else {
            tail.next = currnode.next;
        }
        currnode.next = null;
        size--;
    }

    // delete the elemet at last
    public void Delete_Last() {
        if (tail == null) {
            System.out.println("Nothing to delete list is empty");
            return;
        }

        if (tail == tail.next) {
            tail = null;
            size--;
            return;
        }

        Node first = tail.next;
        Node first_next = tail.next.next;
        while (first_next != tail) {
            first = first.next;
            first_next = first_next.next;
        }
        first.next = first_next.next;
        tail = first;
        size--;
    }

    public static void main(String[] args) {
        Circular_Singly_LinkedList csl = new Circular_Singly_LinkedList();
        csl.Add_Last("z");
        csl.Add_Last("y");
        csl.Add_First("b");
        csl.Add_First("c");
        csl.Add_First("d");
        csl.Add_Last("u");
        csl.Add_Last("o");
        csl.printList();
        csl.Delete_Last();
        csl.Delete_Last();
        csl.Delete_Last();
        csl.Delete_Last();
        csl.printList();
        System.out.println("the size of the circula linked list is : " + csl.size);
        csl.Delete_Last();
        csl.printList();
    }
}
