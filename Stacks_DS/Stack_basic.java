public class Stack_basic {

    static int[] stack;
    static int top;

    static void display() {
        if (top == -1) {
            System.out.println("Nothing to print stack is empty");
        } else {
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();

        }
    }

    static boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isFull() {
        if (top >= (stack.length - 1)) {
            return false;
        } else {
            return true;
        }
    }

    static void CreateStack(int size) {
        stack = new int[size];
        top = -1;
        System.out.println("stack successfully created with size : " + size);

    }

    static void push(int ele) {
        if (isFull()) {
            top++;
            stack[top] = ele;
            System.out.println(ele + " has been successfully added");
        } else {
            System.out.println("stack is overflow (stack already full can't add element)");
        }
    }

    static int pop() {
        int element = -1;
        if (isEmpty()) {
            System.out.println("stack underflow (Nothing to remove)");
        } else {
            element = stack[top];
            stack[top] = 0;
            System.out.println(element + " has been successfully deleted");
            top--;
        }
        return element;
    }

    static void clear() {
        for (int i = top; i >= 0; i++) {
            stack[i] = 0;
        }
        top = -1;
    }

    // check if the element is present in stack or not
    static boolean contains(int ele) {
        for (int i = top; i >= 0; i++) {
            if (stack[i] == ele) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // implement stack using switch and Scanner
        // Menu driven function's
        CreateStack(4);
        push(5);
        push(6);
        push(8);
        push(9);
        push(1);
        push(89);
        display();
        pop();
        pop();
        pop();
        pop();
        display();
        pop();
        pop();
        display();

    }
}