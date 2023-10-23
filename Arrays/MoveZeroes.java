import java.util.*;
class MoveZeroes {
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
    //Better way (2023) 
    static void MoveZeroes(int arr[]) {
        int i = 0, j = arr.length-1;
        while(i<=j) {
            if(arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[j] == 0) j--;
            if(arr[i] != 0) i++;
        }
    }
    
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
