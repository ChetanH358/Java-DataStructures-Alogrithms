
/*
 * OPERATIONS :
 * Enque -> add -> we try to add the elements from the rear side
 * Dequeue -> remmove -> we try to remove the elements from front side
 * Front -> peek -> we are trying to check(seeing/conforming) weather element exist in front or not
 */

/*
 * Queue using Array :
 * array has fixed size so we cannot add next element if queue is full
 * add -> time complexity is -> O(1)
 * peek -> time complexity is -> O(n)
 * remove -> time complexity is -> O(n)
 */

public class Queue_Using_Array {
    int arr[];
    int size;
    int rear = -1;
    // front always will be zero at zero if we implement using Array

    Queue_Using_Array(int size) {
        arr = new int[size];
        this.size = size;
    }

    public boolean isEmpty() {
        if (rear == -1) {
            return true;
        } else {
            return false;
        }
    }

    // enqueue
    public void add(int data) {
        if (rear == size - 1) {
            System.out.println("queue is full");
        }
        rear++;
        arr[rear] = data;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("empty queue");
            return -1;
        }
        int front = arr[0];
        // shifting the elemnets after removing the element from the front
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        rear--;
        return front;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("queue is empty");
            return -1;
        }
        return arr[0];
    }

    public static void main(String[] args) {
        Queue_Using_Array q = new Queue_Using_Array(5);
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
