public class Selection_sort {
    /*
     * one swap for one iteration i.e smallest element is arragened first
     * in between if we get any smallest element then we are going to make it as
     * first smallest element
     * unnecessery swaping is avoided in selection sort where as in bubble sort
     * mutiple swapping exist
     */

    // Time Complexity => O(n^2)

    public static void PrintArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 7, 8, 3, 1, 2 };

        // selection sort logic
        PrintArray(arr);
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            int smallest = i; // storing index number of smallest elements
            // System.out.println("for index number " + i + " smallest element is --> " +
            // arr[i]);

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[smallest]) {
                    smallest = j;
                    // System.out.println("in 2-nd for loop reinitilizing smallest " +
                    // arr[smallest]);
                }
            }
            // System.out.println("swapping " + arr[smallest] + " with arr[" + i + "] -> " +
            // arr[i]);
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
        PrintArray(arr);

        /*
         * 
         * 
         * 
         * 
         * do not follow the below approach
         * 
         * 
         * 
         * 
         */

        // for (int i = 0; i < arr.length; i++) {
        // System.out.println("the smallest is " + arr[i]);
        // int smallest = arr[i]; // storing index number of smallest elements
        // for (int j = i + 1; j < arr.length; j++) {
        // if (arr[j] < smallest) {
        // // System.out.println("making " + arr[j] + " as smallest element ");
        // smallest = arr[j];
        // System.out.println("in 2-nd for loop reinitilizing smallest " + smallest);
        // }
        // }
        // System.out.println("swapping " + smallest + " with arr[" + i + "] -> " +
        // arr[i]);
        // int temp = smallest;
        // smallest = arr[i];
        // arr[i] = temp;
        // }

    }
}
