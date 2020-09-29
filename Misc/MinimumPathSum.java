class Solution {
    public int minPathSum(int[][] grid) 
    {
        if(grid.length == 0) return 0;
        int dp[][] = new int[grid.length][grid[0].length];
        for(int i = 0; i<dp.length; i++)
        {
            for(int j = 0; j<dp[0].length; j++)
            {
                dp[i][j] +=grid[i][j];
                if(i>0 && j>0) //if we are not in the first row & first column
                {
                    dp[i][j]+=Math.min(dp[i-1][j], dp[i][j-1]); //add min of left or                                                                   above
                }
                else if(i>0) //if we are in the first column and j<=0
                {
                    dp[i][j] +=dp[i-1][j]; //just take the top value
                }
                else if(j>0) //if we are in the first row and i<=0
                {
                    dp[i][j] +=dp[i][j-1];//ake the previous value
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}