//Best way to handle arrays with 2 elements (eg - segregate binary array/segrate array with evens and odds)
/*
Logic:
if arr[i] = 1 then swap with arr[j]
now if arr[i] = 0, i++ (this element is processed)
and if arr[j] = 1, j-- (this element is processed)
*/

        int arr[] = {1, 0, 1, 0, 0, 0, 1, 0, 1, 0};
        int i = 0, j = arr.length-1;
        while(i<=j) {
            if(arr[i] == 1) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[j] == 1) j--;
            if(arr[i] == 0) i++;
        }
