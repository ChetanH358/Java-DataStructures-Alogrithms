
/*
 * OPERATIONS :
 * Enque -> add -> we try to add the elements from the rear side
 * Dequeue -> remmove -> we try to remove the elements from front side
 * Front -> peek -> we are trying to check(seeing/conforming) weather element exist in front or not
 */

/*
 * Circular_Queue using Array :
 * 1) here when we add the elements rear will get inceremented and when we delete the element we increment the front as well
 * 2) we notice that first two index number of array are empty , we are making our rear to start pointing to the index 0 and it will
 * continue to add elements until front != rear ---> in this way we achieve cicular queue 
 * 3) IMP formula :- Rear = (Rear + 1) % size
 * 4)cosider size of array = 5 and rear is at index_number 4 according to the formula Rear = (4+1)%5 => Rear = 0; 
 * 5) Rear will start pointing to the index number 0 of the array
 * 
 * it is always a good practice to impelement circular queue using Array
 * add -> time complexity is -> O(1)
 * peek -> time complexity is -> O(1)
 * remove -> time complexity is -> O(1)
 */

public class Circular_Queue_Using_Array {
    int arr[];
    int size;
    int rear = -1;
    int front = -1;

    Circular_Queue_Using_Array(int size) {
        arr = new int[size];
        this.size = size;
    }

    public boolean isEmpty() {
        if (rear == -1 && front == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if ((rear + 1) % size == front) {
            return true;
        } else {
            return false;
        }
    }

    // enqueue
    public void add(int data) {
        if (isFull()) {
            System.out.println("queue is full");
            return;
        }
        // while adding 1-st element making front to zero
        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % size;
        arr[rear] = data;
    }

    // Dequeue
    public int remove() {
        if (isEmpty()) {
            System.out.println("empty queue");
            return -1;
        }
        int result = arr[front];
        // single element condition
        if (rear == front) {
            rear = -1;
            front = -1;
        } else {
            front = (front + 1) % size;
        }
        return result;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("queue is empty");
            return -1;
        }
        return arr[front];
    }

    public static void main(String[] args) {
        Circular_Queue_Using_Array q = new Circular_Queue_Using_Array(5);
        q.add(1); // 6
        q.add(2); // 7
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println("removing : " + q.remove());
        q.add(6);
        System.out.println("removing : " + q.remove());
        q.add(7);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

    }
}
