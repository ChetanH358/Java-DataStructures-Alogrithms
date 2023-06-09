
public class Return_Sorted_Array {

    public static int[] sort_array(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 5, 2, 1, 9 };
        int[] res = sort_array(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(" " + res[i]);
        }
    }

}
