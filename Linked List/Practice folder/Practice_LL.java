
public class Practice_LL {
    Node head; // ref1 ,

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // insert at first
    public void Add_First(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head; // ref1
        head = newNode;
    }

    // insert at last
    public void Add_Last(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;// z
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;

    }

    // printing the list
    public void Print_LL() {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        Node currnode = head;
        while (currnode != null) {
            System.out.print(currnode.data + " -> ");
            currnode = currnode.next;
        }
        System.out.println("null");

    }

    public static void main(String[] args) {
        Practice_LL ll = new Practice_LL();
        ll.Add_First("a");
        ll.Add_First("b");
        ll.Add_First("c");
        ll.Add_Last("z");
        ll.Print_LL();

    }
}
