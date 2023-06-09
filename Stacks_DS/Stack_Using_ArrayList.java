
import java.util.*;

public class Stack_Using_ArrayList {
    ArrayList<Integer> list = new ArrayList<Integer>();

    public boolean isEmpty() {
        if (list.size() == 0) {
            return true;
        }
        return false;
    }

    // push()
    public void push(int data) {
        list.add(data);
    }

    // pop()
    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int top = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return top;
    }

    // peek()
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        Stack_Using_ArrayList s = new Stack_Using_ArrayList();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(5);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
