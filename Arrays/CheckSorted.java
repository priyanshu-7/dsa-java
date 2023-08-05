import java.util.*;
class HelloWorld {
    /*
    Compare value with the previous one
    */
    static boolean checkSorted(int arr[]) {
        for(int i = 1; i<arr.length; i++) {
            if(arr[i]<arr[i-1]) {
                return false;
            }
        }
        return true;
  }
    public static void main(String[] args) {
       int arr[] = {1,3 , 1, 5};
       System.out.println(checkSorted(arr));
       System.out.println(Arrays.toString(arr));
       
    }
}