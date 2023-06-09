public class Merge_Sort {

    // Worst Case Time complexity is => O(nlogn)
    // Average Case Time complexity is => O(nlogn)

    public static void PrintArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    public static void conquer(int[] arr, int si, int mid, int ei) {
        int[] merged = new int[ei - si + 1]; // creating a new array to store the sorted elemets
        int idx1 = si;// tracking the 1-st array (index_1)
        int idx2 = mid + 1;// tracking the 2-nd array (index_2)
        int x = 0;// x is tracking merged array index

        /*
         * checking if the first element of the 1-st(idx1) array is less than 2-nd(idx2)
         * or not.
         * if it is true -> put idx1 element into the merged array.
         * else -> put idx2 element into the merged array.
         */

        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++]; // 0
            } else {
                merged[x++] = arr[idx2++];
            }
        }

        // to place the reamining elements leftout in idx1 array
        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }

        // to place the reamining elements leftout in idx2 array
        while (idx2 <= ei) {
            merged[x++] = arr[idx2++];
        }

        // copying the merged array elements into the original array i.e arr[]
        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    public static void divide(int arr[], int si, int ei) {
        if (si >= ei) {
            System.out.println("condition true so return si >= ei " + si + " >= " + ei);
            /*
             * if starting index becomes greater than ending index which means either we
             * are
             * completly divided the array or arrived at the last element of the array.~
             */
            return;
        }
        System.out.print("si:" + si + " ei:" + ei + " ");
        int mid = si + (ei - si) / 2;
        System.out.println("mid: " + mid);
        divide(arr, si, mid);
        System.err.println("executing low = mid+1 : " + (mid + 1) + " to ei : " + ei);
        divide(arr, mid + 1, ei);
        System.err.println("executing conquer() [ si:" + si + " mid: " + mid + " ei:" + ei + " ]");
        conquer(arr, si, mid, ei);
    }

    public static void main(String[] args) {
        // int[] arr = { 6, 3, 9, 5, 2, 8 };
        int[] arr = { 96, 23, 79, 15, 2, 58 };
        int n = arr.length;// 6
        PrintArray(arr);
        System.out.println();
        System.out.println("main function call to divide()");
        divide(arr, 0, n - 1);
        System.out.println();
        PrintArray(arr);
    }

    /*
     * 
     * Alogorithm Explanation :
     * 
     * si ---> starting index
     * ei ---> ending index
     * mid ---> middle index
     * [6,3,9,5,2,8]
     * DIVIDE AND CONCQURE TECHNIQUE ->
     * At the time of concquering we are going to sort the array.
     * taking the mid of the index numbers.
     * Base case is such a condition where we unable to divide the array further
     * when we are coming back from the base case of recursion at that time we are
     * sorting.
     * we are creating a new array called as (merged array) where we are sorting and
     * putting the elements into it and when we done with sorting we will copy
     * (merged array) elements into Original array.
     * divide() ---> time complexity is O(logn).
     * concqure() ---> time complexity is O(n) <--- because all 3 while-loop has
     * complexity is O(n)
     * imp : as soon as we are dividing the array we are concquring it so
     * (n x logn).
     * 
     * [6,3,9,5,2,8] <- consider this array
     * 1) at first divide will apply for [6,3,9] then [6,3] here comes our base case
     * so
     * it simply return's back then divide() apply for mid+1 to ei there also it
     * simply return's and finally concqure method will execute.
     * 2) in first step we concqure half of the array [6,3,9] then mid+1 applies and
     * brings the next half of the sorted array
     * 3) finally concqure meathod will apply for both arrays and respective while
     * loop's get executed and finally we get a sorted array [ 2 3 5 6 8 9]
     * 
     * 
     * 
     * TRACING PART OF DIVIDE() ONLY :----
     * 
     * 
     * 
     */
    // public static void divide(int arr[], int si, int ei) {
    // if (si >= ei) {
    // System.out.println("condition true so return si >= ei " + si + " >= " + ei);
    // /*
    // * if starting index becomes greater than ending index which means either we
    // * are
    // * completly divided the array or arrived at the last element of the array.~
    // */
    // return;
    // }
    // System.out.print("si:" + si + " ei:" + ei + " ");
    // int mid = si + (ei - si) / 2;
    // System.out.println("mid: " + mid);
    // divide(arr, si, mid);
    // System.err.println("executing low = mid+1 : " + (mid + 1) + " to ei : " +
    // ei);
    // divide(arr, mid + 1, ei);
    // System.err.println("executing conquer() [ si:" + si + " mid: " + mid + " ei:"
    // + ei + " ]");
    // conquer(arr, si, mid, ei);
    // }
}
