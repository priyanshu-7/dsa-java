import java.util.*;
class Playground {
    public static void main(String[ ] args) 
    {
        String s = "AXYZ";
        String s1 = "BAZ";
        int m = s.length();
        int n = s1.length();
        int dp[][] = new int[m+1][n+1];
        for(int i = 1; i<=m; i++)
        {
            for(int j = 1; j<=n; j++)
            {
                if(s.charAt(i-1) == s1.charAt(j-1))
                {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else 
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
      String answer = "";
        //Go from bottom to top through the DP array following the same rules
        int i = m;
        int j = n;
        while(i>0 && j>0)
        {
            if(s.charAt(i-1) == s1.charAt(j-1))
            {
                answer+=s.charAt(i-1);
                i = i-1;
                j = j-1;
            }
            else 
            {
                if(dp[i-1][j]>dp[i][j-1])
                {
                    i = i-1;
                }
                else 
                {
                    j = j-1;
                }
            }
        }
        StringBuffer res = new StringBuffer(answer);
        res = res.reverse();
        System.out.println(res);
    }
}