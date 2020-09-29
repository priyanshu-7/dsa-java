import java.util.*;
class Playground {
    public static void main(String[ ] args) 
    {
        int arr[] = {1, 2, 3, 4, 5};
        rotateOnceRight(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void rotateOnceLeft(int arr[])
    {
        int first = arr[0];
        int i = 0;
        for(i = 1; i<arr.length; i++)
        {
            int temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;
        }
       
        arr[arr.length-1] = first;
    }
    static void rotateOnceRight(int arr[])
    {
        int last = arr[arr.length-1];
        for(int i = arr.length-1; i>0; i--)
        {
            int temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;
        }
        arr[0] = last;
    }
}