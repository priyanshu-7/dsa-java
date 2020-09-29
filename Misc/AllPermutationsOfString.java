import java.util.*;
class Playground {
    static void permutation(char arr[], int l, int r)
    {
        //https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
        if(l == r)
        {
            System.out.println(Arrays.toString(arr));
        }
        for(int i = l; i<r; i++)
        {
            //Swap L with every character
            char ch = arr[l];
            arr[l] = arr[i];
            arr[i] = ch;
            
            //Call for l+1th char
            permutation(arr, l+1, arr.length);
            
            //Backtrack (Revert string to its original form)
            ch = arr[l];
            arr[l] = arr[i];
            arr[i] = ch;
        }
    }
    public static void main(String[ ] args) 
    {
        String s = "ABC";
        permutation(s.toCharArray(), 0, s.length());
    }
}