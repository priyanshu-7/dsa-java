class Playground {
    public static void main(String[ ] args) 
    {
        int arr[] = {100, 200, 300, 400}; int k = 2;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i<k; i++)
        {
            sum+=arr[i];
        }
        System.out.println(sum);
        for(int i = k; i<arr.length; i++)
        {
            sum+=arr[i]-arr[i-k]; //i = 2, k = 2, then remove arr[0] from the current window to handle the next window
            System.out.println(sum);
            maxSum = Math.max(sum, maxSum);
        }
        System.out.println("Max sum" + maxSum);
    }
}