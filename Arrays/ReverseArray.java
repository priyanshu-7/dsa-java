import java.util.*;
class ReverseArray {
    /*
    Swap first and last values, keep incrementing first and decrementing last while first<last (we reach the mid array)
    */
    static void reverseArray(int arr[]) {
        int i = 0;
        int j = arr.length-1;
        while(i<j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
  }
    public static void main(String[] args) {
       int arr[] = {1, 5, 1, 6};
       reverseArray(arr);
       System.out.println(Arrays.toString(arr));
       
    }
}