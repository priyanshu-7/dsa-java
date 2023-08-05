import java.util.*;
class HelloWorld {
    /*
    Count number of non zero elements, whenever non zero element 
    is found, swap it with the element at arr[count]
    [1, 0, 3, 0, 4, 0, 5] 
    i = 0, swap(arr[i], arr[count]), count = 1
    [1, 0, 3, 0, 4, 0, 5]
    i = 1
    [1, 0, 3, 0, 4, 0, 5]
    i = 2, swap(arr[i], arr[count]), count = 1
    ...
    */
    static void moveZeroes(int arr[]) {
    int countOfNonZero = 0;
    for(int i = 0; i<arr.length; i++) {
        if(arr[i]!=0) {
            int temp = arr[i];
            arr[i] = arr[countOfNonZero];
            arr[countOfNonZero] = temp;
            countOfNonZero++;
        }
    }
  }
    public static void main(String[] args) {
       int arr[] = {1, 0, 3, 0, 4, 0, 5};
       moveZeroes(arr);
       System.out.println(Arrays.toString(arr));
    }
}