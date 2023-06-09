
/*
 * OPERATIONS :
 * Enque -> add -> we try to add the elements from the rear side
 * Dequeue -> remmove -> we try to remove the elements from front side
 * Front -> peek -> we are trying to check(seeing/conforming) weather element exist in front or not
 */

/*
 * Queue_Using_Linked_List :
 * 1) here elements are added from tail side and removed from head side
 * 
 * add -> time complexity is -> O(1)
 * peek -> time complexity is -> O(1)
 * remove -> time complexity is -> O(1)
 */

public class Queue_Using_LinkedList {

    Node head;
    Node tail;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        if (head == null && tail == null) {
            return true;
        } else {
            return false;
        }
    }

    // isFull -> In this case memory space is more so list does not become full

    // enqueue -> adding the element
    public void add(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            head = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // Dequeue -> removing the elements
    public int remove() {
        if (isEmpty()) {
            System.out.println("empty queue");
            return -1;
        }
        int front = head.data;
        if (head == tail) {
            tail = null;
            head = null;
            return front;
        }
        head = head.next;
        return front;

    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("queue is empty");
            return -1;
        }
        return head.data;
    }

    public static void main(String[] args) {
        Queue_Using_LinkedList q = new Queue_Using_LinkedList();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.remove();
        q.remove();

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
