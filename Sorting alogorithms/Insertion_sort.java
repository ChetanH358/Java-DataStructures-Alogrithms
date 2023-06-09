public class Insertion_sort {
    /*
     * divide array into two parts mainly sorted array and unsorted array
     * select an element from unsorted array and palce in suitable postion of sorted
     * array
     * 7 | 8 3 1 2 (sorted|unsorted)
     * 
     * 7 8 |3 1 2 (sorted|unsorted)
     * 
     * 7 8 8 1 2
     * 7 7 8 1 2
     * 3 7 8 |1 2 (sorted|unsorted)
     * 
     * 3 7 8 |1 2
     * 3 7 8 8 2
     * 3 7 7 8 2
     * 3 3 7 8 2
     * 1 3 7 8| 2 (sorted|unsorted)
     * 
     * 1 3 7 8| 2
     * 1 3 7 8 8
     * 1 3 7 7 8
     * 1 3 3 7 8
     * 1 2 3 7 8 | (sorted)
     * 
     */

    // Time Complexity => O(n^2)

    public static void PrintArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 7, 8, 3, 1, 2 };
        PrintArray(arr);
        System.out.println();

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];// 3
            int j = i - 1;// 1 & 0
            if (j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
        PrintArray(arr);
    }

}
