/**
 * bubblesort
 */
public class Bubble_sort {

    // moving a largest element at the end is known as bubble sort
    // for each and every iteration there will be swapping exist

    // Time Complexity => O(n^2)

    public static void PrintArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 7, 4, 5, 2 };

        PrintArray(arr);

        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // System.out.println("arr[" + i + "] is " + arr[i] + " and arr[" + j + "] is "
                    // + arr[j]);
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        PrintArray(arr);
    }
}