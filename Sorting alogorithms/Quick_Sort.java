public class Quick_Sort {
    // Worst Case Time Complexity => O(n^2).
    // Average Case Time Complexity => O(nlogn).
    // No extra space is takenup for sorting -> in quick sort we can sort the array
    // in less space complexity.

    public static void PrintArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i] + " ");
        }
        System.out.println();
    }

    public static int partation(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1; // i=-1 will also going to work

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap with pivot
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }

    public static void QuickSort(int arr[], int low, int high) {
        PrintArray(arr);
        System.out.println("checking the condition low<high");
        if (low < high) {
            System.out.println(" true making partation ");
            int pivot_index = partation(arr, low, high);
            System.out.println("index number returned :" + pivot_index);

            System.out.println("calling quick sort recursively from  { low --> pivot_index-1 } ");
            System.out.println("[ low : " + low + " and high :" + (pivot_index - 1) + "]");
            QuickSort(arr, low, pivot_index - 1);

            System.out.println("calling quick sort recursively { pivot_index + 1 --> high } ");
            System.out.println("[ low : " + (pivot_index + 1) + " and high :" + high + "]");
            QuickSort(arr, pivot_index + 1, high);

        } else {
            System.out.println("false partation terminated");
        }
    }

    public static void main(String[] args) {
        // int[] arr = { 3, 2, 5, 4, 6, 9, 7, 1 };
        int[] arr = { 23, 12, 5, 16, 89, 7 };
        int n = arr.length;// 6
        // PrintArray(arr);
        System.out.println("\n\nfrom main() 1-st function call to quicksort");
        QuickSort(arr, 0, n - 1);
        System.out.println("last function call before printing final sorted array");
        System.out.println();
        PrintArray(arr);

    }

    /*
     * It is divide and concqure technique
     * 
     * 1) in main meathod pass array,low : i.e 1-st index of array, high:last index
     * of array to quick sort funcion
     * 
     * 2) partation () -> will divide the array
     * 2.1) working of partation function ->
     * 2.1.1) storing the last index(element) into pivot
     * 2.1.2) initilizing i ,which inturn create's a space to swap elements
     * 2.1.3) running a for loop from low to high , if in case any number lesser
     * than pivot , swap those
     * 2.1.4) after for loop we will increment i , and create a space where we are
     * going to place pivot element and return the index number of pivot element to
     * pivot_index
     * 2.1.5) if (low<high) is the base condition to stop the recursion
     * 
     */
    /*
     * 
     * 
     * 
     * BELOW IS THE TRACING OF ABOVE PROGRAMME BY PRINTING STATEMENTS
     *
     * 
     * 
     */

    // public static void QuickSort(int arr[], int low, int high) {
    // PrintArray(arr);
    // System.out.println("checking the condition low<high");
    // if (low < high) {
    // System.out.println(" true making partation ");
    // int pivot_index = partation(arr, low, high);
    // System.out.println("index number returned :" + pivot_index);

    // System.out.println("calling quick sort recursively from { low -->
    // pivot_index-1 } ");
    // System.out.println("[ low : " + low + " and high :" + (pivot_index - 1) +
    // "]");
    // QuickSort(arr, low, pivot_index - 1);

    // System.out.println("calling quick sort recursively { pivot_index + 1 --> high
    // } ");
    // System.out.println("[ low : " + (pivot_index + 1) + " and high :" + high +
    // "]");
    // QuickSort(arr, pivot_index + 1, high);

    // } else {
    // System.out.println("false partation terminated");
    // }
    // }

    // public static void main(String[] args) {
    // // int[] arr = { 3, 2, 5, 4, 6, 9, 7, 1 };
    // int[] arr = { 23, 12, 5, 16, 89, 7 };
    // int n = arr.length;// 6
    // // PrintArray(arr);
    // System.out.println("\n\nfrom main() 1-st function call to quicksort");
    // QuickSort(arr, 0, n - 1);
    // System.out.println("last function call before printing final sorted array");
    // System.out.println();
    // PrintArray(arr);

    // }

}
