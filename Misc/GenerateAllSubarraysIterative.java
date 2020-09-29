class Playground {
    public static void main(String[ ] args) 
    {
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;
        //Pick starting point
        for (int i=0; i <n; i++) 
        { 
            // Pick ending point 
            for (int j=i; j<n; j++) 
            { 
                // Print subarray between current starting 
                // and ending points 
                int current_sum = 0;
                for (int k=i; k<=j; k++) 
                {
                    current_sum+=arr[k];
                    System.out.print(arr[k]+" "); 
                }
                System.out.println(current_sum);
                System.out.println("");
            }
        } 
    }
}