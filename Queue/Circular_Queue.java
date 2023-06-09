/*
 * Circular_Queue
 */

/*
 * createQueue(int size)
 * enqueue(int element)
 * dequeue()
 * size()
 * display()
 * clear()
 * isEmpty()
 * isFull()
 * contains()
 */
public class Circular_Queue {
    static int[] arr;
    static int size;
    static int front;
    static int rear;

    public static void display() {
        if (front == rear) {
            System.out.println("queue is empty");
        }
        for (int i = 0; i < rear; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    public static void createQueue(int size) {
        arr = new int[size];
        front = 0;
        rear = 0;
        System.out.println("queue created");
    }

    public static void enqueue(int element) {
        if (size >= arr.length) {
            System.out.println("queue is full");
        } else {
            arr[rear] = element;
            rear++;
            size++;
            System.out.println(element + " is successfully added");
        }
    }

    public static int dequeue() {
        if (front == rear) {
            System.out.println("queue is empty");
            return -1;
        } else {
            int ele = arr[0];
            for (int i = 0; i < rear - 1; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            size--;
            arr[rear] = 0;
            return ele;
        }
    }

    public static boolean isEmpty() {
        if (rear == front) {
            return true;
        }
        return false;
    }

    public static boolean isFull() {
        if (rear == arr.length) {
            return true;
        }
        return false;
    }

    public static boolean contains(int key) {
        for (int i = 0; i < rear; i++) {
            if (key == arr[i]) {
                return true;
            }
        }
        return false;
    }

    public static void clear() {
        rear = 0;
        size = 0;
    }

    public static void main(String[] args) {
        // menu driven programme on Queue
        createQueue(4);
        enqueue(25);
        enqueue(35);
        enqueue(45);
        enqueue(65);
        display();
        System.out.println(dequeue());
        display();
        // System.out.println(dequeue());
        // System.out.println(dequeue());
        // System.out.println(dequeue());
        // display();
        // System.out.println(dequeue());
        // display();
        // enqueue(100);
        // enqueue(150);
        // enqueue(200);
    }
}