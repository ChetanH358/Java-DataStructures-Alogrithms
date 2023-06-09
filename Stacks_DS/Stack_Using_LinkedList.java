
/*
 * STACK : follow LIFO (Last-In-First-Out)
 * Push -> O(1)
 * Pop -> O(1)
 * Peek -> O(1) ->to find the value of the top in our stack
 */

/*
 * 1) Stack can be implemented using Array -> fixed size -> not fit for use
 * 2) Stack can be implemented using Array-List -> variable list -> whenever
 * array becomes full a new array will get created and all elements get copided
 * into the newly created array
 * 3) Stack can be implemented using Linked-List -> varibele list -> whenever we
 * add elements into the Linked List we make the new node as head (we are moving
 * our head)
 */
public class Stack_Using_LinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    // push() -> operation
    public void push(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // pop() -> opearation
    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int top = head.data;
        head = head.next;
        return top;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return head.data;
    }

    public static void main(String[] args) {
        Stack_Using_LinkedList s = new Stack_Using_LinkedList();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
