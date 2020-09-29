import java.util.*;
class Playground {
    public static void main(String[ ] args) 
    {
        int n = 4;
        int dp[] = new int[n+2]; //fib(n+1) == ways(n)
        dp[0] = 0; dp[1] = 1;
        for(int i = 2; i<dp.length; i++)
        {
            dp[i] = dp[i-1]+dp[i-2];
        }
        System.out.println(dp[dp.length-1]);
    }
}