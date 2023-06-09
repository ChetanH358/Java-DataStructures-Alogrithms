import java.util.Scanner;

public class Stack_using_menu_driven {

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
            System.out.println("stack is underflow");
            return false;
        } else {
            return true;
        }
    }

    static boolean isFull() {
        if (top >= (stack.length - 1)) {
            System.out.println("stack overflow (can't add element)");
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
        Scanner sc = new Scanner(System.in);
        System.out.println("1.create stack\n2.push\n3.pop\n4.display\n5.isEmpty\n6.isFull\n7.clear\n8.exit");
        System.out.println("enter the size of the stack");
        System.out.println("enter your operantions");
        int op = sc.nextInt();
        switch (op) {
            case 1: {

            }
                break;
            case 2: {

            }
                break;

            case 3: {
                int ans = pop();
                if (ans != -1) {
                    System.out.println(ans + " got deleted");
                }

            }
                break;
            case 4: {
                display();
            }
                break;
            case 5: {
                System.out.println(isEmpty());
            }
                break;
            case 6: {
                System.out.println(isFull());
            }
                break;
            case 7: {
                clear();
                System.out.println("cleard");
            }
                break;
            case 8: {
                System.out.println("thank you visit again");
                System.exit(0);
            }
                break;
            default: {
                System.out.println("invalid option");
            }
        }
    }

}
