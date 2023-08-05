import java.util.*;
class HelloWorld {
    static int secondLargest(int arr[]) {
        //Idea is to keep a track of both largest and 2nd largest
        int largest = 0, res = -1;
        for(int i = 1; i<arr.length; i++) {
            //In case if arr[i] == arr[largest], do nothing
            if(arr[i] > arr[largest]) {
                res = largest; //the largest value is now the 2nd largest
                largest = i;
            }
            if(arr[i] < arr[largest]) {
                //If we don't have a 2nd largest value yet
                if(res == -1) {
                    res = i;
                }
                //If this value is larger than the current 2nd largest
                if(arr[i] > arr[res]) {
                    res = i;
                }
            }
        }
        return res;
  }
    public static void main(String[] args) {
       int arr[] = {1, 1};
       System.out.println(secondLargest(arr));
       
    }
}