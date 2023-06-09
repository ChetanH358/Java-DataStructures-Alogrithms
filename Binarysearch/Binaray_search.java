import java.util.Scanner;

/*
 * Binary search using Recurssion
 * IMP: To Apply Binary Search The Array must be sorted
 */

public class Binaray_search {
    static void binary_search(int[] arr, int low, int high, int key) {
        int mid = (low + high) / 2;

        if (key == arr[mid]) {
            System.out.println("the index number is :" + mid);
            return;
        } else if (key < arr[mid]) {
            binary_search(arr, low, (mid - 1), key);
        } else if (key > arr[mid]) {
            binary_search(arr, (mid + 1), high, key);
        }
        // base condition of the recurssion
        if (low >= high) {
            System.out.println("element not found");
            return;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = { 2, 4, 6, 8, 14, 18, 23, 25, 28, 30, 45, 56, 68, 85, 90 };
        int low = 0;
        int high = arr.length - 1;
        System.out.println("enter the key : ");
        int key = sc.nextInt();
        binary_search(arr, low, high, key);
    }
}
