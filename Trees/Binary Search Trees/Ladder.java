public class Ladder {
    public static void main(String[] args) {
        int a = 5;
        if (a < 50 && a > 40) {
            System.out.println("if clause is executing");
        } else if (a < 40 && a > 30) {
            System.out.println("execting first else-if clause");
        } else if (a < 30 && a > 20) {
            System.out.println("executing second else-if clause");
        } else {
            System.out.println("element not found");
        }
    }
}
